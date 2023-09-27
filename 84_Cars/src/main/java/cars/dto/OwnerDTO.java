package cars.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class OwnerDTO {
    private int id;
    private String name;
    private int birthYear;
}
