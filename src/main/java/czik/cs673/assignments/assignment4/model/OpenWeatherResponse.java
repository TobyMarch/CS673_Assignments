package czik.cs673.assignments.assignment4.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OpenWeatherResponse {
    private Integer id;

    private String name;

    private Object coord;

    private List<Object> weather;

    private String base;

    private Object main;

    private Integer visibility;

    private Object wind;

    private Object clouds;

    private Integer dt;

    private Object sys;

    private Integer timezone;

    private Integer cod;

}
