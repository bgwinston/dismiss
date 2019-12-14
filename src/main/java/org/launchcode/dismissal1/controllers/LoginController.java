
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

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
        model.addAttribute("title", "The Dismissal App");
        return "home/login";
    }

    //Get User object from data,
//compare User object( Password) to database(password)
//If passwords match then return log template
//else return login page with error message
    //Login process form
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String loginProcess(Model model) {
        model.addAttribute("message", "Invalid Username");
        model.addAttribute("title", "The Dismissal App");
        return "home/login";
    }

    //Display history of pick ups
    @RequestMapping(value = "index")
    public String log(Model model) {
        model.addAttribute("title", "Early Pick Up Log");
        model.addAttribute("early", earlyDao.findAll());
        return "home/index";
    }

//Show all students.
    @RequestMapping(value = "allStudents")
    public String showallstudentindex(Model model) {
        model.addAttribute("title", "All Students");
        model.addAttribute("", studentDao.findAll());
        return "home/allStudents";
    }


    //Display history of transportation changes
    @RequestMapping(value = "indext")
    public String log1(Model model) {
        model.addAttribute("title", "Change of Transportation Log");
        model.addAttribute("early", changetransportationDao.findAll());
        return "home/indext";
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




