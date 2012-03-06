/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.etsai.connect4;

import java.util.ArrayList;

/**
 *
 * @author etsai
 */
public class Connect4Core {
    private static Connect4Core instance;
    public ArrayList<Controller> controllerList= new ArrayList<>();
    public boolean textMode;
    
    public static Connect4Core getInstance() {
        if (instance == null) {
            instance= new Connect4Core();
        }
        return instance;
    }
}
