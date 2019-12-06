package jdbc_practice_questions.question4;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Helper {
    public ResultSet fetchSelectedData(Connection connection,String cName){
        ResultSet resultSet=null;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM courses WHERE courseName=?;");
            preparedStatement.setString(1,cName);
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
