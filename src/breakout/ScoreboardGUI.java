/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Solomon
 */
public class ScoreboardGUI {
    VBox p = new VBox();
    ListView lv = new ListView();
    
    ScoreboardGUI(StackPane sp) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        lv.setPrefWidth(bounds.getWidth());
        lv.setPrefHeight(bounds.getHeight());
        ObservableList items = FXCollections.observableArrayList("Player1", "Player2", "Player3");
        lv.setItems(items);
        p.getChildren().add(lv);
        sp.getChildren().add(p);
    }
}
