package jdbc_practice_questions.question6;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Helper {
    public boolean deleteParticularCourse(Connection connection,String courseName){
        boolean isDeleted=false;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM courses WHERE courseName=?");
            preparedStatement.setString(1,courseName);
            preparedStatement.executeUpdate();
            isDeleted=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
