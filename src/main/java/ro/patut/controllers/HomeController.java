package ro.patut.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neop on 08.04.2017.
 */

@RestController
public class HomeController {

    @RequestMapping("/")
    public String showHomePage(){
        return "welcome tot the admin panel!";
    }
}
