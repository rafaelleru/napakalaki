/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

/**
 *
 * @author archdrif
 */
public class Player {
    
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    protected Player enemy;
    protected ArrayList<Treasure> nVisibleTreasures  = new ArrayList<>();
    protected ArrayList<Treasure> nHiddenTreasures = new ArrayList<>();
    private BadConsequence pendingBadConsequence;
    
    public Player(String n){
        name = n;
        level = 1;
        dead = false;
        canISteal = false;
        this.pendingBadConsequence = new DeathBadConsequence("0", false);
    }
    
    public Player(Player p){
        this.name = p.name;
        this.level = p.level;
        this.dead  = p.dead;
        this.enemy = p.enemy;
        this.canISteal = p.canISteal;
        this.nHiddenTreasures = p.nHiddenTreasures;
        this.nVisibleTreasures = p.nVisibleTreasures;
        this.pendingBadConsequence = p.pendingBadConsequence;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
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
            this.level = 1;
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
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        this.incrementLevels(nLevels);
        
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures > 0){
            CardDealer cd = CardDealer.getInstance();
            for(int i=0; i < nTreasures; ++i){
                Treasure t = cd.nextTreasure();
                System.out.println(t.getName());
                this.nHiddenTreasures.add(t);
            }
        }
    }
    private void applyBadConsequence(Monster m){
        BadConsequence badconsequence = m.getBc();
        int nLevels = m.getCombatLevel();
      
        if(badconsequence.isDeath()){
            this.dead = badconsequence.isDeath();
            System.out.println("Estas muerto");
        }else{
            this.decrementLevels(nLevels);
            this.pendingBadConsequence = this.pendingBadConsequence.adjustToFitTreasureLists(
                    this.nVisibleTreasures, this.nHiddenTreasures);
            this.setPendingBadConsequence(this.pendingBadConsequence);
        }
    }
    private boolean canMakeTreasureVisible(Treasure t){
        boolean result = false;
        
        if(this.nVisibleTreasures.size() < 4){
            TreasureKind type = t.getType();
            switch(type){
                case ONEHAND:
                    if(true){//isTreasureKindInUse(TreasureKind.BOTHHANDS)){
                        result = false;
                    }else{
                        int i = 0;
                        
                        for(Treasure tv : this.nVisibleTreasures){
                            if(tv.getType().equals(TreasureKind.ONEHAND)){
                                i++;
                            }
                        }
                        
                        if(i == 2){
                            result = false;
                        }else{
                            result = true;
                        }
                    }
                    break;
                    
                default:
                    //result = !isTreasureKindInUse(type);
                    break;
            }
        }
        return result;
    }
    
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
    private void dieIfNoTreasures(){
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
    
    public CombatResult combat(Monster m){
        int monsterLevel = this.getOponentLevel(m);
        
        if(this.canISteal() == false){
            Dice d = Dice.getInstance();
            int n = d.nextNumber();
        
            if(n < 3){
                int enemyLevel = this.enemy.getCombatLevels();
                monsterLevel += enemyLevel;
            }
        }

        if(this.getCombatLevels() >= monsterLevel){
            this.applyPrize(m);
            if(this.getCombatLevels() >= MAXLEVEL){
                return CombatResult.WINGAME;
            }else{
                return CombatResult.WIN;
            }
        }else{
            this.applyBadConsequence(m);
            if(shouldConvert())
                return CombatResult.LOSEANDCONVERT;
            else
                return CombatResult.LOSE;
        }
    }
    
    public void makeTreasureVisible(Treasure t){
        if(this.canMakeTreasureVisible(t)){
            this.nVisibleTreasures.add(t);
            this.nHiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        this.nVisibleTreasures.remove(t);
        
        if((this.pendingBadConsequence != null) && (this.pendingBadConsequence.isEmpty()
                == false)){
            this.pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        this.dieIfNoTreasures();
        
        CardDealer cd = CardDealer.getInstance();
        cd.giveTreasureBack(t);
    
    }
    public void discardHiddenTreasure(Treasure t){
        this.nHiddenTreasures.remove(t);
        
        if((this.pendingBadConsequence != null) && (this.pendingBadConsequence.isEmpty()
                == false)){
            this.pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        this.dieIfNoTreasures();
        
        CardDealer cd = CardDealer.getInstance();
        cd.giveTreasureBack(t);
    }
    
    /**
     * @brief devuelve si el jugador es pato para jugar su turno
     * @return true si el jugador cumple las condiciones para usar su turno
     *         false en otro caso
     */
    public boolean validState(){
        if(this.pendingBadConsequence != null && this.pendingBadConsequence.isEmpty() && 
                this.nHiddenTreasures.size() < 4)
            return true;
        else return false;
    }
    public void initTreasures(){
        CardDealer cd = CardDealer.getInstance();
        Dice d = Dice.getInstance();
        
        this.bringToLife();
        
        Treasure t = cd.nextTreasure();
        this.nHiddenTreasures.add(t);
        
        int n = 3;//d.nextNumber();
        
        if(n > 1){
            System.out.println("n>1");
            t = cd.nextTreasure();
            this.nHiddenTreasures.add(t);
        }
        
        if(n >= 6){
            System.out.println("n=6");
            t = cd.nextTreasure();
            this.nHiddenTreasures.add(t);
        }
    }
    
    /**
     * @brief devuelve el nivel de combate del jugador
     * @return total_level que es la suma de el nivel del player y los bonus de
     * tesoros
     */
    protected int getCombatLevels(){
        int total_level = this.level;
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
    
    public Treasure stealTreasure(){
        if(this.canISteal()){
            if(this.enemy.canYouGiveMeATreasure()){
                Treasure t = this.enemy.giveMeATreasure();
                this.nHiddenTreasures.add(t);
                this.haveStolen();
                return t;
            }
        }
        
        return null;
    }
    
    /**
     * *@brief asigna el enemigo de player
     * @param enemy el jugador que sera enemigo
     */
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure(){
        Treasure result;
        Random ale = new Random();
        int n = ale.nextInt(this.nHiddenTreasures.size());
        result = this.nHiddenTreasures.get(n);
        return result;
    }
    
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
    protected boolean canYouGiveMeATreasure(){
        return (this.nVisibleTreasures.size() > 0);
    }
    
    /**
     * @brief cambia el atributo canIsteal a false si el jugador roba
     */
    private void haveStolen(){
        this.canISteal = false;
    }  
    public void discardAllTreasure(){
        for(Treasure t: this.nVisibleTreasures)
            this.discardVisibleTreasure(t);
        
        for(Treasure t: this.nHiddenTreasures)
            this.discardHiddenTreasure(t);
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert() {
        Dice d = Dice.getInstance();
        int n = d.nextNumber();
        
        if(n == 6)
            return true;
        else return false;
    }
    
    protected Player getEnemy(){
        return this.enemy;
    }
    
}
