package order.contoller;

import java.util.Date;
import order.constant.OrderStatus;
import order.model.Order;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    ResponseEntity creatOrder(@RequestBody Order order) {
        order.setUserId(1);
        orderService.createOrder(order);
        return ResponseEntity.ok(order);
    }

}
