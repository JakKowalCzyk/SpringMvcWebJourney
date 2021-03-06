package com.kowal.controllers;

import com.kowal.City;
import com.kowal.Journey;
import com.kowal.User;
import com.kowal.dao.JourneyDao;
import com.kowal.dao.NumberDao;
import com.kowal.service.CityService;
import com.kowal.service.JourneyService;
import com.kowal.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Created by JK on 2016-01-14.
 */
@Controller
@SessionAttributes({"user"})
public class JourneyController {
    @Autowired
    private CityService cityService;

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private NumberService numberService;

    private User user;
    private int whatNumber;

    @RequestMapping(value = "/addJourney", method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute  User user) {
        this.user = user;
        whatNumber = numberService.WhatJourneyNumber(user);
        return new ModelAndView("addJourney", "cities", cityService.findAllCities());
    }
    @RequestMapping(value = "/addJourney", method = RequestMethod.POST)
    public ModelAndView saveJourney(City city){
        journeyService.addOneJourney(city.getName(), user, whatNumber);
        return new ModelAndView("addJourney", "cities", cityService.findAllCities());
    }

    @RequestMapping(value = "/addJourneySomeones", method = RequestMethod.POST)
    public ModelAndView saveSomeonesJourney(@RequestParam String cityId){
        journeyService.addOneJourney(cityId, user, whatNumber);
        return new ModelAndView("addJourney", "cities", cityService.findAllCities());
    }
}
