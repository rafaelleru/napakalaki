/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author rafa
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayer = 0;
    private Cultist myCultistCard;
    public CultistPlayer(Player p, Cultist c) {
        super(p.getName());
        totalCultistPlayer++;
        this.myCultistCard = c;
    }
    
    @Override
    protected int getCombatLevels(){
        return (int) (super.getCombatLevels() + super.getCombatLevels()*0.7 + (this.myCultistCard.getLEvelsGained()* CultistPlayer.totalCultistPlayer));
    }
    
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    
    private Treasure giveMeATreasure(){
        Random r = new Random();
        int n = r.nextInt(super.enemy.getVisibleTreasures().size()) + 1;
        Treasure t = this.nVisibleTreasures.get(n);
        this.nVisibleTreasures.remove(t);
        return t;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return super.enemy.getVisibleTreasures().size() > 0;
    }
    
    public int getTotalCultistPlayers(){
        return totalCultistPlayer;
    }
    
    
    
}
