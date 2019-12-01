package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.data.ChangetransportationDao;
import org.launchcode.dismissal1.models.data.EarlyDao;
import org.launchcode.dismissal1.models.data.StudentDao;
import org.launchcode.dismissal1.models.data.UserDao;
import org.launchcode.dismissal1.models.early;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

//Info to display-student and teacher name, student grade level. Has to pull from login.
// Early pick up form and processing.
@Controller
@RequestMapping("early")
public class earlyController {
    @Autowired
    UserDao userDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    EarlyDao earlyDao;

    @Autowired
    ChangetransportationDao changetransportationDao;

    static ArrayList<String> log = new ArrayList<>();

    //Display of Form
    @RequestMapping(value = "release", method = RequestMethod.GET)
    public String displayearlyForm(Model model) {
        model.addAttribute("title", "Early Pickup");
        model.addAttribute(new early());

        return "early/release";
    }

    //Process Form
    @RequestMapping(value = "release", method = RequestMethod.POST)
    public String processearlyForm(@ModelAttribute @Valid early early, Errors errors) {
        if (errors.hasErrors()) {
            return "early/release";
        }
        earlyDao.save(early);
        return "early/release";
    }
}