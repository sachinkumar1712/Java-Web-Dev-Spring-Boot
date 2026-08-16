import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/product_db";
        String username = "root";
        String password = "12345678";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM product";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("id") + " " +
                                resultSet.getString("name") + " " +
                                resultSet.getDouble("price")
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}