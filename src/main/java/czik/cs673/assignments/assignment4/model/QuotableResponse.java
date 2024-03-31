package czik.cs673.assignments.assignment4.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotableResponse {
    private Object __info__;

    private int count;

    private int totalCount;

    private int page;

    private int totalPages;

    private List<QuotableResult> results;
}
