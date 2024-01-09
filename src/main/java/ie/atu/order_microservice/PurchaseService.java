package ie.atu.order_microservice;

import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    public void addOrder(PurchaseDetails purchaseDetails) {
        purchaseRepository.save(purchaseDetails);
    }
}
