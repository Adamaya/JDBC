package jdbc_practice_questions.question5;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
    public ResultSet fetchDataFromTable(Connection connection){
        ResultSet resultSet=null;
        try{
            Statement statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM courses");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
