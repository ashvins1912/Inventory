package order.dao;

import order.model.LineItem;
import order.model.Order;

import java.util.List;

public interface OrderDao {

    int createOrder(Order order);

    int updateOrderStatus(Order order);

    List<LineItem> fetchInvoiceItem(Order order);

}
