package Dao.Impl;

import Dao.CartsDao;
import Domain.Carts;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartsDaoImpl implements CartsDao {
    QueryRunner qr = new QueryRunner();

    @Override
    public Carts findByUidAndUid(int uid, int pid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from tb_cart where id=? and pid=?";
        Object[] params = {uid, pid};
        try {
            return qr.query(connection, sql, new BeanHandler<Carts>(Carts.class), params);
        } catch (SQLException e) {
            throw new RuntimeException("查询错误");
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }

    @Override
    public void addCarts(Carts carts) {
        Connection connection = DruidUtils.getConnection();
        String sql = "insert into tb_cart(id,pid,Num,money) values(?,?,?,?)";
        Object[] params = {carts.getId(), carts.getPid(), carts.getNum(), carts.getMoney()};
        try {
            qr.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }

    @Override
    public void update(Carts carts) {
        Connection connection = DruidUtils.getConnection();
        String sql = "update tb_cart set num=?,money=? where id=? and pid=?";
        Object[] params = {carts.getNum(), carts.getMoney(), carts.getId(), carts.getPid()};
        try {
            qr.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException("更新失败", e);
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }

    @Override
    public List<Carts> findById(int uid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from tb_cart where id=?";
        Object[] params = {uid};
        try {
            return qr.query(connection, sql, new BeanListHandler<Carts>(Carts.class), params);
        } catch (SQLException e) {
            throw new RuntimeException("查询错误");
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }

    @Override
    public void deleteonlyByPid(int pid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "delete from tb_cart where pid=?";
        try {
            qr.update(connection, sql,pid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }

    @Override
    public void deleteByPid(int id, int pid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "delete from tb_cart where id = ? and pid=?";
        try {
            qr.update(connection, sql, id, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }

    @Override
    public void removeAll(int uid) {
        Connection connection = DruidUtils.getConnection();
        String sql = "delete from tb_cart where id = ?";
        try {
            qr.update(connection, sql,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null, null, connection);
        }
    }
}
