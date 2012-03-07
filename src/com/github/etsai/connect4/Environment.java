/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4;

import java.util.ArrayList;
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
    
    public static boolean outOfBounds(int row, int col) {
        return (row < 0 || row >= MAX_ROWS 
                || col < 0 || col >= MAX_COLS);
    }
    public Environment() {
        checkerRows= new ArrayList<>(MAX_COLS);
        board= new ArrayList<>(MAX_ROWS);
        
        for(int r= 0; r < MAX_ROWS; r++) {
            ArrayList<Integer> temp= new ArrayList<>(MAX_COLS);
            for(int c= 0; c < MAX_COLS; c++) {
                temp.add(CHECKER_EMPTY);
            }
            board.add(r,temp);
        }
        for(int c= 0; c < MAX_COLS; c++) {
            checkerRows.add(c,MAX_ROWS);
        }
    }
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
    public Integer getChecker(int row, int col) {
        return board.get(row).get(col);
    }
    public Integer getNextRow(int col) {
        return checkerRows.get(col)-1;
    }
}
