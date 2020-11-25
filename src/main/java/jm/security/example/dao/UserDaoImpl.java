package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


//    private final Map<String, User> userMap = new HashMap <String,User>();
//    {
//        userMap.put("test", new User(1, "test", "test",Collections.singleton(Role.ROLE_USER),
//                "Arsenii",12,"Manxeten")); // name - уникальное значение, выступает в качестве ключа Map}
//        userMap.put("test1", new User(2, "test1", "test", Collections.singleton(Role.ROLE_USER),
//                "Arsenii", 12, "Manxeten"));
//
//        List<User>users=allUsers();
// //       if(users!=null&&users.size()>0){
//            for (User user:users){
//                userMap.put(user.getUsername(),user);
//            }
//
//    }

    public User getUserByName(String name) {
        User user =(User) entityManager.createQuery("FROM User u where u.name = :name").setParameter("name", name).getSingleResult();
//        if (!userMap.containsKey(name)) {
//            return null;
//        }
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
