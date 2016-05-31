package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scamisay on 27/05/16.
 */
public class CSVHeader {

    private Map<String,Integer> mapColNumbers;
    private Map<Integer,String> mapColNames;


    public CSVHeader(List<String> headerString) {
        mapColNumbers = new HashMap<String, Integer>();
        mapColNames = new HashMap<Integer, String>();
        for(int i = 0 ; i<headerString.size(); i++){
            mapColNumbers.put(headerString.get(i), i);
            mapColNames.put(i, headerString.get(i));
        }
    }

    public Integer getColNumber(String colString){
        return mapColNumbers.get(colString);
    }

    public String getColName(Integer colIndex){
        return mapColNames.get(colIndex);
    }
}
