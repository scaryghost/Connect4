/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etsai.connect4;

import com.github.etsai.connect4.canvas.GraphicsCanvas;
import com.github.etsai.connect4.canvas.TextCanvas;
import java.util.Random;

/**
 *
 * @author etsai
 */
public class Connect4Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Connect4Core.getInstance();
        GameType.init(args);
        GameType.getInstance().begin();
    }
}
