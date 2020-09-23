package Service.Impl;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Domain.User;
import Service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.queryByNameandPassword(username,password);
    }

    @Override
    public int register(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean activtion(String email, String code) {
        return userDao.active(email,code);
    }

    @Override
    public User checked(String username) {
        return userDao.check(username);
    }
}
