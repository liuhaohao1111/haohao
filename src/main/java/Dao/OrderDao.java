package Dao;

import Domain.Order;

import java.util.List;

public interface OrderDao {

    void add(Order order);
    List<Order> query(int uid);
}
