/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import java.io.*;

/**
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class SauvegardePartie {
    
    public static void sauvegardePartie(World w){
        String nomFichierSauvegarde = "source.txt";
        BufferedWriter fichier = null;
        
        try {
            // Creation du BufferedWriter
            fichier = new BufferedWriter(new FileWriter(nomFichierSauvegarde)); 
            
            // On ecrit dans le fichier
            fichier.write("TAILLEMONDE " + w.getTAILLEMONDE());
            fichier.newLine();
            
            for (Personnage p : w.getPersonnages()){
                fichier.write(p.toString());
                fichier.newLine();
            }
            for (Monstre m : w.getMonstres()){
                fichier.write(m.toString());
                fichier.newLine();
            }
            for (Item i : w.getItems()){
                fichier.write(i.toString());
                fichier.newLine();
            }
            for (Joueur j : w.getJoueurs()){
                fichier.write("Joueur" + " " + j.getPerso().toString());
                fichier.newLine();
            }
            
          }
          // on attrape l'exception si on a pas pu creer le fichier
          catch (FileNotFoundException ex) {
            ex.printStackTrace();
          } 
          // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
          catch (IOException ex) {
            ex.printStackTrace();
          }
          // on ferme le fichier
          finally {
            try {
              if (fichier != null) {
                // je force l'écriture dans le fichier
                fichier.flush();
                // puis je le ferme
                fichier.close();
              }
            }
            // on attrape l'exception potentielle 
            catch (IOException ex) {
              ex.printStackTrace();
            }
          }
    }
}
