package Chapter_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * Exercise 14.2
 * Write a program that displays a tic-tac-toe board with images.  A cell may be
 * X, O, or empty.  What to display in each cell is randomly decided. The X and
 * O are images in the files x.gif and o.gif.
 * @Author Michael Martin
 */
public class Exercise_02 extends Application {
    @Override // Override the start metho in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5);
        pane.setVgap(5);
        
        // Create x, o, or empty space and add it to the pane
        int randomNum;
        ImageView node;
        String image;
        for (int i = 0; i < 3; i++) {
            // Set row constraints in the case of an empty cell
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPrefWidth(100);
            pane.getColumnConstraints().add(colConst);
            
            // Set row constraints in the case of an empty cell
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPrefHeight(100);
            pane.getRowConstraints().add(rowConst);
            
            // Add xs and os to the pane
            for (int j = 0; j < 3; j++) {
                randomNum = (int) (Math.random() * 3);
                if (randomNum != 0) {
                    image = (randomNum == 1) ? "image/x.gif" : "image/o.gif";
                    // Size the nodes based on the window
                    node = new ImageView(new Image(image));
                    node.setFitHeight(100);              
                    node.setFitWidth(100);
                    pane.add(node, j, i); // Add node to the pane
                }
            }
        }
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise 02"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
