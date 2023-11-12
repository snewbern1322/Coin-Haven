import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String DATABASE_URL = "jdbc:sqlite:banking_app.db";

    public static void loadDatabase() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");

            // Print existing users
            try (ResultSet resultSet = statement.executeQuery("SELECT id, username FROM users")) {
                System.out.println("Existing Users:");
                while (resultSet.next()) {
                    int userId = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    System.out.println("ID: " + userId + ", Username: " + username);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {

            String sql = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
            statement.executeUpdate(sql);

            // Print added user
            try (ResultSet resultSet = statement.executeQuery("SELECT id, username FROM users WHERE username = '" + username + "'")) {
                while (resultSet.next()) {
                    int userId = resultSet.getInt("id");
                    String addedUsername = resultSet.getString("username");
                    System.out.println("User added - ID: " + userId + ", Username: " + addedUsername);
                }
            }

            System.out.println("User registered successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
