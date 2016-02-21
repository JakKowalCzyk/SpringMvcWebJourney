package com.kowal.controllers;
import javax.servlet.http.HttpSession;
import com.kowal.User;
import com.kowal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Created by JK on 2016-01-13.
 */
@Controller
@SessionAttributes({"user"})
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String createLogin(){
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String logUser(@RequestParam String userId, @RequestParam String password,
                          ModelMap modelMap, Model model){
        User user = userService.loginUser(userId, password);

        if(user == null){
            model.addAttribute("loginError", "Login error, try again");
            return "login";
        }
        modelMap.addAttribute(user);
        return "redirect:/user/userPanel";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOutUser(HttpSession httpSession){
        httpSession.removeAttribute("logged");
        return "redirect:/login";
    }
}
