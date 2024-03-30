package czik.cs673.assignments.assignment4.services;

import java.util.Optional;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import czik.cs673.assignments.assignment4.model.QuotableRequest;
import czik.cs673.assignments.assignment4.model.QuotableResponse;
import czik.cs673.assignments.assignment4.model.QuotableResult;
import czik.cs673.assignments.assignment4.utils.Constants;

@Service
public class QuoteService {
    Logger logger = LogManager.getLogger(QuoteService.class);

    @SuppressWarnings("null")
    public Optional<QuotableResult> retrieveQuote(QuotableRequest request) {
        if (validRequest(request)) {
            RestClient restClient = RestClient.create();
            try {
                logger.info("Retrieving quote on '{}'...", request.getQuery());
                StringBuilder builder = new StringBuilder(Constants.QUOTABLE_BASE_URL);
                builder.append(String.format("?query=%s", request.getQuery()));
                builder.append(String.format("&limit=%d", Constants.QUOTABLE_PAGE_LIMIT));

                QuotableResponse responseObj = restClient.get().uri(builder.toString()).retrieve()
                        .body(QuotableResponse.class);

                return (responseObj != null && !responseObj.getResults().isEmpty())
                        ? Optional.of(responseObj.getResults().get(getRandomizedIndex(0, responseObj.getCount())))
                        : Optional.empty();
            } catch (Exception e) {
                logger.error("Exception thrown in Quotable request: " + e.getMessage());
            }
        }
        return Optional.empty();
    }

    private boolean validRequest(QuotableRequest request) {
        return request != null && !request.getQuery().isBlank() && request.getQuery().length() <= 50;
    }

    private int getRandomizedIndex(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
