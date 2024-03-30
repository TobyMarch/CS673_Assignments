package czik.cs673.assignments.assignment4.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotableResult {
    private String _id;

    private String content;

    private String author;

    private String authorId;

    private String authorSlug;

    private List<String> tags;

    private String dateAdded;

    private String dateModified;

    private int length;
}
