package ie.atu.order_microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "product-service", url = "http://product-service:8080")
public interface ProductService {
    @PutMapping("/products/buy/{productId}/{amountWanted}")
    String buyProduct(@PathVariable Long productId, @PathVariable int amountWanted);
}
