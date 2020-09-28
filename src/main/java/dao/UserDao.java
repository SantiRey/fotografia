package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        return em.createQuery("SELECT a From User a",User.class).getResultList();

    }

    public Optional<User> get(String name){
        try {
            return Optional.of(em.createQuery("SELECT a From User a WHERE a.name =: name", User.class)
                    .setParameter("name", name).getSingleResult());

        } catch (Exception e){
            return Optional.empty();
        }
    }
}
