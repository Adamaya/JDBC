package jdbc_practice_questions.question6;

import java.util.Scanner;

public class Execution {
    public static void main(String[] args) {
        JdbcConnection jdbcConnection = new JdbcConnection();
        Helper helper = new Helper();
        Scanner scanner = new Scanner(System.in);
        if (jdbcConnection.attemptConnection()) {
            System.out.println("Connection Established!");
            String cName = scanner.nextLine();
            if (helper.deleteParticularCourse(jdbcConnection.getConnection(), cName)) {
                System.out.println("Record Deleted");
            }
            else{
                System.out.println("Failed to delete Record");
            }
        }else {
            System.out.println("Connection Failed!");
        }
    }
}
