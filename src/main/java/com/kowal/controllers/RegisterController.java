package com.kowal.controllers;

import com.kowal.User;
import com.kowal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JK on 2016-01-13.
 */
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", params = "register")
    public String createRegister(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(User user){
        userService.saveUser(user);
        return "user/savedSucces";
    }
}
