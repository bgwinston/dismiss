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

        static ArrayList<String> log = new ArrayList<>();

    @RequestMapping(value = "sconfirmation")
    public String log(Model model) {
        model.addAttribute("title", "Confirmation");
        //model.addAttribute("early", earlyDao.findAllById(dismiss<  >));
        return "home/sconfirmation";
    }
        //Display of Form
    @RequestMapping(value = "addstudent", method = RequestMethod.GET)
     public String displayaddstudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute("student", new student());
        return "home/addstudent";
        }

        //Process Form
     @RequestMapping(value = "addstudent", method = RequestMethod.POST)
     public String addstudentForm(@ModelAttribute @Valid student student, Errors errors, @PathVariable ("studentname")String studentname) {
        if (errors.hasErrors()) {
            return "home/addstudent";
            }
        studentDao.save(student);
        return "home/sconfirmation";
        }

    }

