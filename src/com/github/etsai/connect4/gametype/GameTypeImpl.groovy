/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.gametype

import com.github.etsai.connect4.*
import com.github.etsai.connect4.controller.*
import com.github.etsai.connect4.canvas.*

/**
 *
 * @author eric
 */
public class GameTypeImpl extends GameType {
    private Integer player= 1;
    private GameType.State gameState= GameType.State.PLAYING;
    
    public GameTypeImpl() {
        def coreInstance= Connect4Core.getInstance()
        
        if (coreInstance.textMode) {
            coreInstance.canvas= new TextCanvas();
            coreInstance.controllerList.add(new PlayerTextController())
            coreInstance.controllerList.add(new PlayerTextController())
        } else {
            coreInstance.canvas= new GraphicsCanvas();
            coreInstance.controllerList.add(new PlayerController())
            coreInstance.controllerList.add(new PlayerController())
        }
        
        
    }
    
    @Override
    public boolean isGameOver() {
        def checker
        def coreInstance= Connect4Core.getInstance()
        def directionList= [[-1,-1], [-1,0], [-1,1],
                [0,-1], [0,1], [1,-1],
                [1,0],[1,1]]
        def directionIndex
        
        def check= {row, col, depth ->
            if (Environment.outOfBounds(row, col)) {
                return false
            }
            
            def equal= (checker != Environment.CHECKER_EMPTY 
                && coreInstance.env.getChecker(row,col) == checker)
            if (depth == 3) {
                return equal
            }
            
            return equal && call(row + directionList[directionIndex][0], 
                col + directionList[directionIndex][1], depth + 1)
        }

        for(row in 0 ..< Environment.MAX_ROWS) {
            for(col in 0 ..< Environment.MAX_COLS) {
                checker= coreInstance.env.getChecker(row, col)
                for(index in 0 ..< directionList.size()) {
                    directionIndex= index
                    if (check(row, col, 0)) {
                        return true
                    }
                }
            }
        }
        return false
    }
    
    @Override
    public GameType.State getGameState() {
        return gameState
    }
    @Override
    public Controller getCurrentController() {
        return Connect4Core.getInstance().controllerList.get(player);
    }
    @Override
    public Integer getCurrentPlayer() {
        return player
    }
    @Override
    public void begin() {
        def coreInstance= Connect4Core.getInstance()
        
        while(!isGameOver()) {
            coreInstance.controllerList.get(player).move()
            coreInstance.canvas.drawBoard()
            player= (player + 1) % coreInstance.controllerList.size()
        }
        gameState= GameType.State.END
    }
}

