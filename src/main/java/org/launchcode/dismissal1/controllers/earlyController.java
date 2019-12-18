package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.Early;
import org.launchcode.dismissal1.models.data.EarlyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

//Info to display-Student and teacher name, Student grade level. Has to pull from login.
// Early pick up form and processing.
@Controller
@RequestMapping("early")
public class earlyController {


    @Autowired
    private EarlyDao earlyDao;

    //Display history of pick ups
    @RequestMapping(value = "index")
    public String loge(Model model) {
        model.addAttribute("title", "Early Pick Up Log");
        model.addAttribute("early", earlyDao.findAll());
        return "early/index";
    }

    //Display of Form
    @RequestMapping(value = "release", method = RequestMethod.GET)
    public String displayearlyForm(Model model) {
        model.addAttribute("title", "Early Pickup");
        model.addAttribute(new Early());

        return "early/release";
    }

    //Process Form
    @RequestMapping(value = "release", method = RequestMethod.POST)
    public String processearlyForm(@ModelAttribute @Valid Early early, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Early Pickup");
            return "early/release";
        }
        earlyDao.save(early);
        return"redirect:index";
    }
}