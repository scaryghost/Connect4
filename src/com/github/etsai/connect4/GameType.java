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
    
    public enum State {
        PLAYING,
        END;
    }
    
    public static void init(String[] args) {
        Connect4Core coreInstance= Connect4Core.getInstance();
        
        for (String s: args) {
            if ("--text-mode".equals(s)) {
                coreInstance.textMode= true;
            }
        }
        
        instance= new GameTypeImpl();
    }
    public static GameType getInstance() throws Exception {
        if (instance == null) {
            throw new Exception("GameType not initialized yet!");
        }
        return instance;
    }
    
    abstract public State getGameState();
    abstract protected boolean isGameOver();
    abstract public Controller getCurrentController();
    abstract public Integer getCurrentPlayer();
    abstract public void begin();
}
