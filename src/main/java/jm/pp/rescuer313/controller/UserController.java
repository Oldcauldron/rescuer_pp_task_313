package jm.pp.rescuer313.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class UserController {

    @GetMapping("/")
    public String getIndex() {
        return "pages/index";
    }

}
