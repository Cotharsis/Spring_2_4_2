package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    private final Map<String, User> userMap = Collections.singletonMap("test",
            new User(1, "test", "test",Collections.singleton(new Role(1L, "ROLE_USER")),
                    "Arsenii",12,"Manxeten")); // name - уникальное значение, выступает в качестве ключа Map

    @Override
    public User getUserByName(String name) {
        if (!userMap.containsKey(name)) {
            return null;
        }
        return userMap.get(name);
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
        // entityManager.remove(user); // error 500
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

}

