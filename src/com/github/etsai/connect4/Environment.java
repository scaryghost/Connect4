/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4;

import java.util.List;

/**
 *
 * @author eric
 */
public class Environment {
    public final static Integer CHECKER_RED= -1;
    public final static Integer CHECKER_EMPTY= 0;
    public final static Integer CHECKER_BLACK= 1;
    
    public final static Integer MAX_ROWS= 6;
    public final static Integer MAX_COLS= 7;
    
    private List<List<Integer>> board;
    private List<Integer> checkerRows;
    
    public void addChecker(int column, int checker) throws Exception {
        int topRow= checkerRows.get(column);
        List<Integer> currentRow;
        
        if (topRow == 0) {
            throw new Exception("Column "+column+" is full!");
        }
        topRow--;
        checkerRows.set(column,topRow);
        currentRow= board.get(topRow);
        currentRow.set(column,checker);
        board.set(topRow, currentRow);
    }
    public void removeChecker(int column) throws Exception {
        int topRow= checkerRows.get(column);
        List<Integer> currentRow;
        
        if (topRow == MAX_ROWS - 1) {
            throw new Exception("Colum "+column+" is empty!");
        }
        topRow++;
        checkerRows.set(column,topRow);
        currentRow= board.get(topRow);
        currentRow.set(column, CHECKER_EMPTY);
        board.set(topRow, currentRow);
    }
    public void drawBoard(Canvas myCanvas) {
        myCanvas.drawBoard(board);
    }
}
