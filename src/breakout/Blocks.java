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
    final int BLOCK_HEIGHT = 50;
    
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    
    ArrayList<Rectangle> blocks = new ArrayList<>();
    
    public ArrayList<Rectangle> createArray() {
        int i;
        int start = 0;
        
        for(i = 0; i <= 16; i++) {
            Rectangle rect = new Rectangle(start, 500, BLOCK_WIDTH, BLOCK_HEIGHT);
            rect.setFill(Color.BLUE);
            rect.setStroke(Color.RED);
            blocks.add(rect);
            start += BLOCK_WIDTH;
        }
       
        return blocks;
    }
}
