package czik.cs673.assignments.assignment4.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import czik.cs673.assignments.assignment4.model.PrismaticResponse;
import czik.cs673.assignments.assignment4.utils.Constants;

@Service
public class QuoteService {
    Logger logger = LogManager.getLogger(QuoteService.class);

    @SuppressWarnings("null")
    public PrismaticResponse retrieveQuote() {
        RestClient restClient = RestClient.create();
        try {
            logger.info("Retrieving quote...");
            StringBuilder builder = new StringBuilder(Constants.PRISMATIC_BASE_URL);

            PrismaticResponse responseObj = restClient.get().uri(builder.toString()).retrieve()
                    .body(PrismaticResponse.class);
            logger.info(responseObj.toString());

            return responseObj;
        } catch (Exception e) {
            logger.error("Exception thrown in Prismatic request: ", e);
        }
        return null;
    }
}
