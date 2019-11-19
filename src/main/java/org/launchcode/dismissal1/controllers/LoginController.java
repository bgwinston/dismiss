package org.launchcode.dismissal1.controllers;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Scanner;


@Controller
@RequestMapping("home")
public class LoginController {

    @RequestMapping(value = "")
    public String selection(Model model) {
        model.addAttribute("title", "Login");
        return "home/login";
    }

    @RequestMapping(value = "log")
    public String log(Model model) {
        model.addAttribute("title", "Log");
        return "home/log";
    }

    @RequestMapping(value = "newaccount")
    public String account(Model model) {
        model.addAttribute("title", "New Account Sign-up");
        return "home/newaccount";
    }

    @RequestMapping(value = "childsearch")
    public String childSearch(Model model) {
        model.addAttribute("title", "Search for your Child");
        return "home/childsearch";
    }
}
