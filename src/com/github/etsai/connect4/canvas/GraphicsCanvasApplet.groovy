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
    private def isButtonPressed
    private final static def stroke= new BasicStroke(2.0f)
    private static def checkerColorMap= [(Environment.CHECKER_BLACK):Color.black,
        (Environment.CHECKER_RED):Color.red, (Environment.CHECKER_EMPTY):Color.white]
    private static def previewColor= Color.lightGray
    
    @Override
    public void init() {
        //Initialize drawing colors
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        def coreInstance= Connect4Core.getInstance();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw Ellipse2D.Double
        g2.setStroke(stroke);
        g2.setColor(Color.yellow)
        g2.fill(new Rectangle2D.Double(50,0,800,720))
        (0 ..< Environment.MAX_ROWS).each {row ->
            (0 ..< Environment.MAX_COLS).each {col ->
                def checker= coreInstance.env.getChecker(row,col)
                def checkerColor
                
                checkerColor= checkerColorMap[checker]
                if (checker == Environment.CHECKER_EMPTY) {
                    if (cursorRowCol != null && 
                        cursorRowCol[0] == row && cursorRowCol[1] == col) {
                        checkerColor= previewColor
                        cursorRowCol= null
                    }
                }
                g2.setColor(checkerColor)
                g2.fill(new Ellipse2D.Double(100*(col+1), 100*row+50, 75, 75))
            }
        }
        
        
    }
    
    public void mousePressed( MouseEvent e ) {  // called after a button is pressed down
      isButtonPressed = true;
      // "Consume" the event so it won't be processed in the
      // default manner by the source which generated it.
      e.consume();
    }
    public void mouseReleased( MouseEvent e ) {  // called after a button is released
        isButtonPressed = false;
        def coreInstance= Connect4Core.getInstance()
        def mx = e.getX();
        def my = e.getY();
        
        if (GameType.getInstance().getGameState() == GameType.State.PLAYING) {
            for (index in 1 .. 7) {
                if (mx > 100*index && mx < (100*index)+75) {
                    if (GameType.getInstance().getCurrentPlayer() == 0) {
                        coreInstance.env.addChecker(index-1,Environment.CHECKER_BLACK)
                    } else {
                        coreInstance.env.addChecker(index-1,Environment.CHECKER_RED)
                    }
                    GameType.getInstance().getCurrentController().setHasMoved()
                    break
                }
            }
        }
        e.consume();        
    }
    public void mouseMoved( MouseEvent e ) {  // called during motion when no buttons are down
        def coreInstance= Connect4Core.getInstance()
        def mx = e.getX();
        def my = e.getY();
      
        if (GameType.getInstance().getGameState() == GameType.State.PLAYING) {
            for (index in 1 .. 7) {
                if (mx > 100*index && mx < (100*index)+75) {
                    cursorRowCol= [coreInstance.env.getNextRow(index-1), index-1]
                    break
                }
            }
        }
        repaint()
        e.consume();
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
