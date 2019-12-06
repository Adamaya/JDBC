package jdbc_practice_questions.question3;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
    public void readAllCourseDetailsFromDatabase(Connection connection){
        ResultSet resultSet=null;
        try{
            Statement statement = connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM courses;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true){
            try{
                if(!resultSet.next()){
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                System.out.println("courseId: "+resultSet.getString("courseId")+" courseName: "
                        +resultSet.getString("courseName")+" courseCode: " +resultSet.getString("courseCode")+" courseDuration: "
                        +resultSet.getString("courseDuration")+" courseCost: "
                        +resultSet.getString("courseCost"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
