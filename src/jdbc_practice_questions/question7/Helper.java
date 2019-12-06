package jdbc_practice_questions.question7;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Helper {
    public boolean courseExist(Connection connection,String cName){
        boolean isExist=false;
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM courses WHERE courseName=?;");
            preparedStatement.setString(1,cName);
            preparedStatement.executeUpdate();
            isExist=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }
}
