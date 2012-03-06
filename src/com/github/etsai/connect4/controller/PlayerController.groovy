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
    public void move(Environment env) {
        Connect4Core coreInstance= Connect4Core.getInstance()
        
        coreInstance.isAIController= false;
        coreInstance.hasMoved= false;
        
        while(!coreInstance.hasMoved);
    }
}

