/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe définissant une créature
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Creature implements Deplacable {

    private int ptVie;
    private int PourcentageAtt;
    private int degAtt;
    private Point2D pos;
    private int PourcentagePar;
    private int ptPar;

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPourcentagePar() {
        return PourcentagePar;
    }

    public void setPourcentagePar(int PourcentagePar) {
        this.PourcentagePar = PourcentagePar;
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getPourcentageAtt() {
        return PourcentageAtt;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setPourcentageAtt(int PourcentageAtt) {
        this.PourcentageAtt = PourcentageAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Constructeur de Creature à partir des points de vie, du pourcentage
     * d'attaque, de parade, des dégâts d'attaque et d'une position
     *
     * @param ptV des points de vie
     * @param PA pourcentage d'attaque
     * @param PP pourcentage de parade
     * @param dA dégat d'attaque
     * @param par points de parade
     * @param ps position
     */
    public Creature(int ptV, int PA, int PP, int dA, int par, Point2D ps) {
        this.ptVie = ptV;
        this.PourcentageAtt = PA;
        this.PourcentagePar = PP;
        this.degAtt = dA;
        this.pos = ps;
        this.ptPar = par;
    }

    /**
     * Constructeur de Creature à partir d'une autre Creature
     *
     * @param m
     */
    public Creature(Creature m) {
        this.ptVie = m.getPtVie();
        this.PourcentageAtt = m.getPourcentageAtt();
        this.PourcentagePar = m.getPourcentagePar();
        this.degAtt = m.getDegAtt();
        this.pos = new Point2D(m.getPos());
        this.ptPar = m.getPtPar();
    }

    /**
     * Constructeur de Creature par défaut
     */
    public Creature() {
        this.ptVie = 100;
        this.PourcentageAtt = 60;
        this.PourcentagePar = 50;
        this.degAtt = 25;
        this.ptPar = 5;
        this.pos = new Point2D();
    }

    /**
     * Afficher une créature
     */
    public void affiche() {
        int x = this.pos.getX();
        int y = this.pos.getY();
        System.out.println("Le/la " + this.getClass().getSimpleName());
        System.out.println("se trouve en [" + x + ";" + y + "]");
        System.out.println(" a " + this.ptVie + " points de vie; ");
        System.out.println(+this.PourcentageAtt + " chance de toucher; ");
        System.out.println(+this.PourcentagePar + " chance de parer; ");
        System.out.println(+this.degAtt + " dégâts d'attaque");
        System.out.println(+this.ptPar + " points de parade");
    }
    @Override
    public String toString(){
        String s = this.getClass().getSimpleName() + " " + getPtVie() + " " 
                + getPourcentageAtt() + " " + getPourcentagePar() + " " 
                + getDegAtt() + " " + getPourcentagePar() + " "
                + getPos().toString();
        return s;
    }
    /**
     * Méthode permettant de déplacer aléatoirement une créature sur une case
     * avoisinant sa position de départ
     *
     * @param w Le monde dans lequel évoluer
     */
    @Override
    public void deplacer(World w) {
        ArrayList<Point2D> libre = new ArrayList<>();
        int limiteMonde = w.getTAILLEMONDE() - 1;
        int x = this.pos.getX();
        int y = this.pos.getY();
        try {
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

            Random generateurAleatoire = new Random();
            int entierAlea = generateurAleatoire.nextInt(libre.size());
            w.getOccupe()[x][y] = false;
            w.getPlateau()[x][y]="";
            this.setPos(libre.get(entierAlea));
            w.getOccupe()[this.getPos().getX()][this.getPos().getY()] = true;
            w.getPlateau()[this.getPos().getX()][this.getPos().getY()]=this.getClass().getSimpleName().substring(0, 2);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: pas de déplacement possible");
        }

    }
}