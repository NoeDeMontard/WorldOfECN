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
public class Mage extends Personnage implements Combattant {

    /**
     * Créer un nouveau Mage
     *
     * @param nom un nom
     * @param ptV des points de vie
     * @param ptM des points de mana
     * @param pA pourcentage d'attaque
     * @param pP pourcentage de parade
     * @param pM pourcentage de magie
     * @param rM pourcentage de résistance à la magie
     * @param dA dégat d'attaque
     * @param par points de parade
     * @param dM dégat magiques
     * @param distMax portée
     * @param pos position
     */
    public Mage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int par, int dM, int distMax, Point2D pos) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos);
    }

    /**
     * Créer un nouveau Mage identique à un autre
     *
     * @param a
     */
    public Mage(Mage a) {
        super(a);
    }

    /**
     * Créer un nouveau Mage par défault
     */
    public Mage() {
        super();
    }

    /**
     * combattre une autre créature
     *
     * @param c une créature à combattre
     */
    @Override
    public void combattre(Creature c) {

        if ((this.getPos().distance(c.getPos()) >= 1) && (this.getPos().distance(c.getPos()) < this.getDistAttMax())) {
            Random generateurAleatoire = new Random();
            int mag = generateurAleatoire.nextInt(100);
            System.out.println("Jet de magie " + mag);
            if (this.getPtMana() > 0) {
                this.setPtMana(this.getPtMana() - 1);
                if (mag > this.getPourcentageMag()) {
                    System.out.println("A côté... ");
                }
                if (mag <= this.getPourcentageMag()) {
                    System.out.println("Boum! Le monstre perd " + this.getDegMag() + " PV");
                    c.setPtVie(c.getPtVie() - this.getDegMag());
                    System.out.println("Il lui en reste " + c.getPtVie());
                }
            } else {
                System.out.println("A sec, cours!");
            }
            if (this.getPos().distance(c.getPos()) > this.getDistAttMax()) {
                System.out.println("Trop loin!");
            }
        }
    }
}
