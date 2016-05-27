package validator;

import domain.CSVErrorType;
import domain.CSVHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scamisay on 27/05/16.
 */
public class NullCheckValidator {

    private CSVErrorType errorType;
    private List<Integer> notNullCols;

    public NullCheckValidator(List<String> notNullFields, CSVHeader header) {
        notNullCols = new ArrayList<Integer>();
        for(String colStr : notNullFields){
            notNullCols.add(header.getColNumber(colStr));
        }
    }

    public void validate(List<String> row){
        List<Integer> colsWithProblems = new ArrayList<Integer>();
        for(Integer colIndex = 0 ; colIndex < row.size() ; colIndex++){
            if(!canBeNull(colIndex) && row.get(colIndex).isEmpty()){
                colsWithProblems.add(colIndex);
            }
        }
        errorType = new CSVErrorType("Datos Incompletos", colsWithProblems);
    }

    private boolean canBeNull(Integer colIndex) {
        return !notNullCols.contains(colIndex);
    }

    public boolean hasErrors() {
        return !errorType.isEmpty();
    }

    public CSVErrorType getErrors() {
        return errorType;
    }
}
