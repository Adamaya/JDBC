package jdbc_practice_questions.question5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Execution {
    public static void main(String[] args) {
        JdbcConnection jdbcConnection=new JdbcConnection();
        Helper helper=new Helper();
        if(jdbcConnection.attemptConnection()){
            System.out.println("Connection Established!");
            ResultSet allDetails=helper.fetchDataFromTable(jdbcConnection.getConnection());
            ArrayList<String> arrayList=new ArrayList<>();
            while(true){
                try {
                    if(!allDetails.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try{
                    arrayList.add("courseId: " + allDetails.getString("courseId") + " courseName: "
                            + allDetails.getString("courseName") + " courseCode: " + allDetails.getString("courseCode") + " courseDuration: "
                            + allDetails.getString("courseDuration") + " courseCost: "
                            + allDetails.getString("courseCost"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(arrayList);
            }
        }
    }
}
