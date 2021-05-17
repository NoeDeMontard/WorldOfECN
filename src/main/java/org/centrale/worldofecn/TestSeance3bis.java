/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;


import java.util.Random;

/**
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class TestSeance3bis {
    public static void main(String[] args){
        
        World w = new World();
        int nbrProta = 2500;
        
        for (int i=0;i<nbrProta;i++){
            w.getPersonnages().add(new Archer());
        }
        for (Personnage p : w.getPersonnages()){
            Random generateurAleatoire = new Random();
            
            int x = 0;
            int y = 0;
            while( w.getOccupe()[x][y] == true ){
                x = generateurAleatoire.nextInt(50)+1;
                y = generateurAleatoire.nextInt(50)+1;
            }
            //la position n'est pas occupée
            Point2D pos = new Point2D(x,y);
            p.setPos(pos);
            w.getOccupe()[x][y] = true; //rajouté à posteriori
        }
        
        System.out.println("Calcul de barycentre (méthode taille avec LinkedList): ");
        long debutN = System.nanoTime();
        float x = 0;
        float y = 0;
        for (int i=0;i<w.getPersonnages().size(); i++){
            x += w.getPersonnages().get(i).getPos().getX();
            y += w.getPersonnages().get(i).getPos().getY();
        }
        x = x/w.getPersonnages().size();
        y = y/w.getPersonnages().size();
        
        System.out.println("barycentre : [" + x + "," + y + "]");
        long finN = System.nanoTime();
        System.out.println("Temps écoulé en ns : " + (finN - debutN));
        
        
        System.out.println("Calcul de barycentre (méthode itérateur avec LinkedList): ");
        long debutN1 = System.nanoTime();
        float x1 = 0;
        float y1 = 0;
        for (Personnage p : w.getPersonnages()){
            x1 += p.getPos().getX();
            y1 += p.getPos().getY();
        }
        x1 = x1/w.getPersonnages().size();
        y1 = y1/w.getPersonnages().size();
        
        System.out.println("barycentre : [" + x1 + "," + y1 + "]");
        
        long finN1 = System.nanoTime();
        System.out.println("Temps écoulé en ns : " + (finN1 - debutN1));
        
        //w.getPersonnages().get(0).deplace(w);
    }
}
