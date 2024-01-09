package ie.atu.order_microservice;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseDetails, Long> {
}
