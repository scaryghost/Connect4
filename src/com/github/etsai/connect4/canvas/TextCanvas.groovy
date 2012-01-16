/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.canvas

import com.github.etsai.connect4.Canvas

/**
 *
 * @author etsai
 */
class TextCanvas implements Canvas {
    public TextCanvas() {
    }
    public void drawBoard(List<List<Integer> > board) {
        def rowString
        
        board.each {row ->
            rowString= ""
            row.each {checker ->
                rowString+= checker
            }
            println rowString
        }
    }
}

