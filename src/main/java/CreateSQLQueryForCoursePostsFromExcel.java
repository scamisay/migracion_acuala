import database.MySQLConnection;
import domain.CSVErrorInRow;
import domain.CSVHeader;
import domain.CVSReader;
import domain.ErrorPrinter;
import validator.CSVValidator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by scamisay on 27/05/16.
 */
public class CreateSQLQueryForCoursePostsFromExcel {

    public static void main(String args[]){
        CVSReader cvsReader = new CVSReader("/home/scamisay/test/test_peru_100.csv", ",");
        List<List<String>> rawRows = cvsReader.readRawRows(100 + 1);
        CSVHeader header = new CSVHeader(rawRows.get(0));

        /**
         * nombre de columnas que no pueden ser nulas
         */
        List<String> notNullColumns = Arrays.asList("categoryL1Id","categoryL2Id","categoryL3Id");

        MySQLConnection connection = new MySQLConnection();
        connection.getIntResultsetQuery("select count(*) from coursecategoryl1");
        new ErrorPrinter( new CSVValidator(header, notNullColumns), rawRows , header).print();



    }

}
