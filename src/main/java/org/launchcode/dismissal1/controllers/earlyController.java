package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.Early;
import org.launchcode.dismissal1.models.Student;
import org.launchcode.dismissal1.models.data.EarlyDao;
import org.launchcode.dismissal1.models.data.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//Info to display-Student and teacher name, Student grade level. Has to pull from login.
// Early pick up form and processing.
@Controller
@RequestMapping("early")
public class earlyController {


    @Autowired
    private EarlyDao earlyDao;
    private StudentDao studentDao;

    //Display history of pick ups
    @RequestMapping(value = "index")
    public String loge(Model model) {
        model.addAttribute("title", "Early Pick Up Log");
        model.addAttribute("early", earlyDao.findAll());
        return "early/index";
    }

    //Display of Form
    @RequestMapping(value = "release/{id}", method = RequestMethod.GET)
    public String displayearlyForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentDao.findById(id).get());
        model.addAttribute("title", "Early Pickup");
        model.addAttribute(new Early());

        return "Early/release";
    }

    //Process Form
    @RequestMapping(value = "release", method = RequestMethod.POST)
    public String processearlyForm(@ModelAttribute @Valid Early early, BindingResult bindingResult, @RequestParam(value="studentId") int studentId, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Early Pickup");
            return "Early/release";
        }
        Student student = studentDao.findById(studentId).get();
        early.setStudent(student);
        earlyDao.save(early);
        studentDao.save(student);

        List<Early> earlys = new ArrayList<>();
        for(Early item : earlyDao.findAll()){
            if(studentId==item.getStudent().getId()){
                earlys.add(item);
            }
        }
        model.addAttribute("earlys", earlys);
        return "Early/earlyconfirmation";
    }
}