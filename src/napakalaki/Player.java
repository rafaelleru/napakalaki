/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

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
    private Player enemy;
    private ArrayList<Treasure> nVisibleTreasures;
    private ArrayList<Treasure> nHiddenTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String n){
        name = n;
        level = 0;
        dead = false;
        canISteal = false;
    }
    
    public String getName(){
        return name;
    }
    
    /**
     * @brief devuelve el jugador a la vida
     */
    private void bringToLife(){
        this.dead = true;
    }
    
    /**
     * @brief aumenta el nivel de combate de player
     * @param l el numero de niveles a aumentar.
     */
    private void incrementLevels(int l){
        if(this.level + l > 10)
            this.level = 10;
        else 
            this.level+=l;
    }
    
    /**
     * @brief resta niveles al jugador
     * @param l los nieveles a reducir
     */
    private void decrementLevels(int l){
        if(this.level - l < 0)
            this.level = 0;
        else
            this.level -= l;
    }
    
    /**
     * @brief asigna el badconsequence del player
     * @param b es el badconsequence asignado
     */
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    //private void applyPrize(Monster m){}
    //private void applyBadConsequence(Monster m){}
    //private boolean canMakeTreasureVisible(Treasure t){}
    
    /**
     * @brief indica el nuemro de tesoros de un tipo
     * @param tKind el tipo del que se quiere conocer el numero de tesoros
     * @return el numero de tesoros del player.
     */
    private int howManyVisibleTreasures(TreasureKind tKind){
        int cont = 0;
        for(Treasure t: nVisibleTreasures){
            if(t.getType() == tKind)
                cont++;
        }
        
        return cont;
    }
    
    /**
     * @brief si el jugador no tiene tesoros hace dead true
     */
    private void dielfNoTreasures(){
        if(this.nHiddenTreasures.size() == 0 && this.nVisibleTreasures.size() == 0)
            this.dead = true;
    }
    
    /**
     * @brief devuelve el estado del jugador
     * @return True si el jugador esta muerto
     *         False en otro caso.
     */
    public boolean isDead(){
        return dead;
    }
    
    /**
     * @brief devuelve los tesoros ocultos del jugador
     * @return el array de tesoros ocyultos
    */
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
     /**
     * @brief devuelve los tesoros visibles del jugador
     * @return el array de tesoros visibles
    */
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    //public CombatResult combat(Monster m){}
    //public void makeTreasureVisible(Treasure t){}
    //public void discardVisibleTreasure(Treasure t){}
    //public void discardHiddenTreasure(Treasure t){}
    
    /**
     * @brief devuelve si el jugador es pato para jugar su turno
     * @return true si el jugador cumple las condiciones para usar su turno
     *         false en otro caso
     */
    public boolean validState(){
        if(this.pendingBadConsequence.isEmpty() && 
                this.nHiddenTreasures.size() < 4)
            return true;
        else return false;
    }
    public void initTreasures(){}
    
    /**
     * @brief devuelve el nivel de combate del jugador
     * @return total_level que es la suma de el nivel del player y los bonus de
     * tesoros
     */
    public int getCombatLevels(){
        int total_level = level;
        for(Treasure t: nHiddenTreasures){
            total_level += t.getBonus();
        }
        
        for(Treasure t: nVisibleTreasures){
            total_level += t.getBonus();
        }
        return total_level;
    }
    
    /**
     * @brief nivel del jugador
     * @return nivel del jugador
     */
    public int getLevel(){
        return this.level;
    }
    
    //public Treasure stealTreasure(){}
    
    /**
     * *@brief asigna el enemigo de player
     * @param enemy el jugador que sera enemigo
     */
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    //private Treasure giveMeATreasure(){}
    
    /**
     * @brief indica si el jugador puede robar, lo cual indica si lo hizo en la 
     * ultima ronda o no.
     * @return True si el jugador puede robar un tesoro.
     *         False en otro caso.
     */
    public boolean canISteal(){
        return canISteal;
    }  
    
    /**
     * @brief indica si el jugador tiene tesoros para ser robados
     * @return true si nVisibleTReasures tiene algun elemento
     *         false en otro caso
     */
    private boolean canYouGiveMeATreasure(){
        return (this.nVisibleTreasures.size() > 0);
    }
    
    /**
     * @brief cambia el atributo canIsteal a false si el jugador roba
     */
    private void haveStolen(){
        this.canISteal = false;
    }  
    //public void discardAllTreasure(){}
    
}
