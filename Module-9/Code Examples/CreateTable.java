import java.sql.*;

public class CreateTable {

    private Connection con;
    private Statement stmt;

    public CreateTable() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection URL format: jdbc:mysql://host:port/database
            String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false&serverTimezone=UTC";
            String user = "student1";
            String password = "pass";

            // Establish connection
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            System.out.println("Connected to the database.");
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        try {
            stmt.executeUpdate("DROP TABLE IF EXISTS address33");
            System.out.println("Table address33 dropped (if it existed).");
        } catch (SQLException e) {
            System.out.println("Error dropping table: " + e.getMessage());
        }

        try {
            stmt.executeUpdate("CREATE TABLE address33 (" +
                    "ID INT PRIMARY KEY, " +
                    "LASTNAME VARCHAR(40), " +
                    "FIRSTNAME VARCHAR(40), " +
                    "STREET VARCHAR(40), " +
                    "CITY VARCHAR(40), " +
                    "STATE VARCHAR(40), " +
                    "ZIP VARCHAR(40))");
            System.out.println("Table address33 created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }

        try {
            stmt.close();
            con.close();
            System.out.println("Database connections closed.");
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CreateTable();
    }
}
