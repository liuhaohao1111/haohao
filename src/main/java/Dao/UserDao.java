package Dao;

import Domain.User;

public interface UserDao {
    //查询用户
    User queryByNameandPassword(String username, String password);
    //注册
    int insert(User user);
    //激活用户
    boolean active(String email, String code);
    //检查用户名是否可用
    User check(String username);
}
