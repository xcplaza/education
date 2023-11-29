package extities;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import java.util.*;
import java.util.ArrayList;

@RedisHash
@Getter
public class ListProbeValues {
    long id;
    List<Integer> value = new ArrayList<>();

    public ListProbeValues(Long is) {
        super();
        this.id = id;
    }
}
