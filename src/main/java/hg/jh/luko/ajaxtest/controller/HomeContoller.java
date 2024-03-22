package hg.jh.luko.ajaxtest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
