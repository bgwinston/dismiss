package org.launchcode.dismissal1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value = "")
    public String login(Model model) {
        model.addAttribute("title", "The Dismissal App");
        return "login/login";
    }

    @RequestMapping(value= "log")
    @ResponseBody
    public String Goodbye() {
        return "goodbye";
    }

    @RequestMapping(value= "iforgot")
    @ResponseBody
    public String Hey(){
        return "hey";
    }
}
