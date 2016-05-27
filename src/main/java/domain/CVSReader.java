package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CVSReader {

    private String fileName;
    private String colsSeparator;

    private CVSReader(){}

    public CVSReader(String fileName, String colsSeparator) {
        this.fileName = fileName;
        this.colsSeparator = colsSeparator;
    }

    public List<List<String>> readRawRows(int limit) {
        List<List<String>> lists = new ArrayList<List<String>>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(fileName));
            for (int lineCounter = 1; lineCounter <= limit && (line = br.readLine()) != null; lineCounter++) {
                lists.add(Arrays.asList(line.split(colsSeparator)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lists;
    }

}