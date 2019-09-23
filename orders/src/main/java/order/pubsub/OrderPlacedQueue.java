package order.pubsub;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms
public class OrderPlacedQueue {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(Channels.ORDER_PLACED_CHANNEL);
    }
}
