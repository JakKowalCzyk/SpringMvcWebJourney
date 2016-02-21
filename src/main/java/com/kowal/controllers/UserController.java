package com.kowal.controllers;

import com.kowal.User;
import com.kowal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by JK on 2016-01-13.
 */
@Controller
@SessionAttributes({"user"})
public class UserController {

    private User user;

    @RequestMapping(value = "/user/userPanel", method = RequestMethod.GET)
    public String createUserPanel(@ModelAttribute  User user){
        this.user = user;
        return "/user/userPanel";
    }

    @RequestMapping(value = "/user/userPanel", method = RequestMethod.POST)
    public String addProducts(ModelMap modelMap){
        modelMap.addAttribute(user);
        return "redirect:/addJourney";
    }
}
