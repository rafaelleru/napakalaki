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
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList<>();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList<>();
    
    /**
     * 
     * @param t texto 
     * @param l levels
     * @param nV nVisibleTreasures
     * @param nH  nHiddenTreasures
     */
    public BadConsequence(String t, int l, int nV, int nH){
        text = t;
        levels = l;
        nVisibleTreasures = nV;
        nHiddenTreasures = nH;
    }
    
    /**
     * 
     * @param t texto
     * @param d valor que define si hay muerte o no
     */
    public BadConsequence(String t, boolean d){
        text = t;
        death = d;
    }
    
    /**
     * 
     * @param text texto
     * @param levels niveles
     * @param tVisible array de tipos de los tesoros visibles
     * @param tHidden array de tipos de los tesoros ocultos, 
     */
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        text = text;
        levels = levels;
        specificHiddenTreasures = tHidden;
        specificVisibleTreasures = tVisible;
    }
    
    public String toString(){
        return text + " decrementa: " + Integer.toString(levels);
    }

    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    
}
