

/* 
 *  Name: Yohannes Ayele
 *  Date: 05/11/25
 *  Assignment: MS: Ayele_M10_FanDisplayUpdate
 *  Purpose of the code: Connect to MySQL database and Display or update fans table records.
 *  Gethub: https://github.com/yojohub/csd-420.git
 */



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class Ayele_M10_FanDisplayUpdate extends Application {

    private TextField idField = new TextField();
    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField favoriteTeamField = new TextField();

    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb?useSSL=false";
    private final String DB_USER = "student1";
    private final String DB_PASSWORD = "pass";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("views or updates fan information");

        // UI Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Create Labels and fields
        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("First Name:"), 0, 1);
        grid.add(firstName, 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastName, 1, 2);

        grid.add(new Label("Favorite Team:"), 0, 3);
        grid.add(favoriteTeamField, 1, 3);

        // Create Buttons
        Button displayButton = new Button("Display");
        Button updateButton = new Button("Update");

        grid.add(displayButton, 0, 4);
        grid.add(updateButton, 1, 4);

        displayButton.setOnAction(e -> displayFan());
        updateButton.setOnAction(e -> updateFan());

        // Show window
        Scene scene = new Scene(grid, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayFan() {
        String id = idField.getText();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstName.setText(rs.getString("firstname"));
                lastName.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                showAlert(Alert.AlertType.WARNING, "No record found try again.");
            }

        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error: " + ex.getMessage());
        }
    }

    private void updateFan() {
        String id = idField.getText();
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String favoriteTeam = favoriteTeamField.getText();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?")) {

            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, favoriteTeam);
            stmt.setInt(4, Integer.parseInt(id));

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Record updated successfully.");
            } else {
                showAlert(Alert.AlertType.WARNING, "No record found to update. Please try again");
            }

        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error: " + ex.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message, ButtonType.OK);
        alert.showAndWait();
    }
}
