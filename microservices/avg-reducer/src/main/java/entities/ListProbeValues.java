package entities;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ListProbeValues that = (ListProbeValues) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
