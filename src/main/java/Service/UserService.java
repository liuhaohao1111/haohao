package Service;

import Domain.User;

public interface UserService {
    User login(String username, String password);
    int register(User user);
    boolean activtion(String email, String code);
    User checked(String username);
}
