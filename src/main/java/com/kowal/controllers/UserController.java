package com.kowal.controllers;

import com.kowal.Journey;
import com.kowal.User;
import com.kowal.service.JourneyService;
import com.kowal.service.NumberService;
import com.kowal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *

 * Created by JK on 2016-01-13.
 */
@Controller
@SessionAttributes({"user"})
public class UserController {

    @Autowired
    private NumberService numberService;
    @Autowired
    private JourneyService journeyService;
    private User user;
    private ArrayList<Integer> numbersList;


    @RequestMapping(value = "/user/userPanel", method = RequestMethod.GET)
    public ModelAndView createUserPanel(@ModelAttribute  User user, ModelMap modelMap){
        this.user = user;
        numbersList = numberService.getNumberList(user);
        modelMap.addAttribute("user", user);
        return new ModelAndView("user/userPanel" , "numberList", numbersList);
    }

    @RequestMapping(value = "/user/userPanel", method = RequestMethod.POST)
    public String addJourney(ModelMap modelMap){
        modelMap.addAttribute(user);
        return "redirect:/addJourney";
    }

    @RequestMapping(value = "/userPanel", method = RequestMethod.POST)
    public String seeJourney(ModelMap modelMap, @RequestParam("number") Integer number){
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("number", number);
        return "redirect:/displayOneJourney";
    }

    @RequestMapping(value = "/userPanelRemove", method = RequestMethod.POST)
    public ModelAndView removeOneJourney(@RequestParam("number") Integer number){
        journeyService.removeJourney(user.getId(), (long) number);
        numberService.removeNumber(user.getId(), (long) number);
        numbersList = numberService.getNumberList(user);
        return new ModelAndView("user/userPanel" , "numberList", numbersList);

    }

    @RequestMapping(value = "/userPanelJourneyUp", method = RequestMethod.POST)
    public String upJourney(ModelMap modelMap, @RequestParam("number") Integer number){
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("number", number);
        return "redirect:/upOneJourney";
    }

}
