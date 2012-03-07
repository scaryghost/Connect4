/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.canvas

import com.github.etsai.connect4.*

/**
 *
 * @author etsai
 */
class TextCanvas implements Canvas {
    private static def checkerTextMap= [(Environment.CHECKER_BLACK):"*",
        (Environment.CHECKER_RED):"O", (Environment.CHECKER_EMPTY):"_"]
    public TextCanvas() {
    }
    public void drawBoard() {
        def rowString
        def coreInstance= Connect4Core.getInstance();
        
        (0 ..< Environment.MAX_ROWS).each {row ->
            rowString= ""
            (0 ..< Environment.MAX_COLS).each {col ->
                rowString+= checkerTextMap[coreInstance.env.getChecker(row,col)]+"\t"
            }
            println rowString
        }
    }
}

