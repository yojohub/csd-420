/* 
 *  Name: Yohannes Ayele
 *  Date: 04/27/25
 *  Assignment: MS: Ayele_M7_DisplayCircles
 *  Purpose of the code: Displays four circles and 0verlapping Circle Inside Rectangle
 *  Gethub: https://github.com/yojohub/csd-420.git
 */



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ayele_M7_DisplayCircles extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        // This will Create the first circle
        Circle circleA = new Circle(50, Color.WHITE);
        circleA.setStroke(Color.BLACK);
        circleA.setStrokeWidth(2);

        // This will Create a rectangle 
        Rectangle rectangle = new Rectangle(100, 240, Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);

        // Position the circleA and rectangle
        circleA.setCenterX(60); // Set horizontal position for circleA
        circleA.setCenterY(120); // Set vertical position for circleA
        rectangle.setX(10); //  Place the rectangle from the top left corner towards the X-axis Position
        rectangle.setY(10); // Place the rectangle from the top left corner towards the Y-axis Position

        // Group the first circle and rectangle together to overlap them
        Pane pane1 = new Pane();
        pane1.getChildren().addAll(rectangle, circleA);

        // This will create circleB and adjust vertical and horizontal positions
        Circle circleB = new Circle(50, Color.WHITE);
        circleB.setStroke(Color.BLACK);
        circleB.setStrokeWidth(2);
        circleB.setCenterX(180);  // Set horizontal position for circleB
        circleB.setLayoutY(120);  // Set Y-coordinate for circleB to 120

        // This will create circleC and adjust vertical and horizontal positions
        Circle circleC = new Circle(50, Color.RED);
        circleC.setStroke(Color.RED);
        circleC.setStrokeWidth(2);
        circleC.setCenterX(300);  // Set horizontal position for circleC
        circleC.setLayoutY(120);  // Set Y-coordinate for circleC to 120

        // This will create circleD and adjust vertical and horizontal positions
        Circle circleD = new Circle(50, Color.GREEN);
        circleD.setStroke(Color.GREEN);
        circleD.setStrokeWidth(2);
        circleD.setCenterX(420);  // Set horizontal position for circleD
        circleD.setLayoutY(120);  // set Y-coordinate for circleD to 120

        // This will create a Pane to display circles 
        Pane mainPane = new Pane();
        mainPane.getChildren().addAll(pane1, circleB, circleC, circleD);

        // Display Scene setup
        Scene scene = new Scene(mainPane, 600, 300);  
        primaryStage.setScene(scene);
        primaryStage.setTitle("Displays four circles and 0verlapping Circle Inside Rectangle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
