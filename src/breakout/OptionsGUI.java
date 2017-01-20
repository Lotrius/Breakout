/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Solomon
 */
public class OptionsGUI {
    private double SFXVolume = 100;
    public OptionsGUI (StackPane sp, MediaPlayer background) {
        Stage stage = new Stage();
        StackPane sp1 = new StackPane();
        sp1.setStyle("-fx-background-color: hotpink");
        BorderPane bp = new BorderPane();
        VBox leftV = new VBox();
        leftV.setSpacing(30);
        leftV.setPrefWidth(120);
        leftV.setAlignment(Pos.TOP_CENTER);
        VBox rightV = new VBox();
        rightV.setSpacing(30);
        VBox midV = new VBox();
        midV.setSpacing(30);
        rightV.setAlignment(Pos.TOP_RIGHT);
        Label placeHolder = new Label();
        Label placeHolder1 = new Label();
        Label screenRes = new Label("Screen Resolution");
        Label backMus = new Label("Background Music");
        Label SFXMus = new Label("SFX Music");
        Slider backS = new Slider(0, 100, 1);
        backS.setValue(100);
        backS.setShowTickLabels(true);
        backS.setShowTickMarks(true);
        backS.setMajorTickUnit(50);
        backS.setMinorTickCount(5);
        backS.setOnMouseReleased(e -> {
            double volume = backS.getValue() / 100;
            background.setVolume(volume);
        });
        Slider SFXS = new Slider(0, 100, 1);
        SFXS.setValue(100);
        SFXS.setShowTickLabels(true);
        SFXS.setShowTickMarks(true);
        SFXS.setMajorTickUnit(50);
        SFXS.setMinorTickCount(5);
        SFXS.setOnMouseReleased(e -> {
            SFXVolume = SFXS.getValue() / 100;
            
        });
        ComboBox resCB = new ComboBox();
        Button xBut = new Button ("X");
        xBut.setStyle("-fx-background-color: transparent");
        xBut.setFont(Font.font("Monospaced", 15));
        xBut.setOnMouseEntered(e -> xBut.setCursor(Cursor.HAND));
        xBut.setOnMouseClicked(e -> stage.close());
        resCB.getItems().addAll("1366 x 768", "1600 x 900", "1920 x 1080");
        resCB.getSelectionModel().select("1920 x 1080");
        Button close = new Button("close");
        close.setOnMouseClicked(e -> stage.close());
        sp1.getChildren().add(bp);
        HBox bot = new HBox();
        bot.setAlignment(Pos.TOP_CENTER);
        bot.getChildren().add(close);
        bot.setPrefHeight(100);
        bp.setLeft(leftV);
        bp.setRight(rightV);
        bp.setCenter(midV);
        bp.setBottom(bot);
        leftV.getChildren().addAll(placeHolder, screenRes, backMus, SFXMus);
        rightV.getChildren().addAll(xBut);
        midV.getChildren().addAll(placeHolder1, resCB, backS, SFXS);
        stage.setScene(new Scene(sp1, 400, 400));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }    
    public double getSFXVolume () {
        return SFXVolume;
    }
}
