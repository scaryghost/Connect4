/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.canvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;
import javax.swing.JApplet;

/**
 *
 * @author etsai
 */
public class GraphicsCanvasApplet extends JApplet {
    private List<List<Integer>> board;
    final static Color bg = Color.white;
    final static Color fg = Color.black;
    final static BasicStroke stroke = new BasicStroke(2.0f);

    @Override
    public void init() {
        //Initialize drawing colors
        setBackground(bg);
        setForeground(fg);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw Ellipse2D.Double
        g2.setStroke(stroke);
        g2.draw(new Ellipse2D.Double(640, 360, 100, 100));
        
    }
    
    public void updateBoard(List<List<Integer>> board) {
        this.board= board;
    }
}
