package org.launchcode.dismissal1.controllers;

import org.omg.CORBA.Request;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Scanner;


@Controller
@RequestMapping("switch")
public class SwitchController {


    @RequestMapping(value = "transportation")
    public String change(Model model) {
        model.addAttribute("title", "Transportation Change");
        return "switch/transportation";
    }

    @RequestMapping(value = "transportationconfirmation")
    public String early(Model model) {
        model.addAttribute("title", "Transportation Confirmation");
        return "switch/transportationconfirmation";
    }
}
