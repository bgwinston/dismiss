package org.launchcode.dismissal1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

//Info to display-student and teacher name, student grade level. Has to pull from login.
// Early pick up form and processing.
@Controller
@RequestMapping("early")
public class earlyController {
    static ArrayList<String>log = new ArrayList<>();

    //Display of Form
    @RequestMapping(value = "release", method = RequestMethod.GET)
    public String displayearlyForm(Model model) {
        model.addAttribute("title", "Early Pickup");

        return "early/release";
    }

    //Process Form
    @RequestMapping(value = "release", method = RequestMethod.POST)
    public String processearlyForm(@RequestParam String early){
        log.add(early);
        return "early/earlyconfirmation";
    }

}