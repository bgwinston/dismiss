package org.launchcode.dismissal1.controllers;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Scanner;


@Controller
@RequestMapping("home")

public class LoginController {

    @RequestMapping(value = "")
    public String selection() {
        return "home/login";
    }

    @RequestMapping(value= "transportation")
    public String transportation () {
        return "home/transportation";
    }

    @RequestMapping(value= "early")
    public String early(){
        return "home/early";
    }
}
