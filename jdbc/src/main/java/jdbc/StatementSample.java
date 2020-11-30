package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementSample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "admin", "admin");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("show databases");

        while (resultSet.next()) {
            String string = resultSet.getString(1);
            System.out.println(string);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
