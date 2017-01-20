/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Solomon
 */
public class MainMenuGUI {

    StackPane sp = new StackPane();
    private Scene s;
    // private Canvas game;

    public void initMainMenuGUI(Stage primaryStage) {
        // Bunch of constants
        final int FONT_SIZE = 200;
        final String COLOR = "#800080";
        final String BACKGROUND_COLOR = "-fx-background-color: teal";
        final int BUTTON_WIDTH = 500;
        final String BUTTON_STYLE = "-fx-font: 50 arial; -fx-base: #b6e7c9;";

        // User screen dimensions
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // All this for a damn title
        final Label titles = new Label("BREAKOUT");
        titles.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, FONT_SIZE));
        titles.setTextFill(Color.web(COLOR));
        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        final Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(9.0);
        titles.setEffect(lighting);

        // Play button
        Button play = new Button();
        play.setText("Play");
        play.setMaxWidth(BUTTON_WIDTH);
        play.setStyle(BUTTON_STYLE);
        play.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameGUI gg;
                gg = new GameGUI(primaryStage);
            }
        });

        String musicFile = "Background.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        // Options button
        Button options = new Button();
        options.setText("Options");
        options.setMaxWidth(BUTTON_WIDTH);
        options.setStyle(BUTTON_STYLE);
        options.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                OptionsGUI og = new OptionsGUI(sp, mediaPlayer);
            }
        });

        // Scoreboard button
        Button scores = new Button();
        scores.setText("Scoreboard");
        scores.setMaxWidth(BUTTON_WIDTH);
        scores.setStyle(BUTTON_STYLE);
        scores.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ScoreboardGUI sg = new ScoreboardGUI(sp);
            }
        });

        // Quit button
        Button quit = new Button();
        quit.setText("Quit");
        quit.setMaxWidth(BUTTON_WIDTH);
        quit.setStyle(BUTTON_STYLE);
        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        // VBOX so that the buttons are directly under eah other lined up
        VBox vb = new VBox(20);
        vb.getChildren().addAll(play, options, scores, quit);
        vb.setAlignment(Pos.CENTER);

        // Stackpane cause 
        sp.getChildren().add(vb);
        StackPane.setAlignment(vb, Pos.CENTER);

        StackPane.setAlignment(titles, Pos.TOP_CENTER);
        sp.getChildren().add(titles);
        sp.setStyle(BACKGROUND_COLOR);

        // Actually show everything
        s = new Scene(sp, bounds.getWidth(), bounds.getHeight());

        // Set up and go
        primaryStage.setTitle("Breakout");

        // Debatable if we should do this or not
        primaryStage.setResizable(false);
        
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setScene(s);
        primaryStage.setOnCloseRequest(e ->
        System.exit(0));
        primaryStage.show();
    }
}
