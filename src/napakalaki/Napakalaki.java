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
    private ArrayList<Player> players = new ArrayList<Player>();
    private CardDealer dealer = CardDealer.getInstance();
    private Monster currentMonster;
    
    
    private Napakalaki(){}
    
    public static Napakalaki getInstance(){
        if (instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }
    
    private void initPlayers(ArrayList<String> names){
       for(String n : names){
           Player aux = new Player(n);
           //aux.initTreasures();
           this.players.add(aux);                   
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
        for(int i=0; i < this.players.size(); ++i){
            Random seed = new Random();
            int n=0;
            while(n == i)
                n = seed.nextInt(this.players.size());
            
            this.players.get(i).setEnemy(this.players.get(n));
        }
    }
    
    
    public CombatResult developCombat(){
        this.dealer.giveMonsterBack(this.currentMonster);
        CombatResult result = this.currentPlayer.combat(this.currentMonster);
        if( result == CombatResult.LOSEANDCONVERT){
            Cultist c = this.dealer.nextCultist();
            CultistPlayer newCultist = new CultistPlayer(this.currentPlayer, c);
            
            int indexOfCurrentPlayer = this.players.indexOf(currentPlayer);
            this.players.remove(this.currentPlayer);
            this.players.add(indexOfCurrentPlayer, newCultist);
            
            for(Player p: players){
                if(p.getEnemy() == currentPlayer && p != currentPlayer){
                    p.setEnemy(newCultist);
                }
            }
        }
        return result;
    }
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){
            this.currentPlayer.discardVisibleTreasure(t);
        }
    }
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){}
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){
            this.currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        this.setEnemies();
        this.dealer.initCards();
        this.nextTurn();
    }
    public boolean nextTurn(){
        boolean stateOk = this.nextTurnAllowed();
        if(stateOk){
            this.currentMonster = this.dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            
            if(this.currentPlayer.isDead()){
                this.currentPlayer.initTreasures();
            }
        }
        
        return stateOk;
    }
    
    
}
