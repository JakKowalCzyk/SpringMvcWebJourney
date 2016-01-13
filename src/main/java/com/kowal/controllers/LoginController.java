package com.kowal.controllers;
import javax.servlet.http.HttpSession;
import com.kowal.User;
import com.kowal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Created by JK on 2016-01-13.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String createLogin(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logUser(@RequestParam String userId, @RequestParam String password, HttpSession httpSession, Model model){
        User user = userService.loginUser(userId, password);

        if(user == null){
            model.addAttribute("loginError", "Login error, try again");
            return "login";
        }
        model.addAttribute("logged", user);
       // httpSession.setAttribute("logged", user);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOutUser(HttpSession httpSession){
        httpSession.removeAttribute("logged");
        return "redirect:/login";
    }
}
