package net.passioncloud.audit.controllers;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping({ "", "/" })
    public String index(){
        log.info("Index page");
        return "index";
    }
}
