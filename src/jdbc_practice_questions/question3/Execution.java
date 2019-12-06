package jdbc_practice_questions.question3;


public class Execution {
    public static void main(String[] args) {
        JdbcConnection jdbcConnection = new JdbcConnection();
        Helper helper = new Helper();
        if (jdbcConnection.attemptConnection()) {
            System.out.println("Connection Established!");
            helper.readAllCourseDetailsFromDatabase(jdbcConnection.getConnection());
        } else {
            System.out.println("Connection Failed!");
        }
    }
}
