package Dao.Impl;

import Dao.UserDao;
import Domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner();
    @Override
    public User queryByNameandPassword(String username, String password) {
        Connection conn = DruidUtils.getConnection();
        String sql = "select * from tb_user where username=?and password=?";
        Object[] params={username,password};
        try {
            return qr.query(conn,sql,new BeanHandler<User>(User.class),params);
        } catch (SQLException e) {
            throw new RuntimeException("查询失败");
        }finally {
            DruidUtils.closeAll(null,null,conn);
        }
    }

    @Override
    public int insert(User user) {
        Connection conn = DruidUtils.getConnection();
        String sql = "insert into tb_user(username,password,email,gender,flag,role,code) values(?,?,?,?,?,?,?);";
        Object[] params= {user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode()};
        int i=0;
        try {
              i=qr.update(conn,sql,params);
        } catch (Exception e) {
            throw new RuntimeException("添加失败");
        }finally {
            DruidUtils.closeAll(null,null,conn);
        }
        return i;
    }

    @Override
    public boolean active(String email, String code) {
        Connection connection = DruidUtils.getConnection();
        String sql ="update tb_user set flag=1 where email=? and code=?;";
        Object[] params = {email,code};
        try {
            int i = qr.update(connection,sql,params);
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
        return false;
    }

    @Override
    public User check(String username) {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from tb_user where username=?";
        try {
             return qr.query(connection,sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            throw new RuntimeException("查询失败");
        } finally {
            DruidUtils.closeAll(null,null,connection);
        }
    }


}
