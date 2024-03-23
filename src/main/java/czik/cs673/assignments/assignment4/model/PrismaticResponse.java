package czik.cs673.assignments.assignment4.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PrismaticResponse {
    private String quoteText;

    private String quoteAuthor;

    private String senderName;

    private String senderLink;

    private String quoteLink;
}
