/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author archdri
 */
public class Dice {
    
    private static Dice instance = null;
    private Random r = new Random();

    private Dice(){}
    public static Dice getInstance(){
        return instance;
    }
    public int nextNumber(){
        return r.nextInt(6) + 1;
        
    }
    
}
