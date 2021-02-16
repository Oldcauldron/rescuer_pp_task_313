package jm.pp.rescuer313.service;

import jm.pp.rescuer313.dao.UserDao;
import jm.pp.rescuer313.model.User;

import java.util.Set;

public interface UserService {
    User findByLogin(String login);
    void addNewUser(User user);
    Set<User> findAllUsers();
    User findUserById(long id);
    void deleteUserById(long id);
    void updateUser(User user);

}
