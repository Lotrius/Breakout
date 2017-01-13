/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Solomon
 */
public class GameGUI {
    Pane dimP = new Pane();
    StackPane menuSP = new StackPane();
    Canvas tC;
    
    private Screen screen;
    private StackPane sp;
    private Scene s;
    Pane game;

    public GameGUI(Stage primaryStage) {
        initESCMenu();
        
        final String BACKGROUND_COLOR = "-fx-background-color: white";

        screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        sp = new StackPane();
        sp.setStyle(BACKGROUND_COLOR);

        drawShapes(bounds);

        s = new Scene(sp, bounds.getWidth(), bounds.getHeight());
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    if (!sp.getChildren().contains(dimP)) {
                        sp.getChildren().add(dimP);
                        sp.getChildren().add(menuSP);
                        menuSP.setOnMouseMoved(e -> {
                            menuSP.getChildren().remove(tC);
                            if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 5 &&
                                    e.getY() < 97.5) {
                                s.setCursor(Cursor.HAND);
                                tC = new Canvas(300, 400);
                                GraphicsContext tgc = tC.getGraphicsContext2D();
                                tgc.setLineWidth(10);
                                tgc.setFill(Color.HOTPINK);
                                tgc.setStroke(Color.BLACK);
                                tgc.fillRect(5, 5, 290, 92.5);
                                tgc.setFill(Color.BLUE);
                                tgc.setFont(new Font("Tahoma", 30));
                                tgc.fillText("Back to Game", 20, 50);
                                menuSP.getChildren().add(tC);
                            }
                            else if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 102.5 &&
                                    e.getY() < 197.5) {
                                s.setCursor(Cursor.HAND);
                                tC = new Canvas(300, 400);
                                GraphicsContext tgc = tC.getGraphicsContext2D();
                                tgc.setLineWidth(10);
                                tgc.setFill(Color.HOTPINK);
                                tgc.setStroke(Color.BLACK);
                                tgc.fillRect(5, 102.5, 290, 95);
                                tgc.setFill(Color.BLUE);
                                tgc.setFont(new Font("Tahoma", 30));
                                tgc.fillText("Settings", 20, 150);
                                menuSP.getChildren().add(tC);
                            }
                            else if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 202.5 &&
                                    e.getY() < 297.5) {
                                s.setCursor(Cursor.HAND);
                                tC = new Canvas(300, 400);
                                GraphicsContext tgc = tC.getGraphicsContext2D();
                                tgc.setLineWidth(10);
                                tgc.setFill(Color.HOTPINK);
                                tgc.setStroke(Color.BLACK);
                                tgc.fillRect(5, 202.5, 290, 95);
                                tgc.setFill(Color.BLUE);
                                tgc.setFont(new Font("Tahoma", 30));
                                tgc.fillText("Back to Menu", 20, 250);
                                menuSP.getChildren().add(tC);
                            }
                            else if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 302.5 &&
                                    e.getY() < 397.5) {
                                s.setCursor(Cursor.HAND);
                                tC = new Canvas(300, 400);
                                GraphicsContext tgc = tC.getGraphicsContext2D();
                                tgc.setLineWidth(10);
                                tgc.setFill(Color.HOTPINK);
                                tgc.setStroke(Color.BLACK);
                                tgc.fillRect(5, 302.5, 290, 92.5);
                                tgc.setFill(Color.BLUE);
                                tgc.setFont(new Font("Tahoma", 30));
                                tgc.fillText("Exit", 20, 350);
                                menuSP.getChildren().add(tC);
                            }
                            else {
                                s.setCursor(Cursor.DEFAULT);
                            }
                        });
                        menuSP.setOnMouseClicked(e -> {
                            menuSP.getChildren().remove(tC);
                            if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 5 &&
                                    e.getY() < 97.5) {
                                sp.getChildren().remove(dimP);
                                sp.getChildren().remove(menuSP);
                            }
                            else if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 102.5 &&
                                    e.getY() < 197.5) {
                                
                            }
                            else if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 202.5 &&
                                    e.getY() < 297.5) {
                                
                            }
                            else if (e.getX() > 5 &&
                                    e.getX() < 295 &&
                                    e.getY() > 302.5 &&
                                    e.getY() < 397.5) {
                                System.exit(0);
                            }
                        });
                    }
                    else {
                        sp.getChildren().remove(dimP);
                        sp.getChildren().remove(menuSP);
                    }

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
    private void initESCMenu () {
        dimP.setStyle("-fx-background-color: grey");
        dimP.setOpacity(0.5);
        menuSP.setMaxSize(300, 400);
        menuSP.setStyle("-fx-background-color: pink");
        menuSP.setOpacity(0.5);
        Canvas menuC = new Canvas (300, 400);
        GraphicsContext gc = menuC.getGraphicsContext2D();
        gc.setLineWidth(10);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(0, 0, 300, 0);
        gc.strokeLine(0, 0, 0, 400);
        gc.strokeLine(300, 0, 300, 400);
        gc.strokeLine(0, 400, 300, 400);
        
        gc.setLineWidth(5);
        gc.strokeLine(0, 100, 300, 100);
        gc.strokeLine(0, 200, 300, 200);
        gc.strokeLine(0, 300, 300, 300);

        
        gc.setFill(Color.BLUE);
        gc.setFont(new Font("Tahoma", 30));
        gc.fillText("Exit", 20, 350);
        gc.fillText("Back to Menu", 20, 250);
        gc.fillText("Settings", 20, 150);
        gc.fillText("Back to Game", 20, 50);
        

        menuSP.getChildren().add(menuC);
    }
}