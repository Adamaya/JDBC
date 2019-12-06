package jdbc_practice_questions.question7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Execution {
    public static void main(String[] args) {
        JdbcConnection jdbcConnection=new JdbcConnection();
        Helper helper=new Helper();
        Scanner scanner = new Scanner(System.in);
        if(jdbcConnection.attemptConnection()){
            System.out.println("Connection Established!");
            System.out.println("Enter the column name: ");
            String columnName=scanner.nextLine();
            System.out.println("Enter the column value: ");
            String columnValue=scanner.nextLine();
            if(helper.courseExist(jdbcConnection.getConnection(),columnName)){
                System.out.println("Column Exist");
                if(helper.updateColumn(jdbcConnection.getConnection(),columnName,columnValue)){
                    System.out.println("Data Updated");
                }
                else{
                    System.out.println("Updation Failed!");
                }
            }
            else{
                System.out.println("Table does not exist.");
            }
        }
        else{
            System.out.println("Connection Failed!");
        }
        ResultSet allDetails=helper.fetchData(jdbcConnection.getConnection());
        while (true){
            try{
                if(!allDetails.next()){
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                System.out.println("courseId: "+allDetails.getString("courseId")+" courseName: "
                        +allDetails.getString("courseName")+" courseCode: " +allDetails.getString("courseCode")+" courseDuration: "
                        +allDetails.getString("courseDuration")+" courseCost: "
                        +allDetails.getString("courseCost"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
