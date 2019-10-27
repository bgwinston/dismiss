package org.launchcode.dismissal1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
public String Goodbye() {
        return "goodbye";
    }
}
