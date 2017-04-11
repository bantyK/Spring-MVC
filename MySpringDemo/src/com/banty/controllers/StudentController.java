package com.banty.controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vuclip on 09/04/17.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/form.html", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("StudentForm");
        return modelAndView;
    }

    @RequestMapping(value = "/submit.html", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("student") Student student) {
        ModelAndView modelAndView = new ModelAndView("StudentData");
        return modelAndView;
    }
}
