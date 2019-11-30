package org.launchcode.dismissal1.controllers;
import org.launchcode.dismissal1.models.data.ChangetransportationDao;
import org.launchcode.dismissal1.models.data.EarlyDao;
import org.launchcode.dismissal1.models.data.StudentDao;
import org.launchcode.dismissal1.models.data.UserDao;
import org.launchcode.dismissal1.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class LoginController {

    //Autowired-Springboot creates everything needed from DAO's to run controller
    @Autowired
    UserDao userDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    EarlyDao earlyDao;

    @Autowired
    ChangetransportationDao changetransportationDao;

    // Login Form Display
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "home/login";
    }

    //Login process form
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String loginProcess(@RequestParam String uname, @RequestParam String psw) {

        return "home/login";
    }

    //Display history of pick ups and transportation changes
    @RequestMapping(value = "log")
    public String log(Model model) {
        model.addAttribute("title", "Log");
        //model.addAttribute("early", earlyDao.findAllById(dismiss<  >));
        return "home/log";
    }

    //New Account form
    @RequestMapping(value = "newaccount", method = RequestMethod.GET)
    public String account(Model model) {
        model.addAttribute("title", "New Account Sign-up");
        model.addAttribute(new user());
        return "home/newaccount";
    }

    //New Account process form
    @RequestMapping(value = "newaccount", method = RequestMethod.POST)
    public String accountProcess(@ModelAttribute @Valid user user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "New Account Sign-up");
            return "home/newaccount";
        }
        userDao.save(user);
        return "home/log";

    }
    }

