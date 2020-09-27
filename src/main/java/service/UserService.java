package service;

import dao.UserDao;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;


public class UserService {

    List<User> users;

    User user;

    @Inject
    UserDao userDao;

    public List<User> getAllUsers(){
        users=userDao.getall();
        return users;
    }

    public void saveUser(User user){
        userDao.persist(user);
    }

    public User getSingleUser(String name){
        user=userDao.get(name);
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
