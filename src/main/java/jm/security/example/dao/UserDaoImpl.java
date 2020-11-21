package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    private  static int PEOPLE_COUNT;
    private final List<User>users=new ArrayList<User>();
    {Set <Role>roles = new HashSet<Role>();
        roles.add(new Role(2L, "ROLE_USER"));
        roles.add(new Role(2L, "ROLE_LUSER"));

        users.add(new User(++PEOPLE_COUNT,"Vovan","123",
                "Vladislav",31,"Magnitogorsk"));
        users.add(new User(++PEOPLE_COUNT,"Jask","123",
                "Jasika",19,"Varcuta"));}


    private final Map<String, User> userMap = Collections.singletonMap("test",
            new User(1, "test", "test",
                    "Arsenii",12,"Manxeten")); // name - уникальное значение, выступает в качестве ключа Map
//Collections.singleton(new Role(1L, "ROLE_USER")),
    @Override
    public User getUserByName(String name) {
        if (!userMap.containsKey(name)) {
            return null;
        }
        return userMap.get(name);
    }

    @Override
    public User getById(int id) {
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<User> allUsers() {
        return users;
    }

    @Override
    public void add(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    @Override
    public void delete(User user) {
//        users.removeIf(p -> p.getId() == id);
        users.remove(user);
    }

    @Override
    public void edit(User user) {
    }

    public void update(int id, User updatePerson){
        User personTobeUpdated = getById(id);
        personTobeUpdated.setName(updatePerson.getName());
        personTobeUpdated.setYear(updatePerson.getYear());
        personTobeUpdated.setAddress(updatePerson.getAddress());
    }
}

