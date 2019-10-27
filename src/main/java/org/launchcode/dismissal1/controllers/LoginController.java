package org.launchcode.dismissal1.controllers;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Scanner;


@Controller
@RequestMapping("home")

public class LoginController {

    @RequestMapping(value = "")
    public String selection(Model model) {
        model.addAttribute("title", "Welcome to The Dismissal App");
        return "home/login";
    }

    @RequestMapping(value= "transportation")
    public String transportation (Model model) {
        model.addAttribute("title","Dismissal App");
        return "home/transportation";
    }

    @RequestMapping(value= "early")
    @ResponseBody
    public String early(){
        return "hey";
    }
}
