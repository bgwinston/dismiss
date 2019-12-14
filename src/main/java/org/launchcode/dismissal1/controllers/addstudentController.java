package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.Student;
import org.launchcode.dismissal1.models.data.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class addstudentController {


    @Autowired
    private StudentDao studentDao;

    //Show all students.
    @RequestMapping(value = "allStudents")
    public String showallstudentindex(Model model) {
        model.addAttribute("title", "All Students");
        model.addAttribute("Student", studentDao.findAll());
        return "home/allStudents";
    }

    //deletestudent
    //@RequestMapping(value="allStudents")
    //public

    @RequestMapping(value = "sconfirmation")
    public String log(Model model) {
        model.addAttribute("title", "Confirmation");
        return "home/sconfirmation";
    }
    //Display of Form
    @GetMapping(value = "addstudent")
    public String displayaddstudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute("Student", new Student());
        return "home/addstudent";
    }

    //Process Form
    @PostMapping(value = "addstudent")
    public String addstudentForm(@ModelAttribute @Valid Student newstudent, Errors errors, Model model, @RequestParam String studentname) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Student");
            return "home/addstudent";
        }
        studentDao.save(newstudent);
        return "home/sconfirmation";
    }


}

