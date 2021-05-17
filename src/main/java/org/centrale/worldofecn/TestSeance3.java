/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import java.util.ArrayList;

/**
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class TestSeance3 {
    

    public static void main(String[] args){
        
        World w = new World();
        w.creeMondeAlea();
        System.out.println();
        System.out.println("Nombre de personnages : " + w.getPersonnages().size());
        System.out.println("Types et adressses des personnages :");
        for (Personnage p : w.getPersonnages()){
            System.out.println(p);
        }
        System.out.println();
        System.out.println("Nombre de monstres : " + w.getMonstres().size());
        System.out.println("Types et adressses des monstres :");
        for (Monstre m : w.getMonstres()){
            System.out.println(m);
        }
        
        //version itérative avec le nombre d'éléments
        long debutN = System.nanoTime();
        System.out.println();
        System.out.println();

        System.out.println("Nombre de personnages : " + w.getPersonnages().size());
        System.out.println("Types et adressses des personnages :");
        for (int i=0; i<w.getPersonnages().size(); i++){
            System.out.println(w.getPersonnages().get(i));
        }
        long finN = System.nanoTime();
        System.out.println("Temps écoulé en ns : " + (finN - debutN));
        
        
    }
}