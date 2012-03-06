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
        Random rndGen= new Random(123456789);
        Environment myEnv= new Environment();
        Canvas myCanvas;
        boolean textMode= false;
        for (String s: args) {
            if ("--text-mode".equals(s)) {
                textMode= true;

            }
        }
        if (textMode) {
            myCanvas= new TextCanvas();
        } else {
            myCanvas= new GraphicsCanvas();
        }
        
        for(int i= 0; i < 15; i++) {
            int checker= (i%2 == 0 ? Environment.CHECKER_BLACK : Environment.CHECKER_RED);
            myEnv.addChecker(rndGen.nextInt(Environment.MAX_COLS),checker);
        }
        myEnv.drawBoard(myCanvas);
    }
}
