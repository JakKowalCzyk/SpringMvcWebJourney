package com.kowal.controllers;

import com.kowal.Journey;
import com.kowal.User;
import com.kowal.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by JK on 2016-03-22.
 */
@Controller
@SessionAttributes({"user"})
public class UpdateController {
    @Autowired
    private JourneyService journeyService;

    private User user;

    @RequestMapping(value = "/upOneJourney", method = RequestMethod.GET)
    public ModelAndView updateJourney(@ModelAttribute("user") User user, Integer number, ModelMap modelMap){
        modelMap.getOrDefault("number", number);
        this.user = user;
        List<Journey> journeyList = journeyService.findJourney(user.getId(), (long) number);
        return new ModelAndView("/update",  "journeyList", journeyList);
    }
}
