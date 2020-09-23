package Service.Impl;

import Dao.AddressDao;
import Dao.GoodsDao;
import Dao.Impl.AddressDaoImpl;
import Dao.Impl.GoodsDaoImpl;
import Dao.Impl.OrderDaoImpl;
import Dao.Impl.OrderDetailDaoImpl;
import Dao.OrderDao;
import Dao.OrderDetailDao;
import Domain.Address;
import Domain.Goods;
import Domain.Order;
import Domain.OrderDetail;
import Service.CartsService;
import Service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public void save(Order order, List<OrderDetail> orderDetails) {
        //订单表增加数据
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.add(order);

        //订单详情表增加数据
        OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetailDao.add(orderDetail);
        }
        //清空购物车
        CartsService cartsService = new CartsServiceImpl();
        cartsService.removeAll(order.getUid());
    }

    @Override
    public List<Order> query(int uid) {
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.query(uid);
        //根据地址id查询地址信息
        for (Order order : orders) {
            AddressDao addressDao = new AddressDaoImpl();
            Address address = addressDao.findAddressById(order.getAid());
            order.setAddress(address);
        }
        return orders;
    }

    @Override
    public List<OrderDetail> query(String oid) {
        OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
        List<OrderDetail> orderDetails = orderDetailDao.query(oid);
        if(orderDetails!=null){
            for (OrderDetail orderDetail : orderDetails) {
                GoodsDao goodsDao = new GoodsDaoImpl();
                Goods goods = goodsDao.findById(orderDetail.getPid());
                orderDetail.setGoods(goods);
            }
        }
        return orderDetails;
    }
}
