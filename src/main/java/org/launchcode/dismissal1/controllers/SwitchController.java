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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("switch")
public class SwitchController {
    @Autowired
    UserDao userDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    EarlyDao earlyDao;

    @Autowired
    ChangetransportationDao changetransportationDao;

    private static List<String> changetransportation1 = new ArrayList<>();

    @GetMapping
    public String displayall(Model model){
        model.addAttribute("changetransportation",changetransportation1);
        return "home/log";
    }


    @RequestMapping(value = "transportation", method = RequestMethod.GET)
    public String change(Model model) {
        model.addAttribute("title", "Transportation Change");
        model.addAttribute(new changetransportation());
        return "switch/transportation";
    }

    @RequestMapping(value = "transportation", method=RequestMethod.POST)
    public String early(@ModelAttribute @Valid changetransportation newchangetransportation, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Transportation Confirmation");
            return "switch/transportation";
        }
        changetransportationDao.save(newchangetransportation);
        return "home/log";
    }
}