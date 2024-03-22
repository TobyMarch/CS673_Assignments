package czik.cs673.assignments.assignment4.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @SuppressWarnings("null")
    public void testWeatherPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/weather")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("weather"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Weather Report")));
    }
}
