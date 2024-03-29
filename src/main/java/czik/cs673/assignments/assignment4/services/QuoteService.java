package czik.cs673.assignments.assignment4.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import czik.cs673.assignments.assignment4.model.PrismaticResponse;
import czik.cs673.assignments.assignment4.model.ZenQuotesResponse;
import czik.cs673.assignments.assignment4.utils.Constants;

@Service
public class QuoteService {
    Logger logger = LogManager.getLogger(QuoteService.class);

    @SuppressWarnings("null")
    public ZenQuotesResponse retrieveQuote() {
        RestClient restClient = RestClient.create();
        try {
            logger.info("Retrieving quote...");
            StringBuilder builder = new StringBuilder(Constants.ZENQUOTES_BASE_URL);

            List<ZenQuotesResponse> responseObj = restClient.get().uri(builder.toString()).retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            logger.info(responseObj.toString());

            return responseObj.get(0);
        } catch (Exception e) {
            logger.error("Exception thrown in ZenQuotes request: " + e);
        }
        return null;
    }
}
