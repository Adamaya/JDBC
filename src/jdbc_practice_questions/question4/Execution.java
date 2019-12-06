package jdbc_practice_questions.question4;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Execution {
    public static void main(String[] args) {
        JdbcConnection jdbcConnection = new JdbcConnection();
        Helper helper = new Helper();
        if (jdbcConnection.attemptConnection()) {
            System.out.println("Connection Established!");
            ResultSet allDetails = helper.fetchSelectedData(jdbcConnection.getConnection(), "Object-Oriented Programmiing");
            while (true) {
                try {
                    if (!allDetails.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("courseId: " + allDetails.getString("courseId") + " courseName: "
                            + allDetails.getString("courseName") + " courseCode: " + allDetails.getString("courseCode") + " courseDuration: "
                            + allDetails.getString("courseDuration") + " courseCost: "
                            + allDetails.getString("courseCost"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Connection Failed!");
        }
    }
}
