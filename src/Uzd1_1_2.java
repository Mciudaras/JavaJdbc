import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mindaugas on 2017-04-14.
 */
public class Uzd1_1_2 {
    public static void main(String[] args) {
        Connection connection = JdbcUtils.createConnection(); // klases iskvietimas
        if(connection!=null){
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE students  set name = 'Mykolas' WHERE id = 1");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
