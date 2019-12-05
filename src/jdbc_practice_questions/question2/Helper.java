package jdbc_practice_questions.question2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Helper {
    public boolean addNewCourseInDatabase(Connection connection, String[] course){
        boolean isAdded=false;
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO courses(courseID,courseName,courseCode,courseDuration,courseCost)" +
                    " VALUES(?,?,?,?,?);");
            preparedStatement.setInt(1,Integer.parseInt(course[0]));
            preparedStatement.setString(2,course[1]);
            preparedStatement.setString(3,course[2]);
            preparedStatement.setInt(4,Integer.parseInt(course[3]));
            preparedStatement.setDouble(5,Double.parseDouble(course[4]));
            preparedStatement.executeUpdate();
            isAdded=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }
}
