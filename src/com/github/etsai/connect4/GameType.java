/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4;

import com.github.etsai.connect4.canvas.GraphicsCanvas;
import com.github.etsai.connect4.canvas.TextCanvas;
import com.github.etsai.connect4.gametype.GameTypeImpl;

/**
 *
 * @author etsai
 */
public abstract class GameType {
    private static GameType instance= null;
    
    public static void init(String[] args) {
        boolean textMode= false;
        Canvas canvas;
        
        for (String s: args) {
            if ("--text-mode".equals(s)) {
                textMode= true;
            }
        }
        
        if (textMode) {
            canvas= new TextCanvas();
        } else {
            canvas= new GraphicsCanvas();
        }
        instance= new GameTypeImpl(canvas);
    }
    public GameType getInstance() throws Exception {
        if (instance == null) {
            throw new Exception("GameType not initialized yet!");
        }
        return instance;
    }
     
    abstract public boolean isGameOver();
}
