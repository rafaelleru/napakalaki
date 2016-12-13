/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author archdri
 */
public class Napakalaki {
    
    private static Napakalaki instance = null;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    
    private Napakalaki(){}
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    private void initPlayers(ArrayList<String> names){
       players = new ArrayList<>();
       for(String n : names){
           players.add(new Player(n));
       }
     }
    
    private Player nextPlayer(){
        int index;
        Player nextPlayer;
        int totalPlayers = this.players.size();
        
        if(this.currentPlayer == null){
            Random ale = new Random();
            index = ale.nextInt(totalPlayers);
        }else{
            int currentPlayerIndex = this.players.indexOf(this.currentPlayer);
            if(currentPlayerIndex == totalPlayers - 1)
                index = 0;
            else
                index = currentPlayerIndex + 1;
        }
        
        nextPlayer = this.players.get(index);
        this.currentPlayer = nextPlayer;
        
        return this.currentPlayer;
        
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }
    
    private boolean nextTurnAllowed(){
        boolean allowed;
        
        if(this.currentPlayer == null){
            allowed = true;
        }else{
            allowed = this.currentPlayer.validState();
        }
        
        return allowed;
    }
    
    public boolean endOfGame(CombatResult result){
        boolean resultado;
        
        if(result == CombatResult.WINGAME)
            resultado = true;
        else
            resultado = false;
            
        return resultado;
    }
    
    private void setEnemies(){
        //hacer
    }
    
    
    public CombatResult developCombat(){
        this.dealer.giveMonsterBack(this.currentMonster);
        return this.currentPlayer.combat(this.currentMonster);
        
    }
    /*public void discardVisibleTreasures(ArrayList<Treasure> treasures){}
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){}
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){}
    public void initGame(ArrayList<String> players){}
    public boolean nextTurn(){}*/
    
    
}
