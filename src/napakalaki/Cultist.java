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
public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String s, int l){
        this.name = s;
        this.gainedLevels = l;
    }
    
    public int getLEvelsGained(){
        return this.gainedLevels;
    }
}
