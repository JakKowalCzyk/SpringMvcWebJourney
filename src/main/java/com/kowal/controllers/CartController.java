package com.kowal.controllers;

import com.kowal.beans.Cart;
import com.kowal.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.Locale;

/**
 * Created by JK on 2016-01-11.
 */
@Controller
public class CartController {
    @Autowired
    private Cart cart;
    @Autowired
    private CityService cityService;

//    @RequestMapping(value = "/cart", method = RequestMethod.GET)
//    public String showCart(Model model){
//        model.addAttribute(cart);
//        return "cart";
//    }
//    @RequestMapping(value="/table", method = RequestMethod.POST)
//    public String renderTable(Model model) {
////        ModelAndView mv = new ModelAndView("/table");
////        mv.addObject("cart", "cities",cityService.findAllCities());
//        model.addAttribute("cities", cityService.findAllCities());
//        return "cart";
@RequestMapping(value = "/cart", method = RequestMethod.GET)
public ModelAndView home(Locale locale) {
    System.out.println(cityService.toString());
    return new ModelAndView("cart", "cities", cityService.findAllCities());
}


}
