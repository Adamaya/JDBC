package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Execution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter sName: ");
        String sname = scanner.nextLine();
        System.out.println("enter gpa: ");
        double gpa = scanner.nextDouble();
        System.out.println("enter sid: ");
        int sid = scanner.nextInt();

        StudentDatabaseConnector studentDatabaseConnector = new StudentDatabaseConnector();
        if (studentDatabaseConnector.attemptConnection() == true) {
            System.out.println("Connected");
        } else {
            System.out.println("Failed");
        }

        StudentDatabaseHelper studentDatabaseHelper = new StudentDatabaseHelper();
        if (studentDatabaseHelper.studentEntryManager(studentDatabaseConnector.getConnection(), sid, sname, gpa)) {
            System.out.println("Data entered");
        } else {
            System.out.println("Failed to enter the data");
        }
        ResultSet allDetails = studentDatabaseHelper.fetchDetails(studentDatabaseConnector.getConnection());
        System.out.println("Fetching Data from Database");
        while (true) {
            try {
                if (!allDetails.next()) {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("name: " + allDetails.getString("sname") + " sid: " + allDetails.getString("sid")+
                        " gpa: " + allDetails.getString("gpa"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
