package czik.cs673.assignments.assignment4.controllers;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import czik.cs673.assignments.assignment4.model.QuotableRequest;
import czik.cs673.assignments.assignment4.model.QuotableResult;
import czik.cs673.assignments.assignment4.services.QuoteService;

@Controller
@RequestMapping("/quotes")
@SessionAttributes("quoteResponse")
public class QuoteController {
    Logger logger = LogManager.getLogger(QuoteController.class);

    private QuotableResult quoteResponse;

    @Autowired
    QuoteService quoteService;

    @GetMapping()
    public String quotes() {
        return "quotes";
    }

    @ModelAttribute(name = "quoteRequest")
    public QuotableRequest request() {
        return new QuotableRequest();
    }

    @ModelAttribute(name = "quoteResponse")
    public QuotableResult response() {
        return quoteResponse != null ? quoteResponse : new QuotableResult();
    }

    @GetMapping("/request")
    public String quoteRequest(QuotableRequest request, SessionStatus sessionStatus) {
        try {
            Optional<QuotableResult> response = quoteService.retrieveQuote(request);
            if (response.isPresent()) {
                this.quoteResponse = response.get();
            } else {
                this.quoteResponse = null;
            }
            sessionStatus.setComplete();
        } catch (Exception e) {
            logger.error("Exception in Quote controller: ", e);
        }

        return "redirect:/quotes";
    }

}
