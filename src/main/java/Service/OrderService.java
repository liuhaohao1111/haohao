package Service;

import Dao.OrderDao;
import Domain.Order;
import Domain.OrderDetail;

import java.util.List;

public interface OrderService {
    //订单表增加数据
    void save(Order order, List<OrderDetail> orderDetails);
    List<Order> query(int uid);
    List<OrderDetail> query(String oid);
}
