/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author rafa
 */
public class Prize {
    private int treasures;
    private int level;
    
    /**
     * 
     * @param t treasures
     * @param l level
     */
    public Prize(int t, int l){
        treasures = t;
        level = l;
    }
    
    /**
     * 
     * @return treasures value
     */
    public int getTreasures() {
        return treasures;
    }

    /**
     * 
     * @return level value
     */
    public int getLevel() {
        return level;
    }
}
