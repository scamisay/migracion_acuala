package domain;

import java.util.List;

/**
 * Created by scamisay on 27/05/16.
 */
public class CSVErrorType {

    private String problemType;
    private List<Integer> cols;

    public CSVErrorType(String problemType, List<Integer> cols) {
        this.problemType = problemType;
        this.cols = cols;
    }

    public boolean isEmpty(){
        return cols.isEmpty();
    }
}
