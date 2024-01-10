package ie.atu.order_microservice;

import jakarta.transaction.Transactional;
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

    @Transactional
    public String updateOrder(String trackingNumber, String updateStatus){
        if(purchaseRepository.existsByTrackingNumber(trackingNumber)){
            purchaseRepository.updateOrderStatus(trackingNumber, updateStatus);
            return "Status Updated";
        }
        else return "Tracking Number not found";
    }

    public String orderStatus(String trackingNumber) {
        if(purchaseRepository.existsByTrackingNumber(trackingNumber)){
            PurchaseDetails purchaseDetails = purchaseRepository.findByTrackingNumber(trackingNumber);
            return purchaseDetails.getOrderStatus();
        } else {
            return "Order not found";
        }
    }
}
