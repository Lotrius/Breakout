/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Solomon
 */
public class GameGUI {

    private Screen screen;
    private StackPane sp;
    private Scene s;
    Pane game;

    public GameGUI(Stage primaryStage) {
        final String BACKGROUND_COLOR = "-fx-background-color: white";

        screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        sp = new StackPane();
        sp.setStyle(BACKGROUND_COLOR);

        drawShapes(bounds);

        s = new Scene(sp, bounds.getWidth(), bounds.getHeight());
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.ESCAPE) {
                    MainMenuGUI mmg = new MainMenuGUI();
                    mmg.initMainMenuGUI(primaryStage);
                    System.out.println("Hi");
                }
            }
        });

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setScene(s);
        primaryStage.show();
    }

    private void drawShapes(Rectangle2D bounds) {
        final int PADDLE_WIDTH = 200;
        final int PADDLE_HEIGHT = 25;

        game = new Pane();

        Rectangle paddle = new Rectangle(bounds.getWidth() / 2, bounds.getHeight() - 100, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFill(Color.CADETBLUE);

        Label label = new Label("x: " + paddle.getX() + " y: " + paddle.getY());
        game.getChildren().add(label);

        game.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String coor = "x: " + paddle.getX() + " y: " + paddle.getY();
                label.setText(coor);

                double point = event.getX();
                paddle.setX(point - (paddle.getWidth() / 2));

                // I GOT THE MATH RIGHT THE FIRST TRY HALLELUJAH
                // Stop the paddle from going past the screen to the right
                if ((paddle.getX() + paddle.getWidth()) >= bounds.getWidth()) {
                    paddle.setX(bounds.getWidth() - paddle.getWidth());
                }

                // Stop the paddle from going past the screen to the left
                if (paddle.getX() <= 0) {
                    paddle.setX(0);
                }
            }
        });

        sp.getChildren().add(game);

        game.getChildren().add(paddle);

    }
}
