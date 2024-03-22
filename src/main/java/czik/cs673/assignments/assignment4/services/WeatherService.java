package czik.cs673.assignments.assignment4.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import czik.cs673.assignments.assignment4.model.OpenWeatherResponse;
import czik.cs673.assignments.assignment4.model.WeatherRequest;
import czik.cs673.assignments.assignment4.utils.Constants;

@Service
public class WeatherService {
    Logger logger = LogManager.getLogger(WeatherService.class);

    public OpenWeatherResponse retrieveWeatherData(WeatherRequest request) {
        RestClient restClient = RestClient.create();
        logger.info("Retrieving weather data from OpenWeather API...");
        String parameterizedAddress = String.format(
                "https://api.openweathermap.org/data/2.5/weather?zip=%s,us&appid=%s",
                request.getZipCode(),
                Constants.OPEN_WEATHER_API_KEY);
        OpenWeatherResponse responseObj = restClient.get().uri(parameterizedAddress).retrieve()
                .body(OpenWeatherResponse.class);
        logger.info(responseObj.toString());
        return responseObj;
    }
}
