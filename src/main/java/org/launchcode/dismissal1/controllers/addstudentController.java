package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.Student;
import org.launchcode.dismissal1.models.data.ChangetransportationDao;
import org.launchcode.dismissal1.models.data.EarlyDao;
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
    private EarlyDao earlyDao;
    private ChangetransportationDao changetransportationDao;

    //Show all students.
    @RequestMapping(value = "allStudents")
    public String showallstudentindex(Model model) {
        model.addAttribute("title", "All Students");
        model.addAttribute("student", studentDao.findAll());
        return "home/allStudents";
    }

    //@RequestMapping(value="log")
    //public String log (Model model){
       // model.addAttribute("title","Your Children");
        //return "home/log";
 //   }
    @GetMapping(value = "addstudent")
    public String displayaddstudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute("student", new Student());
        return "home/addstudent";
    }

    //Process Form
    @PostMapping(value = "addstudent")
    public String addstudentForm(@ModelAttribute @Valid Student student, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Student");
            return "home/addstudent";
        }
        studentDao.save(student);
        return "redirect:allStudents";
    }

    //user selects student
    //student information found in database
    //student information brought to view
    @GetMapping(value = "page/{id}")
    public String studentpageForm(@PathVariable int id, Model model)

    {
        model.addAttribute("title", "Log");
        model.addAttribute("student", studentDao.findById(id).get());
        //model.addAttribute("early", earlyDao.findById(id).get());
        //model.addAttribute("changetransportation", changetransportationDao.findAll());
        //model.addAttribute("student", new Student());

        return "home/page";
    }

    //delete student
    @GetMapping("delete")
    public String displaydeletestudentform(Model model) {
        model.addAttribute("title", "Remove Student");
        model.addAttribute("students", studentDao.findAll());
        return "home/delete";
    }

    //User selects which student to delete
    //Selected student found in database
    //Student removed from database
    @PostMapping("delete")
    public String processdeletestudentform(@RequestParam(required = false) int[] studentids) {
        if (studentids != null) {
            for (int id : studentids) {
                studentDao.deleteById(id);
            }
            return "redirect:allStudents";
        }
        return "home/delete";

    }

}