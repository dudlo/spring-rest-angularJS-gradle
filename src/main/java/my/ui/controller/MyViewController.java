package my.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Part of Spring MVC machinery. This controller is for view processing. The other is fo AJAX calls. 
 *
 */
@Controller
public class MyViewController {
    @RequestMapping(value="/")
    public String myInitial(Model model) {
        return "myinitialview";
    }
}