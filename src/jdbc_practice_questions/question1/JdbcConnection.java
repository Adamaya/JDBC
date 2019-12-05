package jdbc_practice_questions.question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String URL="jdbc:mysql://localhost:3306/studentdatabase";
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static Connection connection=null;
}

