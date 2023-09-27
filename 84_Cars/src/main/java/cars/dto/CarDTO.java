package cars.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "regNumber")
public class CarDTO {

    @Min(value = 1, message = "Reg number nust be in range from 1 to 1 000 000")
    @Max(value = 1000000, message = "Reg number nust be in range from 1 to 1 000 000")
    private long regNumber;

    @Size(min = 3, max = 15, message = "Color must contains from 3 to 15 character")
    private String color;
    @NotNull
    private LocalDate purchaseDate;

    @Pattern(regexp = "[a-zA-Z0-9]]*", message = "Use a-z A-Z and 0-9")
    private String modelName;
    private int ownerId;
}
