package jm.security.example.dao;

import jm.security.example.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public User getUserByName(String name) {
        User user =(User) entityManager.createQuery("FROM User u where u.username = :username")
                .setParameter("username", name).getSingleResult();

        return user;
    }

    @Override
    public User getById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> allUsers() {
        List<User> user = entityManager.createQuery("from User", User.class).setMaxResults(Integer.MAX_VALUE).getResultList();
        return user;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id", user.getId()).executeUpdate();

    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

}
