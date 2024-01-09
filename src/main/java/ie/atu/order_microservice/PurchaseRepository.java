package ie.atu.order_microservice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PurchaseRepository extends JpaRepository<PurchaseDetails, Long> {
    boolean existsByTrackingNumber(String trackingNumber);

    @Modifying
    @Query("UPDATE PurchaseDetails p SET p.orderStatus = :updateStatus WHERE p.trackingNumber = :trackingNumber")
    void updateOrderStatus(@Param("trackingNumber") String trackingNumber, @Param("updateStatus")String updateStatus);
}
