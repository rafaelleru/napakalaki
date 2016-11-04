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
public class CardDealer {
    
    private static CardDealer instance = null;
    
    private CardDealer(){}
    private void initTreasuresCardDeck(){}
    private void initMonsterCardDeck(){}
    private void shuffleTreasures(){}
    private void shuffleMonsters(){}
    public static CardDealer getInstance(){}
    public Treasure nextTreasure(){}
    public Monster nextMonster(){}
    public void giveTreasureBack(Treasure t){}
    public void giveMonsterBack(Monster m){}
    public void initCards(){}
    
}
