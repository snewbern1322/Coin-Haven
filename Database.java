//database class that handles user login and bank information
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String DATABASE_URL = "jdbc:sqlite:banking_app.db";

    public static void loadDatabase() {
        try{
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            Statement statement = connection.createStatement(); 
            statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
            statement.close();
            connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void addUser(String username, String password) {
        try{
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
