package karmiel;

import dto.EmailData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import service.DataProvider;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@WebMvcTest
class DataProviderControllerTestTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DataProvider dataProvider;
    EmailData emailData = new EmailData(new String[]{"vasya@gmail.com", "petya@gmail.com"}, new String[]{"vasya", "petya"});

    @Test
    void dataExist() {
        when(dataProvider.getEmailData(123)).thenReturn(emailData);
    }
}