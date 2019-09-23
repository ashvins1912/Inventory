package order.dao;

import java.util.List;
import order.model.LineItem;

public interface ItemDao {

    int insertItem(List<LineItem> lineItems);

}
