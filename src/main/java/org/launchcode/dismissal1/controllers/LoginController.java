package org.launchcode.dismissal1.controllers;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Scanner;


@Controller
@RequestMapping("home")
public class LoginController {

    static ArrayList<String>uname= new ArrayList<>();

    @RequestMapping(value = "")
    public String login(Model model) {



        model.addAttribute("title", "Login");
        return "home/login";
    }


    //Display history of pick ups and transportation changes
    @RequestMapping(value = "log")
    public String log(Model model) {
        model.addAttribute("title", "Log");
        return "home/log";
    }

    @RequestMapping(value = "newaccount", method= RequestMethod.GET)
    public String account(Model model) {
        model.addAttribute("title", "New Account Sign-up");
        return "home/newaccount";
    }
    @RequestMapping(value = "newaccount", method= RequestMethod.POST)
    public String accountProcess (@RequestParam String uname_field, @RequestParam String psw_field) {
        uname.add(uname_field);
        return "home/newaccount";
    }
    @RequestMapping(value = "childsearch")
    public String childSearch(Model model) {
        model.addAttribute("title", "Search for your Child");
        return "home/childsearch";
    }
}
