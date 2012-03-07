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
    public boolean hasMoved= false
    
    @Override
    public void setHasMoved() {
        hasMoved= true
    }
    @Override
    public void move(Environment env) {
        hasMoved= false;
        println "Yee HAW!"
        while(!hasMoved);
        println "Done moving!"
    }
}

