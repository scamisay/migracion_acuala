package domain;

import validator.CSVValidator;

import javax.lang.model.type.ErrorType;
import java.util.List;

/**
 * Created by scamisay on 30/05/16.
 */
public class ErrorPrinter {

    private CSVValidator validator;
    private List<List<String>> rawRows;
    private CSVHeader header;

    private ErrorPrinter(){}

    public ErrorPrinter(CSVValidator validator, List<List<String>> rawRows, CSVHeader header) {
        this.validator = validator;
        this.rawRows = rawRows;
        this.header = header;
    }

    public String print(){
        List<CSVErrorInRow> errors = validator.validate(rawRows,1);
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Se han encontrado %d lineas con errores\n\n", errors.size()));
        for(CSVErrorInRow errorInRow : errors){
            sb.append(
                    String.format("linea %d:\n", errorInRow.getRow())
            );
            for(CSVErrorType errorInCol : errorInRow.getErrorsInCol()){
                sb.append(
                        String.format("%s en columnas: ", errorInCol.getProblemType()));
                for(Integer colIndex : errorInCol.getCols()){
                    sb.append(String.format("%s, ", header.getColName(colIndex)));
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
