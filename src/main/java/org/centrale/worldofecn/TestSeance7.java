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
public class TestSeance7 {
    public static void main(String[] args){
        
        World w = new World();
        w.creeMondeAlea();
        
        System.out.println("TEST");
        SauvegardePartie.sauvegardePartie(w);
        System.out.println(w.getOccupe());
    }
}
