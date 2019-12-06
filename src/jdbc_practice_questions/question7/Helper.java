package jdbc_practice_questions.question7;

import java.sql.*;

public class Helper {
    public boolean courseExist(Connection connection,String columnName){
        boolean isExist=false;
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT ? FROM courses;");
            preparedStatement.setString(1,columnName);
            preparedStatement.executeQuery();
            isExist=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }
    public boolean updateColumn(Connection connection,String columnName,String courseValue) {
        boolean isUpdated=false;
        String query= "UPDATE courses SET "+columnName +"= ?;";
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(query);

            preparedStatement.setString(1,courseValue);
            preparedStatement.executeUpdate();
            isUpdated=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    public ResultSet fetchData(Connection connection){
        ResultSet resultSet=null;
        try{
            Statement statement=connection.createStatement();
            resultSet =statement.executeQuery("SELECT * FROM courses;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
