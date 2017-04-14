import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.*;


/**
 * Created by Mindaugas on 2017-04-14.
 */
public class JdbcUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/kcs";
    private static final String NAME = "root";
    private static final String PSW = "";

    @Nullable
    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, NAME, PSW);
        } catch (SQLException e) {
            System.out.println("Prisijunkti nipavygti");
        }
        return connection;
    }

    public static void printStudent(@NotNull Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id")
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString("surname")
                        + " " + resultSet.getString("phone")
                        + " " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printStudentAddress(@NotNull Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students_address");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id")
                        + " " + resultSet.getInt(2)
                        + " " + resultSet.getString(3)
                        + " " + resultSet.getString(4)
                        + " " + resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printStudentMarks(@NotNull Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students_marks");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id")
                        + " " + resultSet.getInt(2)
                        + " " + resultSet.getString(3)
                        + " " + resultSet.getInt(4)
                        + " " + resultSet.getDate(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean isTableExist(Connection connection, String tableName){
        boolean tableExist = false;
        try {
            DatabaseMetaData data = connection.getMetaData();
            ResultSet resultSet = data.getTables(null, null, tableName, null);

            tableExist = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableExist;
    }
}
