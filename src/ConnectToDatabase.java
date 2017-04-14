import java.sql.*;

/**
 * Created by Mindaugas on 2017-04-14.
 */
public class ConnectToDatabase {
    public static void main(String[] args) {
        try {
            Connection connection = JdbcUtils.createConnection(); // klases iskvietimas
            if (connection != null) {
                System.out.println("Connected");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
                //statement.executeUpdate("UPDATE students  set name = 'Pranas' WHERE id = 1");
                //statement.execute("DELETE from students where id =1");
                //statement.execute("INSERT into students(name, surname, phone, email) values('Andrius', 'Balt')");
               while(resultSet.next()){
                   System.out.println(resultSet.getInt("id")); // id stulpelio vardas students lentoje
                   System.out.println(resultSet.getString(2)); // 2 yra stulpelio indeksas
                   System.out.println(resultSet.getString("surname"));
                   System.out.println(resultSet.getString("phone"));
                   System.out.println(resultSet.getString("email"));
              }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
