package service;

import dao.UserDao;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


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

    public Optional<User> getSingleUser(String name){
        if(userDao.get(name).isPresent()){
            user=userDao.get(name).get();
            return Optional.of(user);
        }else{
            return Optional.empty();
        }


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
