/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import GUI.*;
import java.util.ArrayList;
/**
 *
 * @author archdri
 */
public class NapakalakiGame {
    public static void main(String[] args){
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        game.initGame(names);
        
        
        Dice.createInstance(napakalakiView);
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible(true);
        
    }
}
