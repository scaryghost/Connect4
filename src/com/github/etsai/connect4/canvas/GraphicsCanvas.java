/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.canvas;

import com.github.etsai.connect4.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 *
 * @author etsai
 */
public class GraphicsCanvas implements Canvas {
    JFrame canvasFrame;
    GraphicsCanvasApplet canvasApplet;
    
    public GraphicsCanvas() {
        canvasFrame= new JFrame("Connect4");
        canvasApplet= new GraphicsCanvasApplet();
        
        canvasFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        canvasFrame.getContentPane().add("Center", canvasApplet);
        canvasApplet.init();
        canvasFrame.pack();
        canvasFrame.setSize(new Dimension(1280,720));
        canvasFrame.setVisible(true);
    }
    
    @Override
    public void drawBoard(List<List<Integer>> board) {
        canvasApplet.updateBoard(board);
        canvasApplet.repaint();
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
