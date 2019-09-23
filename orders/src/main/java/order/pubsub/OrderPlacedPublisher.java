package order.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class OrderPlacedPublisher {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void publish(Integer orderId) {
        jmsTemplate.convertAndSend(queue, orderId);
    }
}
