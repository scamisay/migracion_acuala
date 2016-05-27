/**
 * Created by scamisay on 27/05/16.
 */

package domain;

import java.util.ArrayList;
import java.util.List;

public class CSVErrorInRow {
    private List<CSVErrorType> list;
    private int row;

    private CSVErrorInRow() {

    }

    public CSVErrorInRow(int currentRowIndex) {
        list = new ArrayList<CSVErrorType>();
        row = currentRowIndex;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void addError(CSVErrorType errors) {
        list.add(errors);
    }
}
