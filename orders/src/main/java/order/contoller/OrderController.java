package order.contoller;

import java.util.Date;
import order.constant.OrderStatus;
import order.model.Order;
import order.pubsub.OrderPlacedPublisher;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderPlacedPublisher orderPlacedPublisher;

    @PostMapping("/create")
    ResponseEntity creatOrder(@RequestBody Order order) {
        order.setUserId(1);
        orderService.createOrder(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/confirm/{orderId}")
    ResponseEntity<Boolean> confirmOrder(@PathVariable("orderId") int orderId) {
        //orderService.confirmOrder(orderId);
        orderPlacedPublisher.publish(orderId);
      return ResponseEntity.accepted().body(true);
    }
}
