package jm.security.example.controller;


import jm.security.example.dao.UserDaoImpl;
import jm.security.example.model.User;
import jm.security.example.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    private final UserDaoImpl userDao;

    public AdminController(UserService userService, UserDaoImpl userDao) {
        this.userService = userService;
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }


//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id){
//        model.addAttribute("persong",userService.getById(id));
//        return "people/edit";
//}

//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("bespol") User user, @PathVariable("id") int id) {
//        userDao.update(id, user);
//        return "redirect:/admin";
//    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        //modelAndView.addObject("user", userService.getById(id));
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userDao.update(id, user);
        //userService.edit(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.add(user);
        return modelAndView;
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }

}

