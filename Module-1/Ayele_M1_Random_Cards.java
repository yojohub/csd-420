/*
 *  Name: Yohannes Ayele
 *  Date: 03/23/25
 *  Assignment: M1: Programing Assignment
 *  Purpose of the code: JavaFX displays four images randomly selected from a deck of 52 Cards and refresh
 *  Gethub: https://github.com/yojohub/csd-420.git
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Ayele_M1_Random_Cards extends Application {
    private List<Image> cards = new ArrayList<>();
    private HBox cardBox = new HBox(10);
    

    @Override
    public void start(Stage firstStage) {
        // This will load card images from the "Cards" folder
        loadCards();

        // This will shows initial random cards
        shuffleCardsAndDisplay();

        // This create a refresh random cards button
        Button refreshButton = new Button("Refresh Cards");
        refreshButton.setOnAction(e -> shuffleCardsAndDisplay());

        // Refresh button Layout
        VBox layout = new VBox(20, cardBox, refreshButton);

        // Set up scene layout for the display cards
        Scene scene = new Scene(layout, 650, 300);
        firstStage.setTitle("Randam Cards Shuffler");
        firstStage.setScene(scene);
        firstStage.show();
    }

    // Shuffle randam cards and display
    private void shuffleCardsAndDisplay() {
        cardBox.getChildren().clear();
        Collections.shuffle(cards);

        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(cards.get(i));
            imageView.setFitWidth(150);
            imageView.setFitHeight(200);
            cardBox.getChildren().add(imageView);
        }
    }

    // Load card images from cards folder
    private void loadCards() {
        File folder = new File("Cards");
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                cards.add(new Image(file.toURI().toString()));
            }
        }
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
