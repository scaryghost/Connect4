/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etsai.connect4;

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
        Connect4Core.getInstance();
        GameType.init(args);
        GameType.getInstance().begin();
    }
}
