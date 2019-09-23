package order.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import order.constant.ItemStatus;
import order.constant.OrderStatus;
import order.dao.ItemDao;
import order.dao.OrderDao;
import order.model.Inventory;
import order.model.LineItem;
import order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InventoryRestTemplate inventoryRestTemplate;


    @Transactional
    public boolean createOrder(Order order) {
        List<Inventory> listofInventory = new ArrayList<>();
        if(CollectionUtils.isEmpty(order.getLineItems())) {
            return false;
        }
        for(LineItem item : order.getLineItems()) {
            List<Inventory> inventories = inventoryRestTemplate
                .fetchAvailableInventory(item.getProductId(), item.getQuantity());
            if(CollectionUtils.isEmpty(inventories)) {
                return false;
            }
            item.setSellingPrice(inventories.get(0).getSellingPrice());
            item.setPurchasedOn(new Date());
            item.setItemStatus(ItemStatus.IN_PROCESS.name());
            listofInventory.addAll(inventories);
        }

        double totalAmount = listofInventory.stream().map(Inventory::getSellingPrice)
            .reduce(0.0,Double::sum);
        order.setOrderAmount(totalAmount);
        order.setOrderPlacedDate(new Date());
        order.setOrderStatus(OrderStatus.IN_PROCESS.name());
        boolean isOrderInserted = orderDao.createOrder(order) == 1;
        if(isOrderInserted) {
            for(LineItem lineItem : order.getLineItems()) {
                lineItem.setOrderId(order.getId());
            }
            boolean isItemInserted = itemDao.insertItem(order.getLineItems()) > 0;
            if(isItemInserted) {
                listofInventory.forEach(inventory -> {
                    inventoryRestTemplate.blockInventory(inventory, order.getId());
                });
            }
        }
        return true;
    }
}
