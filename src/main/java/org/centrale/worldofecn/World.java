/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

/**
 * Classe définissant un monde et créant des créatures. Elle possède également
 * une méthode de génération aléatoire de position
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class World {

    private final int TAILLEMONDE;
    private final boolean[][] occupe;
    private final String[][] plateau;
    private final List<Personnage> personnages = new ArrayList<>();
    private final List<Monstre> monstres = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
    private final List<Joueur> joueurs = new ArrayList<>();
    private final List<Double> distances = new ArrayList<>();
    private int en = 0;

    //Getters
    public int getTAILLEMONDE() {
        return TAILLEMONDE;
    }

    public boolean[][] getOccupe() {
        return occupe;
    }

    public List<Personnage> getPersonnages() {
        return personnages;
    }

    public List<Monstre> getMonstres() {
        return monstres;
    }

    public String[][] getPlateau() {
        return plateau;
    }

    
    public List<Item> getItems() {
        return items;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public List<Double> getDistances() {
        return distances;
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public World(int taille) {
        TAILLEMONDE = taille;
        occupe = new boolean[TAILLEMONDE][TAILLEMONDE];
        plateau = new String[TAILLEMONDE][TAILLEMONDE];
        for (int i=0; i<TAILLEMONDE; i++){
            for (int j=0; j<TAILLEMONDE; j++){
                plateau[i][j]="";
            }
        }
    }

    public World() {
        TAILLEMONDE = 10;
        occupe = new boolean[TAILLEMONDE][TAILLEMONDE];
        plateau = new String[TAILLEMONDE][TAILLEMONDE];
        for (int i=0; i<TAILLEMONDE; i++){
            for (int j=0; j<TAILLEMONDE; j++){
                plateau[i][j]="";
            }
        }
    }

    /**
     * Méthode de génération aléatoire de position pour les trois entités créées
     * de manière à ce qu'elle soit assez proche les une des autres
     */
    public void creeMondeAlea() {

        Random geneAlea = new Random();

        int nMax = 10; //nombre maximal de créature générées par classe

        //creation d'Archers
        int ni = geneAlea.nextInt(nMax);
        for (int i = 0; i < ni; i++) {
            personnages.add(new Archer());
        }
        //creation de Paysants
        ni = geneAlea.nextInt(nMax);
        for (int i = 0; i < ni; i++) {
            personnages.add(new Paysan());
        }
        //creation de Guerriers
        ni = geneAlea.nextInt(nMax);
        for (int i = 0; i < ni; i++) {
            personnages.add(new Guerrier());
        }
        //creation de Lapins
        ni = geneAlea.nextInt(nMax);
        for (int i = 0; i < ni; i++) {
            monstres.add(new Lapin());
        }
        //creation de Loups
        ni = geneAlea.nextInt(nMax);
        for (int i = 0; i < ni; i++) {
            monstres.add(new Loup());
        }

        Joueur j = new Joueur(this);
        joueurs.add(j);
        occupe[j.getPerso().getPos().getX()][j.getPerso().getPos().getY()] = true;
        plateau[j.getPerso().getPos().getX()][j.getPerso().getPos().getY()] = "Jo";
        System.out.println("Vous êtes en [" + j.getPerso().getPos().getX() + "," + j.getPerso().getPos().getY() + "]");

        Random generateurAleatoire = new Random();

        for (int i = 0; i < personnages.size(); i++) {
            int x = 0;
            int y = 0;
            while (occupe[x][y] == true) {
                x = generateurAleatoire.nextInt(TAILLEMONDE);
                y = generateurAleatoire.nextInt(TAILLEMONDE);
            }
            //la position n'est pas occupée
            Point2D pos = new Point2D(x, y);
            this.personnages.get(i).setPos(pos);
            occupe[x][y] = true;
            plateau[x][y] = personnages.get(i).getClass().getSimpleName().substring(0, 2);
        }

        System.out.println("Il y a " + monstres.size() + " monstres");

        for (int i = 0; i < monstres.size(); i++) {
            int x = 0;
            int y = 0;
            while (occupe[x][y] == true) {
                x = generateurAleatoire.nextInt(TAILLEMONDE);
                y = generateurAleatoire.nextInt(TAILLEMONDE);
            }
            //la position n'est pas occupée
            Point2D pos = new Point2D(x, y);
            this.monstres.get(i).setPos(pos);
            occupe[x][y] = true;
            plateau[x][y] = monstres.get(i).getClass().getSimpleName().substring(0, 2);
            distances.add(pos.distance(j.getPerso().getPos()));
            System.out.println("Il y a un monstre en [" + pos.getX() + "," + pos.getY() + "] à une distance de " + distances.get(i));
        }
    }

    public void TourDeJeu() {
        System.out.println("===============Nouveau tour===========");

        for (int i=0; i<TAILLEMONDE; i++){
           StringBuilder S = new StringBuilder();
           for (int j=0; j<TAILLEMONDE; j++){
               
               
               if (plateau[j][i].isEmpty()) {
                   S = S.append("** ");
               } else {
                   S=S.append(plateau[j][i]+" ");
                   
               }
            
           }
           System.out.println(S);   
        }
        
        
        
        
        
        
        
        
        
        if (joueurs.isEmpty()) {
            System.out.println("Restart");
        } else {
            for (Joueur j : joueurs) {

                for (int i = 0; i < monstres.size(); i++) {
                    distances.set(i, monstres.get(i).getPos().distance(j.getPerso().getPos()));
                    if (monstres.get(i).getPtVie() <= 0) {
                        monstres.remove(i);
                    }
                }
                // /!\ ICI, POTENTIELLE ERREUR
                double min = distances.get(0);
                for (int i = 1; i < monstres.size(); i++) {
                    if (distances.get(i) < min) {
                        min = distances.get(i);
                        en = i;

                    }
                }
                System.out.println("C'est au tour de " + j.getPerso().getNom());
                System.out.println("Le monstre le plus proche est à une distance de " + distances.get(en));
                System.out.println(" et se situe en [" + monstres.get(en).getPos().getX() + "," + monstres.get(en).getPos().getY() + "]");
                java.util.Scanner entree = new java.util.Scanner(System.in);
                boolean entreeValide = false;
                String choix = "";
                while (entreeValide == false) {
                    System.out.println("Attaque ou deplacement?");
                    choix = entree.next().toUpperCase();
                    if (choix.equals("ATTAQUE") || choix.equals("DEPLACEMENT")) {
                        entreeValide = true;
                    }
                }

                if (choix.equals("ATTAQUE")) {

                    if (j.getPerso() instanceof Combattant) {
                        if (monstres.isEmpty() == false) {
                            ((Combattant) (j.getPerso())).combattre(monstres.get(en));
                        } else {
                            System.out.println("Pas de monstre à combattre, passez votre tour");
                        }
                    }
                }

                if (choix.equals("DEPLACEMENT")) {
                    j.deplace(this);
                    j.getPerso().getPos().affiche();
                }

                if (monstres.isEmpty() == false) {
                    if (monstres.get(en) instanceof Combattant) {
                        System.out.println("Contre-attaque!");
                        ((Combattant) (monstres.get(en))).combattre((Creature) (j.getPerso()));
                        if (j.getPerso().getPtVie() <= 0) {
                            System.out.println("YOU DIE");
                        }
                    } else {
                        System.out.println("Je suis un pauvre lapin sans défense");
                    }
                }

                for (int i = 0; i < monstres.size(); i++) {
                    monstres.get(i).deplacer(this);
                }

                if (j.getPerso().getPtVie() <= 0) {
                    joueurs.remove(j);
                    if(joueurs.isEmpty()){
                        break;
                    }
                }
            }
        }
    }
}