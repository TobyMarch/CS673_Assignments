package czik.cs673.assignments.assignment4.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import czik.cs673.assignments.assignment4.model.PrismaticResponse;
import czik.cs673.assignments.assignment4.model.ZenQuotesResponse;
import czik.cs673.assignments.assignment4.services.QuoteService;

@Controller
@RequestMapping("/quotes")
@SessionAttributes("quoteResponse")
public class QuoteController {
    Logger logger = LogManager.getLogger(QuoteController.class);

    private ZenQuotesResponse quoteResponse;

    @Autowired
    QuoteService quoteService;

    @GetMapping()
    public String quotes() {
        return "quotes";
    }

    @ModelAttribute(name = "quoteResponse")
    public ZenQuotesResponse response() {
        return quoteResponse != null ? quoteResponse : new ZenQuotesResponse();
    }

    @GetMapping("/request")
    public String quoteRequest(SessionStatus sessionStatus) {
        try {
            this.quoteResponse = quoteService.retrieveQuote();
            sessionStatus.setComplete();
        } catch (Exception e) {
            logger.error("Exception in Quote controller: ", e);
        }

        return "redirect:/quotes";
    }

}
