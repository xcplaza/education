package telran.microservices.probes;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ListProbeValues;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.stream.binder.test.*;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.support.GenericMessage;
import repo.ListProbeRepo;
import org.springframework.messaging.Message;

import static org.junit.jupiter.api.Assertions.*;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
public class AvgReducerTest {
    private static final long PROBE_ID_NO_AVG = 123;
    private static final long PROBE_ID_AVG = 124;
    private static final long PROBE_ID_NO_VALUE = 125;
    private static final int VALUE = 100;
    private String bindingName = "";
    private String producerBindingName = "avrProducer-out-0";
    private String consumerBindingName = "avrConsumer-in-0";
    @Autowired
    InputDestination producer;
    @Autowired
    OutputDestination consumer;
    @MockBean
    ListProbeRepo listProbeRepo;
    static List<Integer> valuesNoAvg;
    static List<Integer> valuesAvg;
    static ListProbeValues listProbeNoAvg = new ListProbeValues(PROBE_ID_NO_AVG);
    static ListProbeValues listProbeAvg = new ListProbeValues(PROBE_ID_AVG);
    static HashMap<Long, ListProbeValues> redisMap = new HashMap<>();
    Probe probeNoValues = new Probe(PROBE_ID_NO_VALUE, VALUE);
    Probe probeNoAvg = new Probe(PROBE_ID_NO_AVG, VALUE);
    Probe probeAvg = new Probe(PROBE_ID_AVG, VALUE);

    @BeforeAll
    static void setUpAll() {
        valuesNoAvg = listProbeNoAvg.getValue();
        valuesAvg = listProbeAvg.getValue();
        valuesAvg.add(VALUE);
        redisMap.put(PROBE_ID_AVG, listProbeAvg);
        redisMap.put(PROBE_ID_NO_AVG, listProbeNoAvg);
    }

    @Test
    void probeNoValuesTest() {
        when(listProbeRepo.findById(PROBE_ID_NO_VALUE)).thenReturn(Optional.ofNullable(null));
        when(listProbeRepo.save(new ListProbeValues(PROBE_ID_NO_VALUE))).thenAnswer(new Answer<ListProbeValues>() {
            @Override
            public ListProbeValues answer(InvocationOnMock invocation) throws Throwable {
                redisMap.put(PROBE_ID_NO_VALUE, invocation.getArgument(0));
                return invocation.getArgument(0);
            }
        });
        producer.send(new GenericMessage<Probe>(probeNoValues), consumerBindingName);

        Message<byte[]> message = consumer.receive(100, producerBindingName);
        assertNull(message);
        assertEquals(VALUE, redisMap.get(PROBE_ID_NO_VALUE).getValue().get(0));
    }

    @Test
    void probeNoAvgTest() {
        when(listProbeRepo.findById(PROBE_ID_NO_AVG)).thenReturn(Optional.ofNullable(listProbeNoAvg));
        when(listProbeRepo.save(new ListProbeValues(PROBE_ID_NO_AVG))).thenAnswer(new Answer<ListProbeValues>() {
            @Override
            public ListProbeValues answer(InvocationOnMock invocation) throws Throwable {
                redisMap.put(PROBE_ID_NO_AVG, invocation.getArgument(0));
                return invocation.getArgument(0);
            }
        });
        producer.send(new GenericMessage<Probe>(probeNoValues), consumerBindingName);

        Message<byte[]> message = consumer.receive(100, producerBindingName);
        assertNull(message);
        assertEquals(VALUE, redisMap.get(PROBE_ID_NO_AVG).getValue().get(0));
    }

    @Test
    void probeAvgTest() throws Exception {
        when(listProbeRepo.findById(PROBE_ID_AVG)).thenReturn(Optional.ofNullable(listProbeAvg));
        when(listProbeRepo.save(new ListProbeValues(PROBE_ID_AVG))).thenAnswer(new Answer<ListProbeValues>() {
            @Override
            public ListProbeValues answer(InvocationOnMock invocation) throws Throwable {
                redisMap.put(PROBE_ID_AVG, invocation.getArgument(0));
                return invocation.getArgument(0);
            }
        });
        producer.send(new GenericMessage<Probe>(probeNoValues), consumerBindingName);

        Message<byte[]> message = consumer.receive(100, producerBindingName);
        assertNotNull(message);
        ObjectMapper mapper = new ObjectMapper();
        assertEquals(probeAvg, mapper.readValue(message.getPayload(), Probe.class));
        assertEquals(VALUE, redisMap.get(PROBE_ID_AVG).getValue().get(0));
    }
}
