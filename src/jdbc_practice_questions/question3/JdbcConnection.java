package jdbc_practice_questions.question3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String URL="jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static Connection connection=null;

    public static Connection getConnection() {
        return connection;
    }

    public boolean attemptConnection(){
        boolean isConnected= false;
        try {
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            isConnected= true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isConnected;
    }
}

