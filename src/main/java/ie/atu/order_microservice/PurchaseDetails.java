package ie.atu.order_microservice;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Date cannot be empty")
    private String dateOrdered;

    @NotBlank(message = "Tracking number cannot be empty")
    private String trackingNumber;

    @NotBlank(message = "Order Status cannot be empty")
    private String orderStatus;

    public PurchaseDetails(String dateOrdered, String trackingNumber, String orderStatus) {
        this.dateOrdered = dateOrdered;
        this.trackingNumber = trackingNumber;
        this.orderStatus = orderStatus;
    }
}
