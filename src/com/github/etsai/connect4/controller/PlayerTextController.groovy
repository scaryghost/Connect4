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
class PlayerTextController {
    public synchronized void move() {
        def coreInstance= Connect4Core.getInstance()
        print "Enter column to drop checker [0-6]: "
        def br = new BufferedReader(new InputStreamReader(System.in));
        def column = null;
        def validInput= false
        
        while(!validInput) {
            try {
                column= Integer.valueOf(br.readLine())
                validInput= true
            } catch (IOException e) {
                println("Error reading input!");
                System.exit(1);
            } catch (NumberFormatException e) {
                println("Not a valid number you dingbat")
            }
        }
        
        if (GameType.getInstance().getCurrentPlayer() == 0) {
            coreInstance.env.addChecker(column,Environment.CHECKER_BLACK)
        } else {
            coreInstance.env.addChecker(column,Environment.CHECKER_RED)
        }
    }
}

