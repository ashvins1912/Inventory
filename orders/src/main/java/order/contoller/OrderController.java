package order.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @GetMapping(value = "/hello")
    ResponseEntity<String> getFirstCall(){
        return ResponseEntity.ok("Hello order");
    }

    @GetMapping(value = "/call")
    ResponseEntity<String> callProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:1002/hello";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
       return ResponseEntity.ok().body(response).getBody();
    }

}
