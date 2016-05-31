package database;

import java.sql.*;

/**
 * Created by scamisay on 30/05/16.
 */
public class MySQLConnection {

    private final String jdbcDriverStr;
    private final String jdbcURL;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public MySQLConnection(){
        this.jdbcDriverStr = "com.mysql.jdbc.Driver";
        this.jdbcURL = "jdbc:mysql://localhost/test_navent?";
    }

    public Integer getIntResultsetQuery(String query){
        Integer result = null;
        try {
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            result = getResultSet(resultSet);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            close();
        }
        return result;
    }

    private Integer getResultSet(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            return resultSet.getInt(1);
        }
        return null;
    }

    private void close(){
        try {
            if(resultSet!=null) resultSet.close();
            if(statement!=null) statement.close();
            if(connection!=null) connection.close();
        } catch(Exception e){}
    }

}
