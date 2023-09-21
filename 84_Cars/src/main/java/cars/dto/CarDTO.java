package cars.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "regNumber")
public class CarDTO {
    private long regNumber;
    private String color;
    private LocalDate purchaseDate;
    private String modelName;
    private int ownerId;
}
