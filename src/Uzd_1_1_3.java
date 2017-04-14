import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mindaugas on 2017-04-14.
 */
public class Uzd_1_1_3 {
    public static void main(String[] args){
        Connection connection = JdbcUtils.createConnection();
        if(connection != null){
            if(JdbcUtils.isTableExist(connection, "students_marks")){
                System.out.println("students_marks egzistuoja");
            }
            System.out.println("Duomenys pries pakeitima");
            JdbcUtils.printStudentMarks(connection);
            try {
                Statement statement = connection.createStatement();
                statement.execute("DELETE from students_marks where mark < 9");
                System.out.println("Duomenys po pakeitimo");
                JdbcUtils.printStudentMarks(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
