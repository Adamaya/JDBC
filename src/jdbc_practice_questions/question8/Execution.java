package jdbc_practice_questions.question8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Execution {
    public static void randomCoursesAddingMethod(int numberOfCoursesToAdd){
        int[] courseId={1,2,3};
        String[] courseName={"OOP-Python","OOP-Java","OOP-C++"};
        String[] courseCode={"OOP001","OOP002","OOP003"};
        int[] courseDuration={3, 5, 4};
        double[] courseCost={12000.0, 15000.0, 13000.0};
        Helper helper =new Helper();
        Random random=new Random();
        JdbcConnection jdbcConnection=new JdbcConnection();

        for (int i = 0; i < numberOfCoursesToAdd; i++) {
            helper.insertData(jdbcConnection.getConnection(),courseId[random.nextInt(3)],courseName[random.nextInt(3)],
                    courseCode[random.nextInt(3)],courseDuration[random.nextInt(3)],courseCost[random.nextInt(3)]);
        }
        System.out.println("Data Inserted");
    }
    public static void main(String[] args) {
        JdbcConnection jdbcConnection= new JdbcConnection();
        Scanner scanner = new Scanner(System.in);
        if(jdbcConnection.attemptConnection()){
            System.out.println("Connection Established!");
            System.out.println("Enter the number of entries which are to be generated randomly: ");
            randomCoursesAddingMethod(scanner.nextInt());
        }

    }
}
