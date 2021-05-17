/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 *
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Il y a 20 tours de jeu");
        World w = new World();
        w.creeMondeAlea();
        for (int i=0; i<20; i++){
            w.TourDeJeu();
        }
    }
}
