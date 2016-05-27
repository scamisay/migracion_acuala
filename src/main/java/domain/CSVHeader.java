package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scamisay on 27/05/16.
 */
public class CSVHeader {

    private Map<String,Integer> mapCols;

    public CSVHeader(List<String> headerString) {
        mapCols = new HashMap<String, Integer>();
        for(int i = 0 ; i<headerString.size(); i++){
            mapCols.put(headerString.get(i), i);
        }
    }

    public Integer getColNumber(String colString){
        return mapCols.get(colString);
    }
}
