package com.kowal.controllers;

import com.kowal.dao.CityDao;
import com.kowal.dao.ProductDao;
import com.kowal.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Created by JK on 2016-01-11.
 */
@Controller
public class HomeController {
    @Autowired
    private CityService cityService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home(Model modelMap) {
//        modelMap.addAttribute("cities", cityService.findAllCities());
//        return "home";
//    }
//    @RequestMapping(value="/table")
//    public ModelAndView renderTable() {
//        ModelAndView mv = new ModelAndView("/table");
//        mv.addObject("cities",cityService.findAllCities());
//        return mv;
//    }
   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model){
        return "home";
    }
}
