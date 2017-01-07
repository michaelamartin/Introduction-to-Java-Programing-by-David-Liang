package Chapter_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Exercise 14.1
 * Write a program that displays four images in a grid pane.
 * @author Michael Martin
 */
public class Exercise_01 extends Application{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        
        // Create a grid pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
        // Create 4 smiley faces and add them to the pane
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ImageView smile = new ImageView(new Image("Images/smile.png"));
                // Scale smiley faces based on pane width                
                smile.fitHeightProperty().bind(pane.widthProperty().divide(2.5));                
                smile.fitWidthProperty().bind(pane.widthProperty().divide(2.5));
                pane.add((smile), i, j); // Add a smiley face to the pane
            }
        }
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise 01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
