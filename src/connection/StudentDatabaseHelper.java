package connection;

import java.sql.*;

public class StudentDatabaseHelper {
    public boolean studentEntryManager(Connection connection,int sid,String sname,double gpa){
        boolean isEntered=false;
        try {
            PreparedStatement statement= connection.prepareStatement("INSERT INTO studentrecord(sid,sname,gpa) VALUES(?,?,?);");
            statement.setInt(1, sid);
            statement.setString(2, sname);
            statement.setDouble(3, gpa);
            statement.executeUpdate();
            isEntered=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isEntered;
    }
    public ResultSet fetchDetails(Connection connection){
        String querry="SELECT * from studentrecord";
        ResultSet resultSet=null;
        try{
            Statement statement=connection.createStatement();
            resultSet=statement.executeQuery(querry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
