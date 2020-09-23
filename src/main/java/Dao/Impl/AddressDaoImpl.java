package Dao.Impl;

import Dao.AddressDao;
import Domain.Address;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    QueryRunner qr = new QueryRunner();
    @Override
    public List<Address> findAddressByUid(int uid) {
        Connection conn = DruidUtils.getConnection();
        String sql="select * from tb_address where uid = ?";
        try {
            return qr.query(conn,sql,new BeanListHandler<Address>(Address.class),uid);
        } catch (SQLException e) {
            throw new RuntimeException("查询地址失败");
        } finally {
            DruidUtils.closeAll(null,null,conn);
        }
    }

    @Override
    public void addAddress(Address address) {
        Connection conn = DruidUtils.getConnection();
        String sql="insert into tb_address(detail,name,phone,uid,level) values(?,?,?,?,?)";
        Object[] params={address.getDetail(),address.getName(),address.getPhone(),address.getUid(),address.getLevel()};
        try {
            qr.update(conn,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null,null,conn);
        }
    }

    @Override
    public void deleteAddress(int id) {
        Connection conn = DruidUtils.getConnection();
        String sql="delete from tb_address where id=?";
        Object[] params={id};
        try {
            qr.update(conn,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null,null,conn);
        }
    }
/*
    private int id;
    private String detail;
    private String name;
    private String phone;
    private int uid;
    private int level;
 */
    @Override
    public void updateAddress(Address address) {
        Connection conn = DruidUtils.getConnection();
        String sql="update tb_address set name=?,phone=?,detail=? where id=?";
        Object[] params={address.getName(),address.getPhone(),address.getDetail(),address.getId()};
        try {
            qr.update(conn,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null,null,conn);
        }
    }

    @Override
    public Address findAddressById(int id) {
        Connection conn = DruidUtils.getConnection();
        String sql="select * from tb_address where id = ?";
        try {
            return qr.query(conn,sql,new BeanHandler<Address>(Address.class),id);
        } catch (SQLException e) {
            throw new RuntimeException("查询地址失败");
        } finally {
            DruidUtils.closeAll(null,null,conn);
        }
    }
}
