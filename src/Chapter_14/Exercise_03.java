package Chapter_14;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Exercise 14.3
 * Write a program that displays three cards randomly selected from a deck of 
 * 52. The card image files are named 1.png, 2.png, …, 52.png and stored in the
 * image/card directory. All three cards are distinct and selected randomly.
 * @Author Michael Martin
 */
public class Exercise_03 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(20);
        pane.setVgap(10);
        
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            cards.add(i);
        }
        // Shuffle the deck
        Collections.shuffle(cards);
        
        // Draw the top 3 cards and add them to the pane
        ImageView card;
        for (int i = 0; i < 3; i++) {
            card = new ImageView(new Image("image/cards/" + cards.get(i) + ".png"));
            card.setFitWidth(250); // Resize width to fit in pane
            card.setPreserveRatio(true); // Preserve original aspect ratio
            pane.add(card, i, 0); // Add card to the grid pane
        }
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 800, 400);
        primaryStage.setResizable(false); // Do not allow resizing
        primaryStage.setTitle("Exercise 14.3"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
