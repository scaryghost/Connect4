/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4.controller

import com.github.etsai.connect4.*

/**
 *
 * @author etsai
 */
class PlayerController implements Controller {
    private boolean hasMoved
    
    @Override
    public void setHasMoved() {
        hasMoved= true
    }
    @Override
    public void move(Environment env) {
        hasMoved= false;
        while(!hasMoved) {
            Thread.sleep(100)
        }
    }
}

