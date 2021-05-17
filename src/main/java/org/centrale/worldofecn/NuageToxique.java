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
public class NuageToxique extends Item implements Combattant, Deplacable {

    private int toxicite;

    public NuageToxique() {
        super();
        toxicite = 5;
    }

    public NuageToxique(int toxicite) {
        super();
        this.toxicite = toxicite;
    }

    public NuageToxique(String nom, Point2D pos, int toxicite) {
        super(nom, pos);
        this.toxicite = toxicite;
    }

    @Override
    public String toString(){
        String s = super.toString() + " " + toxicite;
        return s;
    }
    /**
     * Le "combat" d'un nuage se fait uniquement lorsque le nuage est sur la
     * créature à "attaquer", et celle ci recoit des dégats fixes et non
     * esquivables
     *
     * @param c créature victime du nuage
     */
    @Override
    public void combattre(Creature c) {
        if (this.getPos().distance(c.getPos()) == 0) {
            c.setPtVie(c.getPtVie() - this.toxicite);
        }
    }

    /**
     * Le déplacement du nuage ne prend pas en compte la présence de quelqu'un,
     * de par sa caractériqtique nuageuse
     *
     * @param w le monde dans lequel se déplacer
     */
    @Override
    public void deplacer(World w) {
        ArrayList<Point2D> accessible = new ArrayList<>();
        int limiteMonde = w.getTAILLEMONDE() - 1;
        int x = this.getPos().getX();
        int y = this.getPos().getY();
        if (y < limiteMonde) {
            accessible.add(new Point2D(x, y + 1));
            if (x < limiteMonde) {
                accessible.add(new Point2D(x + 1, y + 1));
            }
            if (x > 0) {
                accessible.add(new Point2D(x - 1, y + 1));
            }
        }
        if (y > 0) {
            accessible.add(new Point2D(x, y - 1));
            if (x < limiteMonde) {
                accessible.add(new Point2D(x + 1, y - 1));
            }
            if (x > 0) {
                accessible.add(new Point2D(x - 1, y - 1));
            }
        }
        if (x < limiteMonde) {
            accessible.add(new Point2D(x + 1, y));
        }

        if (x > 0) {
            accessible.add(new Point2D(x - 1, y));
        }

        Random generateurAleatoire = new Random();
        int entierAlea = generateurAleatoire.nextInt(accessible.size());
        this.setPos(accessible.get(entierAlea));
    }

}
