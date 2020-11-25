package jm.security.example.service;

import jm.security.example.dao.UserDao;
import jm.security.example.model.User;
//import jm.security.example.repository.UserRepository;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;
  //  private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

//    public UserDetailsServiceImpl(UserDao userDao, UserRepository userRepository) {
//        this.userDao = userDao;
//        this.userRepository = userRepository;
//    }

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(s).orElseThrow(() ->
//                new UsernameNotFoundException("User doesn't exists"));
//        return SecurityUser.fromUser(user);
      return userDao.getUserByName(s);
    }
}
