import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database2 {
    private static final String DATABASE_URL = "jdbc:sqlite:banking_app.db";

    public static void loadDatabase2() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
            statement.execute("CREATE TABLE IF NOT EXISTS savings_accounts (id INTEGER PRIMARY KEY AUTOINCREMENT, account_name TEXT, date_created TEXT, starting_balance REAL)");
            statement.execute("CREATE TABLE IF NOT EXISTS checkings_accounts (id INTEGER PRIMARY KEY AUTOINCREMENT, account_name TEXT, date_created TEXT, starting_balance REAL)");
            statement.execute("CREATE TABLE IF NOT EXISTS cards (id INTEGER PRIMARY KEY AUTOINCREMENT, card_number TEXT, card_holder TEXT, expiration_date TEXT, cvv TEXT)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mehtods --------------------------------------------------------------------------
    //adding new card (dashboard)
        public static void addCard(String cardNumber, String cardHolder, String expirationDate, String cvv) {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL);
                 Statement statement = connection.createStatement()) {
    
                String sql = "INSERT INTO cards (card_number, card_holder, expiration_date, cvv) " +
                        "VALUES ('" + cardNumber + "', '" + cardHolder + "', '" + expirationDate + "', '" + cvv + "')";
    
                statement.executeUpdate(sql);
    
                System.out.println("Card added successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    //adding new checkings account (dashboard)
        public static void addCheckingAccount(String accountName, String dateCreated, String startingBalance) {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL);
                 Statement statement = connection.createStatement()) {
        
                String sql = "INSERT INTO checkings_accounts (account_name, date_created, starting_balance) " +
                        "VALUES ('" + accountName + "', '" + dateCreated + "', '" + startingBalance + "')";
        
                statement.executeUpdate(sql);
        
                System.out.println("Checking account added successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    //adding new savings account (dashboard)
        public static void addSavingsAccount(String accountName, String dateCreated, String startingBalance) {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL);
                 Statement statement = connection.createStatement()) {
        
                String sql = "INSERT INTO savings_accounts (account_name, date_created, starting_balance) " +
                        "VALUES ('" + accountName + "', '" + dateCreated + "', '" + startingBalance + "')";
        
                statement.executeUpdate(sql);
        
                System.out.println("Savings account added successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    //login page
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
