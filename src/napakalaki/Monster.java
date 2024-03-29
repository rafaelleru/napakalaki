/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author archdri
 */
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize prize;
    private int levelChangeAgainstCultistPlayer = 0;
   
    /**
     * 
     * @param name_ nombre del monstruo
     * @param combatLevel_ nivel
     * @param bc_ mal rollo
     * @param prize_ prize
     */
    public Monster(String name_, int combatLevel_, BadConsequence bc_, Prize prize_){
        name=name_;
        combatLevel=combatLevel_;
        bc=bc_;
        prize=prize_;
    }
    
    /**
     * 
     * @param n nombre del monstruo
     * @param l nivel
     * @param badConsequence mal rollo
     * @param p prize
     * @param lC levelChange
     */
    public Monster(String n, int l, BadConsequence badConsequence, Prize p, int lC){
        name=n;
        combatLevel=l;
        bc=badConsequence;
        prize=p;
        levelChangeAgainstCultistPlayer=lC;
    }
    
    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public BadConsequence getBc() {
        return bc;
    }

    public Prize getPrize() {
        return prize;
    }
    
    public int getCombatLevelAgainstCultistPlayer() {
        return this.combatLevel + this.levelChangeAgainstCultistPlayer;
    }
    
    @Override
    public String toString(){
        return name + " Niveles: " + Integer.toString(combatLevel) + " " + bc.toString() + " " + prize.toString();
    }
    
    public int getLevelsGained(){
        return this.bc.getLevels();
    }
    
    public int getTreasuresGained(){
         return this.prize.getTreasures();
    }
}
