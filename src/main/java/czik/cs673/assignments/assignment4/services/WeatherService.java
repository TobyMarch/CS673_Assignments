package czik.cs673.assignments.assignment4.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import czik.cs673.assignments.assignment4.model.OpenWeatherResponse;
import czik.cs673.assignments.assignment4.model.WeatherRequest;
import czik.cs673.assignments.assignment4.utils.Constants;

@Service
public class WeatherService {
    Logger logger = LogManager.getLogger(WeatherService.class);

    @SuppressWarnings("null")
    public OpenWeatherResponse retrieveWeatherData(WeatherRequest request) {
        if (validRequest(request)) {
            RestClient restClient = RestClient.create();
            try {
                logger.info("Retrieving weather data from OpenWeather API...");

                StringBuilder builder = new StringBuilder(Constants.OPEN_WEATHER_BASE_URL);
                if (request.getZipCode() != null && !request.getZipCode().isBlank()) {
                    builder.append(String.format("zip=%s,us", request.getZipCode()));
                } else if (request.getCityName() != null && !request.getCityName().isBlank()) {
                    builder.append(String.format("q=%s", request.getCityName()));
                }
                builder.append(String.format("&appid=%s", Constants.OPEN_WEATHER_API_KEY));
                builder.append("&units=imperial");

                OpenWeatherResponse responseObj = restClient.get().uri(builder.toString()).retrieve()
                        .body(OpenWeatherResponse.class);
                logger.info(responseObj.toString());

                return responseObj;
            } catch (HttpClientErrorException e) {
                logger.info("{}", e.getMessage());
            } catch (Exception e) {
                logger.error("Exception thrown in OpenWeather request: ", e);
            }
        }
        return null;
    }

    private boolean validRequest(WeatherRequest request) {
        return request != null && (request.getZipCode() != null || request.getCityName() != null);
    }
}
