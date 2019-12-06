package jdbc_practice_questions.question8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Helper {
    public boolean insertData(Connection connection, int courseID, String courseName, String courseCode, int courseDuration, double courseCost) {
        boolean isInserted=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO courses(courseID,courseName," +
                    "courseCode,courseDuration,courseCost) VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1,courseID);
            preparedStatement.setString(2,courseName);
            preparedStatement.setString(3,courseCode);
            preparedStatement.setInt(4,courseDuration);
            preparedStatement.setDouble(5,courseCost);
            preparedStatement.executeUpdate();
            isInserted=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }return isInserted;
    }
}
