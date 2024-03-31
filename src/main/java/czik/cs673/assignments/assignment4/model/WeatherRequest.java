package czik.cs673.assignments.assignment4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherRequest {
    private String cityName;

    private String zipCode;
}
