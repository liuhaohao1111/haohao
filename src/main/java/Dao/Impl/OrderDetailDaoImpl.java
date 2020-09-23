package Dao.Impl;

import Dao.OrderDetailDao;
import Domain.OrderDetail;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*

Create Table

CREATE TABLE `tb_orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Oid` varchar(100) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `Money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_pid` (`pid`),
  KEY `fk_order_id` (`Oid`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`Oid`) REFERENCES `tb_order` (`id`),
  CONSTRAINT `fk_order_pid` FOREIGN KEY (`pid`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */
public class OrderDetailDaoImpl implements OrderDetailDao {
    QueryRunner qr = new QueryRunner();
    @Override
    public void add(OrderDetail orderDetail) {
        Connection connection = DruidUtils.getConnection();
        String sql= "insert into tb_orderdetail(oid,pid,num,money) values(?,?,?,?);";
        Object[] params = {orderDetail.getOid(),orderDetail.getPid(),orderDetail.getNum(),orderDetail.getMoney()};
        try {
            qr.update(connection,sql,params);
        } catch (SQLException e) {
            throw new RuntimeException("添加订单详情失败",e);
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
    }

    @Override
    public List<OrderDetail> query(String oid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from tb_orderdetail where oid=?";
        try {
            return qr.query(connection,sql,new BeanListHandler<OrderDetail>(OrderDetail.class),oid);
        } catch (SQLException e) {
            throw  new RuntimeException("查询失败",e);
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
    }
}
