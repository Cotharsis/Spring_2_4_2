package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    private final List<User>users=new ArrayList<User>();
    {Set <Role>roles = new HashSet<Role>();
        roles.add(new Role(2L, "ROLE_USER"));
        roles.add(new Role(2L, "ROLE_LUSER"));
        users.add(new User(2L,"Vovan","123", roles,
                "Vladislav",31,"Magnitogorsk"));}


    private final Map<String, User> userMap = Collections.singletonMap("test",
            new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER")),
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
        return null;
    }

    @Override
    public List<User> allUsers() {
        return users;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void delete(User user) {
       // users.remove(user);//??
    }

    @Override
    public void edit(User user) {

    }
}

