package ie.atu.order_microservice;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotNull(message = "price cannot be empty")
    @Min(1)
    private Double price;

    @NotNull(message = "Product Code cannot be empty")
    private Long productCode;

    @NotNull(message = "Product amount cannot be empty")
    @Min(0)
    private Integer amount;
}
