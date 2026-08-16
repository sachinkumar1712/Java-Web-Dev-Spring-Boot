import java.sql.*;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/product_db";
        String username = "root";
        String password = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

//            int id = 35;
            String sql1 = "INSERT INTO product (name, price) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1,"IronMan");
            preparedStatement.setDouble(2,5000.00);

            int row = preparedStatement.executeUpdate();
            System.out.printf("%d rows inserted\n", row);

//            String sql1 = "INSERT INTO product (name, price) VALUES ('Hulk', 48000.00)";
//            String sql = "SELECT * FROM product WHERE id = " + id;

//            String sql2 = "DELETE FROM product WHERE name = 'Hulk'";
//            String sql2 = "DELETE FROM product WHERE id = 34";
//            int row1 =  statement.executeUpdate(sql2);

//            System.out.printf("%d Rows affected.\n", row1);
//            int row = statement.executeUpdate(sql2);
//            System.out.printf("%d Rows Affected\n",row);


//            String query = "SELECT * FROM product WHERE id = 1";
            String query1 = "SELECT * FROM product";

            ResultSet resultSet = statement.executeQuery(query1);
//            ResultSet resultSet = statement.executeQuery(sql1);
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1)+" "
                        +resultSet.getString(2)+" "
                        +resultSet.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("OPPS_T_T");
            e.printStackTrace();
        }
    }
}