package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.data.ChangetransportationDao;
import org.launchcode.dismissal1.models.data.EarlyDao;
import org.launchcode.dismissal1.models.data.StudentDao;
import org.launchcode.dismissal1.models.data.UserDao;
import org.launchcode.dismissal1.models.early;
import org.launchcode.dismissal1.models.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("home")
public class addstudentController {
    @Autowired
    UserDao userDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    EarlyDao earlyDao;

    @Autowired
    ChangetransportationDao changetransportationDao;

    static ArrayList<String> addstudent = new ArrayList<>();

    @RequestMapping(value = "sconfirmation")
    public String log(Model model) {
        model.addAttribute("title", "Confirmation");
        model.addAttribute("student", addstudent);
        return "home/sconfirmation";
    }
    //Display of Form
    @GetMapping(value = "addstudent")
    public String displayaddstudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute("student", new student());
        return "home/addstudent";
    }

    //Process Form
    @PostMapping(value = "addstudent")
    public String addstudentForm(@ModelAttribute @Valid student newstudent, Errors errors, Model model,@RequestParam String studentname) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Student");
            return "home/addstudent";
        }
        studentDao.save(newstudent);
        return "home/sconfirmation";
    }

    }

///validate drown down///