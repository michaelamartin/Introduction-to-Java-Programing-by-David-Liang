package Chapter_20;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * Exercise 20.5
 * Once two balls collide, remove the later ball that was added to the pane and 
 * add its radius to the other ball. Use the Suspend button to suspend
 * the animation and the Resume button to resume the animation. Add a mouse
 * pressed handler that removes a ball when the mouse is pressed on the ball.
 * @author Michael Martin
 */
public class Exercise_05 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");
        
        Button btSuspend = new Button("Suspend");
        Button btResume = new Button("Resume");
        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btSuspend, btResume, btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);
        
        // Suspend, resume, add, and subtract buttons with event handlers
        btSuspend.setOnAction(e -> ballPane.pause());
        btResume.setOnAction(e -> ballPane.play());
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());
               
        // Use a scroll bar to control animation speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());
        
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);
        
        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Multiple Bounce Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private class MultipleBallPane extends Pane {
        private Timeline animation;
        
        public MultipleBallPane() {
            // Create an animation for moving the balll
            animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }
        
        public void add() {
            Color color = new Color(Math.random(),
                Math.random(), Math.random(), 0.5);
            Ball ball = new Ball(30, 30, 20, color);
            getChildren().add(ball);
            
            ball.setOnMouseClicked(e -> getChildren().remove(ball));
        }
        
        public void subtract() {
            if (getChildren().size() > 0) {
                getChildren().remove(getChildren().size() - 1);
            }
        }
        
        public void play() {
            animation.play();
        }
        
        public void pause() {
            animation.pause();
        }
        
        public void increaseSpeed() {
            animation.setRate(animation.getRate() + 0.1);
        }
        
        public void decreaseSpeed() {
            animation.setRate(
            animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
        }
        
        public DoubleProperty rateProperty() {
            return animation.rateProperty();
        }
        
        protected void moveBall() {
            for (int i = 0; i < this.getChildren().size(); i++) {
                Ball ball = (Ball)this.getChildren().get(i);
                // Check boundaries
                if (ball.getCenterX() < ball.getRadius() || 
                        ball.getCenterX() > getWidth() - ball.getRadius()) {
                    ball.dx *= -1;
                }
                if (ball.getCenterY() < ball.getRadius() || 
                        ball.getCenterY() > getHeight() - ball.getRadius()) {
                    ball.dy *= -1;
                }
                
                // Check for collision
                for (int j = i + 1; j < this.getChildren().size(); j++) {
                    Ball ball2 = (Ball)this.getChildren().get(j);
                    if(ball2.getBoundsInParent().intersects(ball.getBoundsInParent())) {
                        // Add radius of ball2 to ball
                        ball.setRadius(ball.getRadius() + ball2.getRadius());
                        
                        // Remove ball2
                        this.getChildren().remove(ball2);
                        
                        // If new ball radius passes boundary, correct position
                        if (ball.getCenterX() < ball.getRadius())
                            ball.setCenterX(ball.getRadius());
                        else if (ball.getCenterX() > getWidth() - ball.getRadius())
                            ball.setCenterX(getWidth() - ball.getRadius());  
                        if (ball.getCenterY() < ball.getRadius())
                            ball.setCenterY(ball.getRadius());
                        else if (ball.getCenterX() > getWidth() - ball.getRadius()) {
                            ball.setCenterY(getHeight() - ball.getRadius());
                        }
                    }
                }
                
                // Adjust ball position
                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());
            }
        }
    }
    
    class Ball extends Circle {
        private double dx = 1, dy = 1;
        
        Ball(double x, double y, double radius, Color color) {
            super(x, y, radius);
            setFill(color); // Set ball color
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
