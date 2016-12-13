/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author archdri
 */
public class CardDealer {
    
    private static CardDealer instance = null;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures = new ArrayList<Treasure>();
    private ArrayList<Monster> unusedMonster;
    private ArrayList<Monster> usedMonster = new ArrayList<Monster>();
    
    private CardDealer(){}
    
    private void initTreasuresCardDeck(){
    
        //inicializamos los dos ArrayLists
        unusedTreasures = new ArrayList<>();
        usedTreasures = new ArrayList<>(); 

        //El constructor de Treasure pide: nombre, bonus y type

        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato Mistico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycon", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentácula de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
        
    }
    
    private void initMonsterCardDeck(){
    
        unusedMonster = new ArrayList<Monster>();
        BadConsequence badConsequence0 = new BadConsequence("Pierdes tu armadura visible."
                + "y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize0 = new Prize(2,1);
        unusedMonster.add(new Monster("Byakhees de bonanza",8,badConsequence0,prize0));
        
        BadConsequence badConsequence1 = new BadConsequence("Embobados con el lindo "
                + "primigenio te descartas de tu casco visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList(Arrays.asList()));
        Prize prize1 = new Prize(1,1);
        unusedMonster.add(new Monster("Tenochtitlan",2,badConsequence1,prize1));
        
        BadConsequence badConsequence2 = new BadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                new ArrayList(Arrays.asList()));
        Prize prize2 = new Prize(1,1);
        unusedMonster.add(new Monster("El sopor de Dunwich",2,badConsequence2,prize2));
        
        BadConsequence badConsequence3 = new BadConsequence("Te atrapan para llevarte de fiesta y "
                + "te dejan caer en mitad de vuelo. Descarta 1 mano visible y 1 mano oculta.",0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize3 = new Prize(4,1);
        unusedMonster.add(new Monster("Demonios de Magaluf",2,badConsequence3,prize3));
        
        BadConsequence badConsequence4 = new BadConsequence("Pierdes todos tus tesoros visibles.",
                0,Integer.MAX_VALUE,0);
        Prize prize4 = new Prize(3,1);
        unusedMonster.add(new Monster("El gorrón en el umbral",13,badConsequence4,prize4));
        
        BadConsequence badConsequence5 = new BadConsequence("Pierdes la armadura visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.SHOES)));
        Prize prize5 = new Prize(2,1);
        unusedMonster.add(new Monster("H.P. Munchcraft",6,badConsequence5,prize5));
        
        BadConsequence badConsequence6 = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(1,1);
        unusedMonster.add(new Monster("Necrófago",13,badConsequence6,prize6));
        
        BadConsequence badConsequence7 = new BadConsequence("Pierdes 5 niveles y "
                + "3 tesoros visibles.",5,3,0);
        Prize prize7 = new Prize(3,2);
        unusedMonster.add(new Monster("El rey rosado",11,badConsequence7,prize7));
        
        BadConsequence badConsequence8 = new BadConsequence("Toses los pulmones y"
                + " pierdes 2 niveles.",2,0,0);
        Prize prize8 = new Prize(1,1);
        unusedMonster.add(new Monster("Flecher",2,badConsequence8,prize8));
        
        BadConsequence badConsequence9 = new BadConsequence("Estos unusedMonster resultan "
                + "bastante superficiales y te aburren mortalmente. Estas muerto.",true);
        Prize prize9 = new Prize(2,1);
        unusedMonster.add(new Monster("Los hondos",8,badConsequence9,prize9));
        
        BadConsequence badConsequence10 = new BadConsequence("Pierdes 2 niveles "
                + "y 2 tesoros ocultos.",2,0,2);
        Prize prize10 = new Prize(2,1);
        unusedMonster.add(new Monster("Semillas Cthulhu",4,badConsequence10,prize10));
        
        BadConsequence badConsequence11 = new BadConsequence("Te intentas escapar. "
                + "Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize11 = new Prize(2,1);
        unusedMonster.add(new Monster("Dameargo",1,badConsequence11,prize11));
        
        BadConsequence badConsequence12 = new BadConsequence("Da mucho asquito. "
                + "Pierdes 3 niveles.",3,0,0);
        Prize prize12 = new Prize(2,1);
        unusedMonster.add(new Monster("Pollipólipo volante",3,badConsequence12,prize12));
        
        BadConsequence badConsequence13 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. "
                + "Estaś muerto.",true);
        Prize prize13 = new Prize(3,1);
        unusedMonster.add(new Monster("Yskhtihyssg-Goth",14,badConsequence13,prize13));
        
        BadConsequence badConsequence14 = new BadConsequence("La familia te atrapa. Estás muerto.",true);
        Prize prize14 = new Prize(3,1);
        unusedMonster.add(new Monster("Familia feliz",3,badConsequence14,prize14));
        
        BadConsequence badConsequence15 = new BadConsequence("La quinta directiva primaria te obliga a "
                + "perder 2 niveles y de tesoro 2 manos visible.",2,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize15 = new Prize(2,1);
        unusedMonster.add(new Monster("Roboggoth",8,badConsequence15,prize15));
        
        BadConsequence badConsequence16 = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible.",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(1,1);
        unusedMonster.add(new Monster("El espía sordo",5,badConsequence16,prize16));
        
        BadConsequence badConsequence17 = new BadConsequence("Menudo susto te llevas. "
                + "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        Prize prize17 = new Prize(2,1);
        unusedMonster.add(new Monster("Tongue",19,badConsequence17,prize17));
        
        BadConsequence badConsequence18 = new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND))
                ,new ArrayList(Arrays.asList()));
        Prize prize18 = new Prize(2,1);
        unusedMonster.add(new Monster("Bicéfalo",21,badConsequence18,prize18));
        
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(this.unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(this.unusedMonster);
    }
    
    public static CardDealer getInstance(){
        if (instance == null) {
            instance = new CardDealer();
        }
        return instance;
    }
    
    public Treasure nextTreasure(){
       Treasure t;
       t = this.unusedTreasures.get(this.unusedTreasures.size());
       this.unusedMonster.remove(t);
       return t;
    }
    public Monster nextMonster(){
        return this.unusedMonster.get(0);
    }
    public void giveTreasureBack(Treasure t){
        this.usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        this.usedMonster.add(m);
    }
    public void initCards(){
        System.out.println("debug");
        this.initTreasuresCardDeck();
        this.initMonsterCardDeck();
    }
    
}
