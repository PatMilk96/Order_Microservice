package ie.atu.order_microservice;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final ProductService productService;
    private final PurchaseService purchaseService;

    public OrderController(ProductService productService, PurchaseService purchaseService){
        this.productService = productService;
        this.purchaseService = purchaseService;
    }

    @PutMapping("/buy/{productId}/{amountWanted}")
    public String buyProduct(@PathVariable Long productId, @PathVariable int amountWanted){
        if(amountWanted < 0){
            return "Sorry, that's an invalid amount";
        }
        else{
            String result = productService.buyProduct(productId, amountWanted);
            if (isTrackingNumber(result)) {
                long currentTimeInMillis = System.currentTimeMillis();
                Date currentDate = new Date(currentTimeInMillis);
                String currentDateTime = currentDate.toString();
                PurchaseDetails purchaseDetails = new PurchaseDetails(currentDateTime, result, "Processing");
                purchaseService.addOrder(purchaseDetails);
                return "Thank You for your purchase, your tracking number is " + result;
            }
            else{
                return result;
            }
        }
    }

    @PutMapping("/updateOrder/{trackingNumber}/{updateStatus}")
    public String updateOrderStatus(@PathVariable String trackingNumber, @PathVariable String updateStatus){
        return purchaseService.updateOrder(trackingNumber, updateStatus);
    }


    private boolean isTrackingNumber(String result){
        if(result.contains("Sorry, we only have")){
            return false;
        }
        else return !result.contains("We're sorry, but this product is out of stock");
    }
}
