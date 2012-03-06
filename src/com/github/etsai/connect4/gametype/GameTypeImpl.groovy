/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.gametype

import com.github.etsai.connect4.*

/**
 *
 * @author eric
 */
public class GameTypeImpl extends GameType {
    private def controllerListIt= null;

    public GameTypeImpl(Canvas canvas) {
        def coreInstance= Connect4Core.getInstance()
        coreInstance.canvas= canvas
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
            if (depth == 4) {
                return equal
            }
            
            return equal && call(row + directionList[directionIndex][0], 
                col + directionList[directionIndex][1], depth + 1)
        }

        (0 ..< Environment.MAX_ROWS).each {row ->
            (0 ..< Environment.MAX_COLS).each {col ->
                checker= coreInstance.env.getChecker(row, col)
                (0 ..< directionList.size()).each {index ->
                    directionIndex= index
                    if (check(row, col, 0)) {
                        return true
                    }
                }
            }
        }
    }
    @Override
    public void move() {
        def coreInstance= Connect4Core.getInstance()
        if (controllerListIt == null || !controllerListIt.hasNext()) {
            controllerListIt= Connect4Core.getInstance().controllerList.iterator();
        }
        controllerListIt.next().move(coreInstance.env)
        coreInstance.env.drawBoard(coreInstance.canvas);
    }
}

