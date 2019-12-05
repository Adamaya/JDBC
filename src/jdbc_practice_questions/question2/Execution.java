package jdbc_practice_questions.question2;


public class Execution {
    public static void main(String[] args) {
        JdbcConnection jdbcConnection = new JdbcConnection();
        Helper helper = new Helper();
        if (jdbcConnection.attemptConnection()) {
            System.out.println("Connection Established!");
        }
        else{
            System.out.println("Connection Failed");
        }
        if(helper.addNewCourseInDatabase(jdbcConnection.getConnection(),new String[]{"3","New Course","NCCODE","5","9652.06"})){
            System.out.println("Data Entered");
        }
        else{
            System.out.println("Failed!");
        }
    }
}