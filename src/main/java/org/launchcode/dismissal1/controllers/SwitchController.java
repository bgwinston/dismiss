package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.changetransportation;
import org.launchcode.dismissal1.models.data.ChangetransportationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Controller
@RequestMapping("switch")
public class SwitchController {
    @Autowired
    private ChangetransportationDao changetransportationDao;

    //Display history of transportation changes
    @RequestMapping(value = "indext")
    public String log1(Model model) {
        model.addAttribute("title", "Change of Transportation Log");
        model.addAttribute("early", changetransportationDao.findAll());
        return "switch/indext";
    }

    @RequestMapping(value= "")
    public String displayall(Model model) {
        model.addAttribute("changetransportations", changetransportationDao.findAll());
        model.addAttribute("title", "All Switches");
        return "switch/confirmation";
    }

    //display form
    @RequestMapping (value = "transportation", method=RequestMethod.GET)
    public String change(Model model) {
        model.addAttribute("title", "Transportation Change");
        model.addAttribute(new changetransportation());
        return "switch/transportation";
    }

    //Process form
    @RequestMapping(value="transportation", method=RequestMethod.POST)
    public String processChangeform(@ModelAttribute @Valid changetransportation changetransportation, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Transportation Change");
            return "switch/transportation";
        }
        changetransportationDao.save(changetransportation);
        return "redirect:switch/confirmation";
    }

}