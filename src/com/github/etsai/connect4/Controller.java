/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etsai.connect4;

/**
 *
 * @author etsai
 */
public interface Controller {
    public void move(Environment env);
    public void setHasMoved();
}
