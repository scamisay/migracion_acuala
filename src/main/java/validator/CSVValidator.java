package validator;

import domain.CSVErrorInRow;
import domain.CSVHeader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by scamisay on 27/05/16.
 */
public class CSVValidator {

    private CSVHeader header;
    private NullCheckValidator nullCheckValidator;

    public CSVValidator(CSVHeader header, List<String> notNullCols) {
        this.header = header;
        nullCheckValidator = new NullCheckValidator(notNullCols, header);
    }

    public List<CSVErrorInRow> validate(List<List<String>> rawRows, int offset) {
        List<CSVErrorInRow> list = new ArrayList<CSVErrorInRow>();

        Iterator<List<String>> it = rawRows.iterator();

        int forOff = 1;
        while( it.hasNext() && forOff <= offset){
            it.next();
            forOff++;
        }

        for(int currentRowIndex= forOff;  it.hasNext(); currentRowIndex++ ){
            List<String> row = it.next();
            CSVErrorInRow errorsInRow = validateRow(row, currentRowIndex);
            if(!errorsInRow.isEmpty()){
                list.add(errorsInRow);
            }
        }

        return list;
    }

    private CSVErrorInRow validateRow(List<String> row, int currentRowIndex) {
        CSVErrorInRow error = new CSVErrorInRow(currentRowIndex);
        nullCheckValidator.validate(row);
        if(nullCheckValidator.hasErrors()){
            error.addError(nullCheckValidator.getErrors());
        }
        return error;
    }
}
