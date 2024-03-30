package czik.cs673.assignments.assignment4.controllers;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import czik.cs673.assignments.assignment4.model.OpenWeatherResponse;
import czik.cs673.assignments.assignment4.model.WeatherRequest;
import czik.cs673.assignments.assignment4.services.WeatherService;

@Controller
@RequestMapping("/weather")
@SessionAttributes("weatherRequest, weatherResponse")
public class WeatherController {
    Logger logger = LogManager.getLogger(WeatherController.class);

    @Autowired
    WeatherService weatherService;

    private OpenWeatherResponse weatherResponse;

    @GetMapping()
    public String weather() {
        return "weather";
    }

    @ModelAttribute(name = "weatherRequest")
    public WeatherRequest request() {
        return new WeatherRequest();
    }

    @ModelAttribute(name = "weatherResponse")
    public OpenWeatherResponse response() {
        return (weatherResponse != null) ? weatherResponse : new OpenWeatherResponse();
    }

    @GetMapping("/request")
    public String sendWeatherRequest(WeatherRequest request, SessionStatus sessionStatus) {
        try {
            Optional<OpenWeatherResponse> response = weatherService.retrieveWeatherData(request);
            if (response.isPresent()) {
                this.weatherResponse = response.get();
            } else {
                this.weatherResponse = null;
            }

            sessionStatus.setComplete();
        } catch (Exception e) {
            logger.error("Exception in Weather controller: ", e);
        }

        return "redirect:/weather";
    }
}
