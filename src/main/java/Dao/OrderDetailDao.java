package Dao;

import Domain.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    void add(OrderDetail orderDetail);
    List<OrderDetail> query(String oid);
}
