package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    public UserDaoImp() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void remove(int id) {
        entityManager.remove(show(id));
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User show(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }
}
