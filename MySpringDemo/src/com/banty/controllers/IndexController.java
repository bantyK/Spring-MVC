package com.banty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "index";
    }

    @RequestMapping("/welcome/{countryName}/{userName}")
    public ModelAndView helloWorld(@PathVariable Map<String, String> pathVars) {

        String userName = pathVars.get("userName");
        String countryName = pathVars.get("countryName");
        ModelAndView modelAndView = new ModelAndView("HelloPage");
        modelAndView.addObject("msg", "Hello," + userName + "!, How is " + countryName + "?");
        modelAndView.addObject("msg2", "Hello," + userName + "!, How is " + countryName + "?");
        return modelAndView;
    }

}