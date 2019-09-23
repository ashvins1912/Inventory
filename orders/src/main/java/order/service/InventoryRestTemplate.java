package order.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import order.config.ServicePath;
import order.constant.InventoryStatus;
import order.model.Inventory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class InventoryRestTemplate {

    @Autowired
    private ServicePath servicePath;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public List<Inventory> fetchAvailableInventory(Integer productId, Integer quantity) {
        List<Inventory> availableInventory = new ArrayList<>();
        logger.info("calling inventory service fetch");
        RestTemplate restTemplate = new RestTemplate();
        String enPoint = servicePath.getInventoryService() + "inventory/available-stock/" + productId + "/" + quantity;
        logger.info("Hitting inventory service at {}", enPoint);
        ResponseEntity<Inventory[]> response = restTemplate.getForEntity(enPoint, Inventory[].class);
        if (HttpStatus.OK.equals(response.getStatusCode()) && response.getBody() != null) {
            availableInventory = Arrays.asList(response.getBody());
        }
        logger.info("fetched records");
        return availableInventory;
    }

    public boolean blockInventory(Inventory inventory, Integer orderId) {
        inventory.setPurchasedOn(new Date());
        inventory.setOrderId(orderId);
        inventory.setInventoryStatus(InventoryStatus.BLOCKED.name());
        RestTemplate restTemplate = new RestTemplate();
        String enPoint = servicePath.getInventoryService() + "inventory/update";
        HttpEntity<Inventory> request = new HttpEntity<>(inventory);
        return "Success".equalsIgnoreCase(restTemplate
            .exchange(enPoint, HttpMethod.POST, request, String.class).getBody());
    }
    public boolean markSoldInventory(int orderId){
        String status="";
       try{
           String enPoint = servicePath.getInventoryService() + "inventory/update-status/"+orderId;
           RestTemplate restTemplate = new RestTemplate();
           status= restTemplate.getForEntity(enPoint,String.class).getBody();
       }
       catch (Exception ex){
           logger.info("caused exception in calling inventory");
       }
        return StringUtils.isBlank(status);


    }

}
