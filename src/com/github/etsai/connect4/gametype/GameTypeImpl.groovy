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
    private Controller currentController= null;
    private Environment env= new Environment();
    private Canvas canvas;
    
    public GameTypeImpl(Canvas canvas) {
        this.canvas= canvas
    }
    
    @Override
    public boolean isGameOver() {
        def checker
        def directionList= [[-1,-1], [-1,0], [-1,1],
                [0,-1], [0,1], [1,-1],
                [1,0],[1,1]]
        def directionIndex
        
        def check= {row, col, depth ->
            if (Environment.outOfBounds(row, col)) {
                return false
            }
            
            def equal= (checker != Environment.CHECKER_EMPTY && env.getChecker(row,col) == checker)
            if (depth == 4) {
                return equal
            }
            
            return equal && call(row + directionList[directionIndex][0], 
                col + directionList[directionIndex][1], depth + 1)
        }

        (0 ..< Environment.MAX_ROWS).each {row ->
            (0 ..< Environment.MAX_COLS).each {col ->
                checker= env.getChecker(row, col)
                (0 ..< directionList.size()).each {index ->
                    directionIndex= index
                    if (check(row, col, 0)) {
                        return true
                    }
                }
            }
        }
    }
}

