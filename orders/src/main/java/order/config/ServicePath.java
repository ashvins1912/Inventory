package order.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service-path")
public class ServicePath {

    private String inventoryService;

    public String getInventoryService() {
        return inventoryService;
    }

    public void setInventoryService(String inventoryService) {
        this.inventoryService = inventoryService;
    }
}
