package jdbc_practice_questions.question1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
    public boolean createCourseTable(Connection connection){
        boolean isCreated=false;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("CREATE TABLE courses(courseID int,courseName varchar(50),courseCode varchar(20)," +
                    "courseDuration int,courseCost double);");
            isCreated=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }
    public boolean enterDataInCourseTable(Connection connection){
        boolean isInserted=false;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO courses(courseID,courseName,courseCode,courseDuration,courseCost)" +
                    " VALUES (1,'Object-Oriented Programmiing','BCSC0002',4,9562.50);");
            statement.executeQuery("INSERT INTO courses(courseID,courseName,courseCode,courseDuration,courseCost)" +
                    " VALUES (2,'Object-Oriented Programmiing','BCSC0801',4,9562.50);");
            isInserted=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInserted;
    }
    public ResultSet fetchCouresesTableData(Connection connection){
        ResultSet resultSet=null;
        try{
            Statement statement = connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM courses;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


}
