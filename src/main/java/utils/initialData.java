package utils;

import dao.UserDao;
import model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class initialData {

    @Inject
    UserDao userDao;

    @PostConstruct
    public void init() {

        User firstUser = new User();
        firstUser.setName("gonzalo");
        firstUser.setPassword("gonzalo");
        userDao.persist(firstUser);
        System.out.println("user perssited:::::");
    }
}
