package Dao.Impl;

import Dao.GoodsTypeDao;
import Domain.GoodsType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GoodsTypeImpl implements GoodsTypeDao {
    QueryRunner qr = new QueryRunner();
    @Override
    public List<GoodsType> findTypeBylevel(int level) {
        Connection connection = DruidUtils.getConnection();
        String sql="select * from tb_goods_type where level=?;";
        try {
            return qr.query(connection,sql,new BeanListHandler<GoodsType>(GoodsType.class),level);
        } catch (SQLException e) {
            throw new RuntimeException("查询失败");
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
    }

    @Override
    public GoodsType findByid(int typeid) {
        Connection connection = DruidUtils.getConnection();
        String sql="select * from tb_goods_type where id=?;";
        try {
            return qr.query(connection,sql,new BeanHandler<GoodsType>(GoodsType.class),typeid);
        } catch (SQLException e) {
            throw new RuntimeException("查询失败");
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
    }
}
