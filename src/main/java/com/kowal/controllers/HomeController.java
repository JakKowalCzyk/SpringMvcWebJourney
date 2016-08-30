package com.kowal.controllers;

import com.kowal.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JK on 2016-01-11.
 */
@Controller
public class HomeController {
    @Autowired
    private CityService cityService;

   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model){
        return "home";
    }
}
