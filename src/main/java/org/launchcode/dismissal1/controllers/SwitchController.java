package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.changetransportation;
import org.launchcode.dismissal1.models.data.ChangetransportationDao;
import org.launchcode.dismissal1.models.data.EarlyDao;
import org.launchcode.dismissal1.models.data.StudentDao;
import org.launchcode.dismissal1.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("switch")
public class SwitchController {

    @Autowired
    ChangetransportationDao changetransportationDao;


    @GetMapping
    public String displayall(Model model) {
        model.addAttribute("Title", "Change Transportation");
        return "switch/confirmation";
    }

    //display form
    @GetMapping(value = "transportation")
    public String change(Model model) {
        model.addAttribute("title", "Transportation Change");
        model.addAttribute(new changetransportation());
        return "switch/transportation";
    }

        //Process form
    @PostMapping(value = "transportation")
    public String early (@ModelAttribute @Valid changetransportation changetransportation, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Confirmation");
            return "switch/confirmation";
            }
        changetransportationDao.save(changetransportation);
        return "redirect: switch/confirmation";
        }

    }