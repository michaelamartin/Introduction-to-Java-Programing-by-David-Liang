package Chapter_20;

import java.util.Collections;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Exercise 20.2
 * Write a program that lets the user enter numbers from a graphical user 
 * interface and displays them in a text area. Use a linked list to store the 
 * numbers. Do not store duplicate numbers. Add the buttons Sort, Shuffle, and 
 * Reverse to sort, shuffle, and reverse the list.
 * @authoer Michael Martin
 */
public class Exercise_02 extends Application {
       
    @Override
    public void start(Stage primaryStage) {           
        // Create a scene and place it in the stage      
        Scene scene = new Scene(new CustomVBox());
        primaryStage.setTitle("Exercise 20.2"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    /** Creates a custom VBox */
    private class CustomVBox extends VBox {
        private TextField tfNumber; // Declare textfield for input
        private TextArea taNumbers; // Declare textarea for output
        
        // Declare linkedlist to store input
        LinkedList<Integer> list;
        
        // No-arg constructor
        CustomVBox() {
            // Initialize empty linked list            
            list = new LinkedList<>();
            
            // Create a gridpane containing a textfield for user input.
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(5));
            gridPane.setHgap(10);
            gridPane.add(new Label("Enter a number: "), 0, 0);
            //Create a red colored error message for incorrect input
            Label errorLabel = new Label("Error: Enter a number.");
            errorLabel.setTextFill(Color.RED);
            errorLabel.setVisible(false); // Hide error message
            tfNumber = new TextField();
            gridPane.add(tfNumber, 1, 0);
            gridPane.add(errorLabel, 2, 0);
            gridPane.setAlignment(Pos.CENTER);
            getChildren().add(gridPane); // Add the grid pane to the custom VBox
            
            // Create textarea with scroll pane to provide output
            taNumbers = new TextArea("Enter a number in the field above and "
                    + "press Enter to store it.");
            // Show instructions as gray text
            taNumbers.setStyle("-fx-text-inner-color: gray;");
            taNumbers.setPrefRowCount(5);
            taNumbers.setWrapText(true);
            taNumbers.setEditable(false);
            ScrollPane scrollPane = new ScrollPane(taNumbers);
            getChildren().add(scrollPane);
            
            // Create an HBox containing sort, shuffle, and reverse buttons
            HBox hBox = new HBox();
            hBox.setPadding(new Insets(5));
            hBox.setSpacing(10);
            Button btSort = new Button("Sort");
            Button btShuffle = new Button("Shuffle");
            Button btReverse = new Button("Reverse");
            hBox.getChildren().add(btSort);
            hBox.getChildren().add(btShuffle);
            hBox.getChildren().add(btReverse);
            hBox.setAlignment(Pos.CENTER);
            getChildren().add(hBox); // Add the HBox to the custom VBox
            
            // Event handler for Enter key press
            tfNumber.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case ENTER:
                        // Try to parse input, throw format exception
                        try {
                            list.add(Integer.parseInt(tfNumber.getText()));
                            // Change text area font color to black
                            taNumbers.setStyle("-fx-text-inner-color: black;");
                            tfNumber.clear();
                            errorLabel.setVisible(false); // Hide error message 
                            refreshTextArea();
                        }
                        catch (NumberFormatException ex) {
                            errorLabel.setVisible(true); // Show error message
                        }
                        break;
                }
            });

            // Event handler for sort button
            btSort.setOnAction(e -> {
                Collections.sort(list);
                refreshTextArea();
            });

            // Event handler for shuffle button
            btShuffle.setOnAction(e -> {
                Collections.shuffle(list);
                refreshTextArea();
            });

            // Event handler for reverse button
            btReverse.setOnAction(e -> {
                Collections.reverse(list);
                refreshTextArea();
            });
        }
        
        // refresh the textarea output
        private void refreshTextArea() {
            String string = "";
            for (Integer number : list)
                string += number + " ";
            taNumbers.setText(string);    
        }              
    }
    
    /** Testing */
    public static void main(String[] args) {
        Application.launch(args);
    }
}