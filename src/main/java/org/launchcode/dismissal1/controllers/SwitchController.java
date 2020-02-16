package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.Changetransportation;
import org.launchcode.dismissal1.models.Student;
import org.launchcode.dismissal1.models.data.ChangetransportationDao;
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


@Controller
@RequestMapping("switch")
public class SwitchController {
    @Autowired
    private ChangetransportationDao changetransportationDao;


    @Autowired
    private StudentDao studentDao;

    //Display history of transportation changes
    @RequestMapping(value = "indext")
    public String log1(Model model) {
        model.addAttribute("title", "Change of Transportation Log");
        model.addAttribute("Early", changetransportationDao.findAll());
        return "switch/indext";
    }

    @RequestMapping(value= "")
    public String displayall(Model model) {
        model.addAttribute("changetransportations", changetransportationDao.findAll());
        model.addAttribute("title", "All Switches");
        return "switch/confirmation";
    }

    //display form
    @RequestMapping(value = "transportation/{id}", method=RequestMethod.GET)
    public String change(@PathVariable int id, Model model) {
        model.addAttribute("student", studentDao.findById(id).get());
        model.addAttribute("title", "Transportation Change");
        model.addAttribute("changetransportation", new Changetransportation());
        return "switch/transportation";
    }

    //Process form
    @RequestMapping(value="transportation", method=RequestMethod.GET)
    public String processChangeform(@ModelAttribute @Valid Changetransportation changetransportation, BindingResult bindingResult, @RequestParam(value="studentId") int studentId, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Transportation Change");
            return "switch/transportation";
        }
        Student student = studentDao.findById(studentId).get();
        student.setTransportationMode(changetransportation.getTransportationchange());
        changetransportation.setStudent(student);
        changetransportationDao.save(changetransportation);
        studentDao.save(student);

        List<Changetransportation> changetransportations = new ArrayList<>();
        for(Changetransportation item : changetransportationDao.findAll()){
            if(studentId==item.getStudent().getId()){
                changetransportations.add(item);
            }
        }
        model.addAttribute("changetransportations", changetransportations);
        return "switch/indext";
    }

}