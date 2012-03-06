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
class GameTypeImpl extends GameType {
    private Controller currentController= null;
    private Environment env= new Environment();
    private Canvas canvas;
    
    private enum Directions {
        UP_LEFT(-1,-1),
        UP(-1,0),
        UP_RIGHT(-1,1),
        LEFT(0,-1),
        RIGHT(0,1),
        DOWN_LEFT(1,-1),
        DOWN(1,0),
        DOWN_RIGHT(1,1);
        
        private int rowOffset
        private int colOffset
        
        public Directions(rowOffset, colOffset) {
            this.rowOffset= rowOffset
            this.colOffset= colOffset
        }
        public int getRowOffset() {
            return rowOffset
        }
        public int getColOffset() {
            return colOffset
        }
    }
    
    public GameTypeImpl(Canvas canvas) {
        this.canvas= canvas
    }
    
    @Override
    public boolean isGameOver() {
        def checker
        def directionList= Directions.values()
        def directionIndex
        
        def check= {row, col, depth ->
            if (Environment.outOfBounds(row, col)) {
                return false
            }
            
            def equal= (checker != Environment.CHECKER_EMPTY && env.getChecker(row,col) == checker)
            if (depth == 4) {
                return equal
            }
            
            return equal && call(row + directionList[directionIndex].getRowOffset(), 
                col + directionList[directionIndex].getColOFfset(), depth + 1)
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

