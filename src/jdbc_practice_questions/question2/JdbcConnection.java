package jdbc_practice_questions.question2;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class JdbcConnection {
    private static final String URL="jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static Connection connection=null;
}
