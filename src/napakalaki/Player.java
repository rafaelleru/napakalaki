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
public class Player {
    
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    public Player(String n){
        name = n;
        level = 0;
        dead = false;
        canISteal = false;
    }
    
    public String getName(){
        return name;
    }
    private void bringToLife(){}
    private void incrementLevels(int l){}
    private void decrementLevels(int l){}
    private void setPendingBadConsequence(BadConsequence b){}
    private void applyPrize(Monster m){}
    private void applyBadConsequence(Monster m){}
    private boolean canMakeTreasureVisible(Treasure t){}
    private int howManyVisibleTreasures(TreasureKind tKind){}
    private void dielfNoTreasures(){}
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){}
    public ArrayList<Treasure> getVisibleTreasures(){}
    public CombatResult combat(Monster m){}
    public void makeTreasureVisible(Treasure t){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
    public boolean validState(){}
    public void initTreasures(){}
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){}
    public void setEnemy(Player enemy){}
    private Treasure giveMeATreasure(){}
    public boolean canISteal(){
        return canISteal;
    }  
    
    private boolean canYouGiveMeATreasure(){}
    private void haveStolen(){}
    public void discardAllTreasure(){}
    
}
