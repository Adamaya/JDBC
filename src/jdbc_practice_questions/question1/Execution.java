package jdbc_practice_questions.question1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Execution {
    public static void main(String[] args) {
        JdbcConnection jdbcConnection = new JdbcConnection();
        Helper helper = new Helper();
        if (jdbcConnection.attemptConnection()) {
            System.out.println("Connection Established!");
            if (helper.createCourseTable(jdbcConnection.getConnection())) {
                System.out.println("Courses Table Created!");
                if (helper.enterDataInCourseTable(jdbcConnection.getConnection())) {
                    System.out.println("Data Entered into Courses Table");
                    ResultSet allDetails = helper.fetchCouresesTableData(jdbcConnection.getConnection());
                    while (true) {
                        try {
                            if (!allDetails.next()) {
                                break;
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        try{
                            System.out.println("courseId: "+allDetails.getString("courseId")+" courseName: "
                            +allDetails.getString("courseName")+" courseCode: " +allDetails.getString("courseCode")+" courseDuration: "
                                    +allDetails.getString("courseDuration")+" courseCost: "
                                    +allDetails.getString("courseCost"));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Failed to enter the data into Corses table.");
                }
            } else {
                System.out.println("Failed to create Table.");
            }
        } else {
            System.out.println("Connection Failed!");
        }


    }
}
