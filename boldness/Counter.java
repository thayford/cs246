/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boldness;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim
 */
public class Counter implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("Counter: " + i);
            try {
                this.wait(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
