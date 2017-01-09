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
    static final int MAXTREASURES = 10;
    
    
    /**
     * @brief Construye un mal rollo con los parametros dados
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
     * @brief Construye un mal rollo definiendo si estas muerto o no
     * @param t texto
     * @param d valor que define si hay muerte o no
     */
    public BadConsequence(String t, boolean d){
        text = t;
        death = d;
    }
    
    /**
     * @brief Construye un mal rollo con los parametros dados y tesoros visibles y ocultos
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
    
    /**
     * @brief Devuelve un texto con los niveles que decrementa
     * @return Texto que dice los niveles disminuidos
     */
    public String toString(){
        return text + " decrementa: " + Integer.toString(levels);
    }
    
    /**
     * @brief Devuelve descripcion del monstruo
     * @return Texto con la descripcion del monstruo
     */
    public String getText() {
        return text;
    }
    
    /**
     * @brief Devuelve el numero de nivel del monstruo
     * @return Nivel del monstruo
     */
    public int getLevels() {
        return levels;
    }
    
    /**
     * @brief Devuelve numero de tesoros visibles
     * @return Cuantos tesoros visibles quita
     */
    public int getnVisibleTreasures() {
        if(this.nVisibleTreasures == 0)
            return this.specificVisibleTreasures.size();
        else return this.nVisibleTreasures;
    }
    
    /**
     * @brief Devuelve numero de tesoros ocultos
     * @return Cuantos tesoros ocultos quita
     */
    public int getnHiddenTreasures() {
        if(this.nHiddenTreasures == 0)
            return this.specificHiddenTreasures.size();
        else return this.nHiddenTreasures;
    }
    
    /**
     * @brief Devuelve si esta muerto o no
     * @return Booleana que dice si estas muerto o no
     */
    public boolean isDeath() {
        return death;
    }
    
    /**
     * @brief Devuelve lista con los tesoros visibles especificos
     * @return ArrayList con los tesoros visibles especificos que quita
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    /**
     * @brief Devuelve lista con los tesoros ocultos especificos
     * @return ArrayList con los tesoros ocultos especificos que quita
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public boolean isEmpty(){
        if( nVisibleTreasures == 0 && nHiddenTreasures == 0 && 
            specificVisibleTreasures.size() == 0 && specificHiddenTreasures.size() == 0)
            return true;
        else
            return false;
    }
    
    /**
     * @brief Elimina tesoro visile
     * @param t Tesoro visible que va a sustraer
     */
    public void substractVisibleTreasure( Treasure t ){
        if(this.specificVisibleTreasures.contains(t))
            this.specificVisibleTreasures.remove(t);
        if(this.nVisibleTreasures > 0)
            this.nVisibleTreasures--;
    }
    
    /**
     * @brief Elimina un tesoro oculto
     * @param t Tesoro oculto que se desea sustraer
     */
    public void substractHiddenTreasure( Treasure t ){
        if(this.specificHiddenTreasures.contains(t))
            this.specificHiddenTreasures.remove(t); 
        if(this.nHiddenTreasures > 0)
            this.nHiddenTreasures--;
    }
    
    /**
     * @brief No se que hace ahora mismo xd
     * @param v Lista de tesoros
     * @param h lista de tesoros
     * @return Un objeto de la clase BadConsequence
     */
    public BadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence aux = new BadConsequence("adjust", false);
        
        for(Treasure t: v){
            if(this.specificVisibleTreasures.contains(t))
                aux.specificVisibleTreasures.add(t.getType());
        }
        
        for(Treasure t: h){
            if(this.specificHiddenTreasures.contains(t))
                aux.specificHiddenTreasures.add(t.getType());
        }
        
        return aux;
    }
}
