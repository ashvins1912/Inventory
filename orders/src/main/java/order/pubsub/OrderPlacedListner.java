package order.pubsub;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedListner {
    @JmsListener(destination = Channels.ORDER_PLACED_CHANNEL)
    public void listener(String msg){
        System.out.println("Received Message : " + msg);
    }
}
