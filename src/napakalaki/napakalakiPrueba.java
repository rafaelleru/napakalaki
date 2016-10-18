/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rafa
 */
public class napakalakiPrueba {
    private static ArrayList<Monster> monstruos = new ArrayList<>();
    
    /**
     * 
     * @return monstruos con nivel mayor que 10 
     */
    public static ArrayList<Monster> getMonsterLevel10(){
        ArrayList <Monster> sol = new ArrayList<>();
        for(Monster m : monstruos){
            if(m.getCombatLevel() > 10)
                sol.add(m);
        }
        
        return sol;
    }
    
    public static ArrayList<Monster> getMonsterOnlyLoseLevels(){
        ArrayList <Monster> sol = new ArrayList<>();
        for(Monster m : monstruos){
            if(m.getBc().getnHiddenTreasures() == 0 && m.getBc().getnVisibleTreasures() == 0
                    && !m.getBc().isDeath())
                sol.add(m);
        }
        
        return sol;
    }
    
    public static ArrayList<Monster> getMonsterWinLevels(){
        ArrayList <Monster> sol = new ArrayList<>();
        for(Monster m : monstruos){
            if(!(m.getPrize().getLevel() => 2)) 
                sol.add(m);
            }
        }
        
        return sol;
    }
    
    public static ArrayList<Monster> getMonsterLoseTreasures(TreasureKind tipo){
        ArrayList <Monster> sol = new ArraList();
        for(Monster m : monstruos){
            if(m.getBc().getSpecificHiddenTreasures(tipo) => 1 || 
                    m.getBc().getSpecificVisibleTreasures(tipo) => 1)
                sol.add(m);
        }
        
        return sol;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
         * Creando los monstros
         */

        BadConsequence badConsequence0 = new BadConsequence("Pierdes tu armadura visible."
                + "y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize0 = new Prize(2,1);
        monstruos.add(new Monster("Byakhees de bonanza",8,badConsequence0,prize0));
        
        BadConsequence badConsequence1 = new BadConsequence("Embobados con el lindo "
                + "primigenio te descartas de tu casco visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList(Arrays.asList()));
        Prize prize1 = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan",2,badConsequence1,prize1));
        
        BadConsequence badConsequence2 = new BadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                new ArrayList(Arrays.asList()));
        Prize prize2 = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich",2,badConsequence2,prize2));
        
        BadConsequence badConsequence3 = new BadConsequence("Te atrapan para llevarte de fiesta y "
                + "te dejan caer en mitad de vuelo. Descarta 1 mano visible y 1 mano oculta.",0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize3 = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf",2,badConsequence3,prize3));
        
        BadConsequence badConsequence4 = new BadConsequence("Pierdes todos tus tesoros visibles.",
                0,Integer.MAX_VALUE,0);
        Prize prize4 = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral",13,badConsequence4,prize4));
        
        BadConsequence badConsequence5 = new BadConsequence("Pierdes la armadura visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.SHOES)));
        Prize prize5 = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft",6,badConsequence5,prize5));
        
        BadConsequence badConsequence6 = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(1,1);
        monstruos.add(new Monster("Necrófago",13,badConsequence6,prize6));
        
        BadConsequence badConsequence7 = new BadConsequence("Pierdes 5 niveles y "
                + "3 tesoros visibles.",5,3,0);
        Prize prize7 = new Prize(3,2);
        monstruos.add(new Monster("El rey rosado",11,badConsequence7,prize7));
        
        BadConsequence badConsequence8 = new BadConsequence("Toses los pulmones y"
                + " pierdes 2 niveles.",2,0,0);
        Prize prize8 = new Prize(1,1);
        monstruos.add(new Monster("Flecher",2,badConsequence8,prize8));
        
        BadConsequence badConsequence9 = new BadConsequence("Estos monstruos resultan "
                + "bastante superficiales y te aburren mortalmente. Estas muerto.",true);
        Prize prize9 = new Prize(2,1);
        monstruos.add(new Monster("Los hondos",8,badConsequence9,prize9));
        
        BadConsequence badConsequence10 = new BadConsequence("Pierdes 2 niveles "
                + "y 2 tesoros ocultos.",2,0,2);
        Prize prize10 = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu",4,badConsequence10,prize10));
        
        BadConsequence badConsequence11 = new BadConsequence("Te intentas escapar. "
                + "Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize11 = new Prize(2,1);
        monstruos.add(new Monster("Dameargo",1,badConsequence11,prize11));
        
        BadConsequence badConsequence12 = new BadConsequence("Da mucho asquito. "
                + "Pierdes 3 niveles.",3,0,0);
        Prize prize12 = new Prize(2,1);
        monstruos.add(new Monster("Pollipólipo volante",3,badConsequence12,prize12));
        
        BadConsequence badConsequence13 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. "
                + "Estaś muerto.",true);
        Prize prize13 = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth",14,badConsequence13,prize13));
        
        BadConsequence badConsequence14 = new BadConsequence("La familia te atrapa. Estás muerto.",true);
        Prize prize14 = new Prize(3,1);
        monstruos.add(new Monster("Familia feliz",3,badConsequence14,prize14));
        
        BadConsequence badConsequence15 = new BadConsequence("La quinta directiva primaria te obliga a "
                + "perder 2 niveles y de tesoro 2 manos visible.",2,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize15 = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth",8,badConsequence15,prize15));
        
        BadConsequence badConsequence16 = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible.",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo",5,badConsequence16,prize16));
        
        BadConsequence badConsequence17 = new BadConsequence("Menudo susto te llevas. "
                + "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        Prize prize17 = new Prize(2,1);
        monstruos.add(new Monster("Tongue",19,badConsequence17,prize17));
        
        BadConsequence badConsequence18 = new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND))
                ,new ArrayList(Arrays.asList()));
        Prize prize18 = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo",21,badConsequence18,prize18));
    }
    
}
