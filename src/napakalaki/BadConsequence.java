/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public abstract class BadConsequence {
    public static final int MAXTREASURES = 10;
    
    protected String text;
    protected int levels=0;

    public BadConsequence(String text,int levels) {
        this.text = text;
        this.levels = levels;
    }
    
    public abstract boolean isEmpty();
    
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract boolean isDeath();
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure>v, ArrayList<Treasure> h);
}
