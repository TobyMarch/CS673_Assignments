package czik.cs673.assignments.assignment4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quotes")
public class QuoteController {

    @GetMapping()
    public String quotes() {
        return "quotes";
    }

}
