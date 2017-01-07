/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Solomon
 */
public class Breakout extends Application {

    private MainMenuGUI mmg;

    @Override
    public void start(Stage primaryStage) {
        mmg = new MainMenuGUI();
        mmg.initMainMenuGUI(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
