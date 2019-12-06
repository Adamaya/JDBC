package jdbc_practice_questions.question8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Execution {
    public void randomCoursesAddingMethod(int numberOfCoursesToAdd){
        String[] courseId={"1","2","3"};
        String[] courseName={"OOP-Python","OOP-Java","OOP-C++"};
        String[] courseCode={"OOP001","OOP002","OOP003"};
        String[] courseDuration={"3","5","4"};
        String[] courseCost={"12000","15000","13000"};
        Helper helper =new Helper();
        Random random=new Random();
        JdbcConnection jdbcConnection=new JdbcConnection();

        for (int i = 0; i < numberOfCoursesToAdd; i++) {
            helper.insertData(jdbcConnection.getConnection(),courseId[random.nextInt(3)],courseName[random.nextInt(3)],
                    courseCode[random.nextInt(3)],courseDuration[random.nextInt(3)],courseCode[random.nextInt(3)]);
        }
    }
    public static void main(String[] args) {


    }
}
