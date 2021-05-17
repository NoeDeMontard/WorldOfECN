/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import static java.lang.Math.max;
import java.util.Random;

/**
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Loup extends Monstre implements Combattant {

    /**
     * Constructeur de Loup à partir des points de vie, du pourcentage
     * d'attaque, de parade, des dégâts d'attaque et d'une position
     *
     * @param ptV des points de vie
     * @param pA pourcentage d'attaque
     * @param pP pourcentage de parade
     * @param dA dégat d'attaque
     * @param par points de parade
     * @param pos position
     */
    public Loup(int ptV, int pA, int pP, int dA, int par, Point2D pos) {
        super(ptV, pA, pP, dA, par, pos);
    }

    public Loup(Loup l) {
        super(l);
    }

    public Loup() {
        super();
    }

    /**
     * combattre une autre créature
     *
     * @param c une créature à combattre
     */
    @Override
    public void combattre(Creature c) {
        if (this.getPos().distance(c.getPos()) == 1) {
            Random generateurAleatoire = new Random();
            int att = generateurAleatoire.nextInt(100);
            System.out.println("Jet d'attaque" + att);
            if (att > this.getPourcentageAtt()) {
                System.out.println("Echec! :( ");
            }
            if (att <= this.getPourcentageAtt()) {
                System.out.println("Réussite!");
                int def = generateurAleatoire.nextInt(100);
                if (def > c.getPourcentagePar()) {
                    System.out.println("aie, le joueur perd " + this.getDegAtt() + "point de vie");
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                    System.out.println("Il lui en reste " + c.getPtVie());
                } else {
                    System.out.println("un peu moins aie, le joueur perd " + max(this.getDegAtt() - c.getPtPar(), 0) + "point de vie");
                    c.setPtVie(c.getPtVie() - max(this.getDegAtt() - c.getPtPar(), 0));
                    System.out.println("Il lui en reste " + c.getPtVie());
                }
            }
        }

        if (this.getPos().distance(c.getPos()) > 1) {
            System.out.println("Trop loin!");
        }

    }
}
