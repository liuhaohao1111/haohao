package Dao.Impl;

import Dao.GoodsDao;
import Domain.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    QueryRunner qr = new QueryRunner();

    @Override
    public List<Goods> findByType(int typeid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from tb_goods where typeid=?";
        try {
            return qr.query(connection, sql, new BeanListHandler<Goods>(Goods.class), typeid);
        } catch (Exception e) {
            throw new RuntimeException("查询失败", e);
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }

    @Override
    public Goods findById(int gid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from tb_goods where id=?";
        try {
            return qr.query(connection, sql, new BeanHandler<Goods>(Goods.class), gid);
        } catch (Exception e) {
            throw new RuntimeException("查询失败", e);
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }
}
