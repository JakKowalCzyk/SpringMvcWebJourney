package com.kowal.controllers;

import com.kowal.User;
import com.kowal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by JK on 2016-01-13.
 */
@Controller
//@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", params = "register")
    public String createRegister(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(User user){
//        if(result.hasErrors()){
//            return "user/register";
//        }
        userService.saveUser(user);
        return "user/savedSucces";
    }
}
