/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.canvas

import com.github.etsai.connect4.*

import java.awt.*
import java.awt.event.*
import java.awt.geom.Ellipse2D
import java.awt.geom.Rectangle2D
import java.util.List
import javax.swing.JApplet

/**
 *
 * @author etsai
 */
public class GraphicsCanvasApplet extends JApplet implements MouseListener, MouseMotionListener {
    private def cursorRowCol= null
    private def board;
    final static def stroke = new BasicStroke(2.0f);

    @Override
    public void init() {
        //Initialize drawing colors
        setBackground(Color.white);
        addMouseListener( this );
        addMouseMotionListener( this );
    }
    
    @Override
    public void paint(Graphics g) {
        def r, c
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw Ellipse2D.Double
        g2.setStroke(stroke);
        r= 0
        g2.setColor(Color.yellow)
        g2.fill(new Rectangle2D.Double(50,0,800,720))
        board.each {row ->
            c= 1
            row.each {checker ->
                if (checker == Environment.CHECKER_BLACK) {
                    g2.setColor(Color.black)
                    g2.fill(new Ellipse2D.Double(100*c, 100*r+50, 75, 75))
                } else if (checker == Environment.CHECKER_RED) {
                    g2.setColor(Color.red)
                    g2.fill(new Ellipse2D.Double(100*c, 100*r+50, 75, 75))
                } else if (checker == Environment.CHECKER_EMPTY) {
                    if (cursorRowCol != null && 
                        cursorRowCol[0] == r && cursorRowCol[1] == c - 1) {
                        g2.setColor(Color.gray)
                        g2.fill(new Ellipse2D.Double(100*c, 100*r+50, 75, 75))
                        cursorRowCol= null
                    } else {
                        g2.setColor(Color.white)
                        g2.fill(new Ellipse2D.Double(100*c, 100*r+50, 75, 75))
                    }
                    
                }
                c++
            }
            r++
        }
        
        
    }
    
    public void mousePressed( MouseEvent e ) {  // called after a button is pressed down
      //isButtonPressed = true;
      // "Consume" the event so it won't be processed in the
      // default manner by the source which generated it.
      e.consume();
    }
    public void mouseReleased( MouseEvent e ) {  // called after a button is released
      //isButtonPressed = false;
      e.consume();
    }
    public void mouseMoved( MouseEvent e ) {  // called during motion when no buttons are down
        def coreInstance= Connect4Core.getInstance()
        def mx = e.getX();
        def my = e.getY();
      
        (1 .. 7).each {index ->
            if (mx > 100*index && mx < (100*index)+75) {
                cursorRowCol= [coreInstance.env.getNextRow(index-1), index-1]
            }
        }
        repaint()
        e.consume();
    }
   
    public void updateBoard(List<List<Integer>> board) {
        this.board= board;
    }
    
    public void mouseEntered( MouseEvent e ) {
      // called when the pointer enters the applet's rectangular area
      e.consume();
    }
    public void mouseExited( MouseEvent e ) {
      // called when the pointer leaves the applet's rectangular area
      e.consume();
    }
    public void mouseClicked( MouseEvent e ) {
      // called after a press and release of a mouse button
      // with no motion in between
      // (If the user presses, drags, and then releases, there will be
      // no click event generated.)
      e.consume();
    }
    public void mouseDragged( MouseEvent e ) {  // called during motion with buttons down
      e.consume();
   }
}
