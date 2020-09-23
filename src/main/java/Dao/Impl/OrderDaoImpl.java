package Dao.Impl;

import Dao.OrderDao;
import Domain.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*

Create Table

CREATE TABLE `tb_order` (
  `id` varchar(100) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_uid` (`uid`),
  KEY `fk_order_aid` (`aid`),
  CONSTRAINT `fk_order_aid` FOREIGN KEY (`aid`) REFERENCES `tb_address` (`id`),
  CONSTRAINT `fk_order_uid` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */
public class OrderDaoImpl implements OrderDao {
    QueryRunner qr = new QueryRunner();
    @Override
    public void add(Order order) {
        Connection connection = DruidUtils.getConnection();
        String sql= "insert into tb_order(id,uid,money,status,time,aid) values(?,?,?,?,?,?)";
        Object[] params = {order.getId(),order.getUid(),order.getMoney(),order.getStatus(),order.getTime(),order.getAid()};
        try {
            qr.update(connection,sql,params);
        } catch (SQLException e) {
            throw new RuntimeException("添加订单失败",e);
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
    }

    @Override
    public List<Order> query(int uid) {
        Connection connection = DruidUtils.getConnection();
        String sql= "select * from tb_order where uid = ?";
        try {
             return qr.query(connection,sql,new BeanListHandler<Order>(Order.class),uid);
        } catch (SQLException e) {
            throw new RuntimeException("查询订单失败",e);
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
    }
}
