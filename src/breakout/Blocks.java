/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.util.ArrayList;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

/**
 *
 * @author Solomon
 */
public class Blocks{
    final int BLOCK_WIDTH = 120;
    final int BLOCK_HEIGHT = 25;
    
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    
    ArrayList<Rectangle> blocks = new ArrayList<>();
    
    public ArrayList<Rectangle> createArray() {
        int i,y;
        int horizStart = 0;
        int vertStart = 100;
        
        for (y = 0; y < 5; y++) {
            for (i = 0; i < 16; i++) {
                Rectangle rect = new Rectangle(horizStart, vertStart, BLOCK_WIDTH, BLOCK_HEIGHT);
                rect.setFill(Color.BLUE);
                rect.setStroke(Color.RED);
                blocks.add(rect);
                horizStart += BLOCK_WIDTH;
            }
            vertStart += BLOCK_HEIGHT;
            horizStart = 0;
        }

        return blocks;
    }
}
