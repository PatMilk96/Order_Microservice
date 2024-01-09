package ie.atu.order_microservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final ProductService productService;

    public OrderController(ProductService productService){
        this.productService = productService;
    }

    @PutMapping("/buy/{productId}/{amountWanted}")
    public String buyProduct(@PathVariable Long productId, @PathVariable int amountWanted){
        if(amountWanted < 0){
            return "Sorry, that's an invalid amount";
        }
        else return productService.buyProduct(productId, amountWanted);
    }
}
