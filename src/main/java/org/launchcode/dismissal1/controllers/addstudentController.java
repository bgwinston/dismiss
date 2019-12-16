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
        model.addAttribute("student", studentDao.findAll());
        return "home/allStudents";
    }

    @GetMapping(value = "addstudent")
    public String displayaddstudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute("student", new Student());
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
        return "home/allStudents";
    }
    //delete student
    @GetMapping("delete")
    public String displaydeletestudentform(Model model) {
        model.addAttribute("title", "Remove Student");
        model.addAttribute("students",studentDao.findAll());
        return"home/delete";
    }

    //User selects which student to delete
    //Selected student found in database
    //Student removed from database
    @PostMapping("delete")
    public String processdeletestudentform (@ModelAttribute Student student){
        if (studentDao.findById(student.getId()).equals(student.getId())){
            studentDao.delete(student);
        }
        return "redirect:allStudents";
    }
}