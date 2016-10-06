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
}
