/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Joueur {

    private Personnage perso;

    public Personnage getPerso() {
        return perso;
    }

    public Joueur(Personnage personnage) {
        this.perso = personnage;
    }

    public Joueur(World w) { // L'équilibrage entre classes est à revoir entièrement de par le temps passé à faire le reste
        java.util.Scanner entree = new java.util.Scanner(System.in);
        Random generateurAleatoire = new Random();

        boolean classeValide = false;
        while (classeValide == false) {
            classeValide = true;
            System.out.println("Quelle classe voulez vous incarner? (Guerrier/Mage/Archer)");
            String classe = entree.next();
            int x;
            int y;
            Point2D pos;
            switch (classe.toUpperCase()) {
                case "GUERRIER":
                    perso = new Guerrier();

                    x = generateurAleatoire.nextInt(25) + 100;
                    perso.setPtVie(x);
                    x = generateurAleatoire.nextInt(5) + 25;
                    perso.setDegAtt(x);
                    perso.setPtMana(0);
                    x = generateurAleatoire.nextInt(45) + 40;
                    perso.setPourcentageAtt(x);
                    perso.setPourcentageMag(0);
                    x = generateurAleatoire.nextInt(25) + 30;
                    perso.setPourcentageResistMag(x);
                    perso.setDegMag(0);
                    x = generateurAleatoire.nextInt(4) + 3;
                    perso.setDistAttMax(x);
                    x = generateurAleatoire.nextInt(10) + 50;
                    perso.setPourcentagePar(x);
                    x = generateurAleatoire.nextInt(3) + 4;
                    perso.setPtPar(x);
                    x = generateurAleatoire.nextInt(w.getTAILLEMONDE());
                    y = generateurAleatoire.nextInt(w.getTAILLEMONDE());
                    pos = new Point2D(x, y);
                    perso.setPos(pos);
                    break;
                case "MAGE":
                    perso = new Mage();

                    x = generateurAleatoire.nextInt(25) + 100;
                    perso.setPtVie(x);
                    x = generateurAleatoire.nextInt(5) + 25;
                    perso.setDegAtt(x);
                    x = generateurAleatoire.nextInt(25) + 100;
                    perso.setPtMana(x);
                    perso.setPourcentageMag(50);
                    x = generateurAleatoire.nextInt(25) + 30;
                    perso.setPourcentageResistMag(x);
                    x = generateurAleatoire.nextInt(5) + 25;
                    perso.setDegMag(x);
                    x = generateurAleatoire.nextInt(4) + 3;
                    perso.setDistAttMax(x);
                    x = generateurAleatoire.nextInt(10) + 50;
                    perso.setPourcentagePar(x);
                    x = generateurAleatoire.nextInt(3) + 4;
                    perso.setPtPar(x);
                    x = generateurAleatoire.nextInt(w.getTAILLEMONDE());
                    y = generateurAleatoire.nextInt(w.getTAILLEMONDE());
                    pos = new Point2D(x, y);
                    perso.setPos(pos);
                    break;
                case "ARCHER":
                    perso = new Archer();

                    x = generateurAleatoire.nextInt(25) + 100;
                    perso.setPtVie(x);
                    x = generateurAleatoire.nextInt(5) + 25;
                    perso.setDegAtt(x);
                    perso.setPtMana(0);
                    perso.setPourcentageMag(0);
                    x = generateurAleatoire.nextInt(25) + 30;
                    perso.setPourcentageResistMag(x);
                    perso.setDegMag(0);
                    x = generateurAleatoire.nextInt(4) + 3;
                    perso.setDistAttMax(x);
                    x = generateurAleatoire.nextInt(10) + 50;
                    perso.setPourcentagePar(x);
                    x = generateurAleatoire.nextInt(3) + 4;
                    perso.setPtPar(x);
                    x = generateurAleatoire.nextInt(w.getTAILLEMONDE());
                    y = generateurAleatoire.nextInt(w.getTAILLEMONDE());
                    pos = new Point2D(x, y);
                    perso.setPos(pos);
                    ((Archer) perso).setNbFleches(10);
                    break;
                default:
                    classeValide = false;
                    System.out.println("classe invalide, re-essayez");
            }
        }
        System.out.println("Quel est votre nom?");
        String nom = entree.next();
        perso.setNom(nom);

    }

    /**
     * Cette méthode demande au joueur où il souhaite se déplacer
     *
     * @param w le monde dans lequel se déplacer
     */
    public void deplace(World w) {
        java.util.Scanner entree = new java.util.Scanner(System.in);
        ArrayList<Point2D> libre = new ArrayList<>();
        int limiteMonde = w.getTAILLEMONDE() - 1;
        int x = perso.getPos().getX();
        int y = perso.getPos().getY();

        /* on vérifie qu'on est pas aux limites et que les cases adjacentes 
        dans les limites sont libres
         */
        if (y < limiteMonde) {
            if (w.getOccupe()[x][y + 1] == false) {
                libre.add(new Point2D(x, y + 1));
            }
            if (x < limiteMonde) {
                if (w.getOccupe()[x + 1][y + 1] == false) {
                    libre.add(new Point2D(x + 1, y + 1));
                }
            }
            if (x > 0) {
                if (w.getOccupe()[x - 1][y + 1] == false) {
                    libre.add(new Point2D(x - 1, y + 1));
                }
            }
        }
        if (y > 0) {
            if (w.getOccupe()[x][y - 1] == false) {
                libre.add(new Point2D(x, y - 1));
            }
            if (x < limiteMonde) {
                if (w.getOccupe()[x + 1][y - 1] == false) {
                    libre.add(new Point2D(x + 1, y - 1));
                }
            }
            if (x > 0) {
                if (w.getOccupe()[x - 1][y - 1] == false) {
                    libre.add(new Point2D(x - 1, y - 1));
                }
            }
        }
        if (x < limiteMonde) {
            if (w.getOccupe()[x + 1][y] == false) {
                libre.add(new Point2D(x + 1, y));
            }
        }
        if (x > 0) {
            if (w.getOccupe()[x - 1][y] == false) {
                libre.add(new Point2D(x - 1, y));
            }
        }

        if (libre.isEmpty()) { //toutes les cases adjacentes sont occupées ou hors du monde
            System.out.println("vous êtes bloqués");
        } else {
            boolean bouger = false;
            while (bouger == false) { // on boucle tant que le joueur n'entre pas une direction d'une case disponnible
                boolean entreeValide = false;
                Point2D p = new Point2D();
                while (entreeValide == false) { // demande d'une entrée sémantiquement valide, on boucle si elle ne l'est pas
                    System.out.println("Choisissez votre déplacement (points cardinaux : N/NE/E/SE/S/SO/O/NO)");
                    String dep = entree.next();

                    entreeValide = true;
                    switch (dep.toUpperCase()) {
                        case "N":
                            p = new Point2D(x, y - 1);
                            break;
                        case "NE":
                            p = new Point2D(x + 1, y - 1);
                            break;
                        case "E":
                            p = new Point2D(x + 1, y);
                            break;
                        case "SE":
                            p = new Point2D(x + 1, y + 1);
                            break;
                        case "S":
                            p = new Point2D(x, y + 1);
                            break;
                        case "SO":
                            p = new Point2D(x - 1, y + 1);
                            break;
                        case "O":
                            p = new Point2D(x - 1, y);
                            break;
                        case "NO":
                            p = new Point2D(x - 1, y - 1);
                            break;
                        default:
                            entreeValide = false;
                            System.out.println("déplacement invalide");
                    }
                } // l'entrée du joueur est maintenant transformée en une case existante

                for (Point2D pos : libre) {
                    if (p.compare(pos) == true) {
                        bouger = true;
                        perso.setPos(p);
                         w.getOccupe()[x][y] = false;
                         w.getPlateau()[x][y]="";
                         w.getOccupe()[p.getX()][p.getY()] = true;
                         w.getPlateau()[p.getX()][p.getY()]="Jo";
                    }
                }
                if (bouger == false) {
                    System.out.println("déplacement impossible");
                    System.out.println();
                }
               
            }

        }
    }
}