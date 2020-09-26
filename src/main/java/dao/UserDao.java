package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserDao {
    @PersistenceContext(unitName = "pu")
    private EntityManager em;


    public void persist(User user){
        em.persist(user);
    }

    public void delete(User user){
        em.remove(user);
    }

    public  void update(User user){
        em.merge(user);
    }

    public List<User> getall(){
        List<User> users=em.createQuery("SELECT a From User a",User.class).getResultList();
        return users;
    }
}
