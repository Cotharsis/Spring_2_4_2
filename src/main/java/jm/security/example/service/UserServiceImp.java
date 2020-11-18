package jm.security.example.service;

import jm.security.example.dao.UserDao;
import jm.security.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDAO;

    @Autowired
    public UserServiceImp(UserDao userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    //@Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
   // @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
  //  @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
   // @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
   // @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }

}

