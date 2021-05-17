/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import static java.lang.Math.max;
import java.util.Random;

/**
 * Classe définissant un guerrier, une sous classe de personnage caractérisée
 * par les attributs d'un personnage : son nom, ses points de vie, ses points de
 * Mana, son pourcentage d'attaque, son pourcentage de parade, son pourcentage
 * de magie, son pourcentage de résistance à la magie, ses dégats d'attaque, ses
 * dégats magiques, sa distance d'attaque maximale, sa position
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Guerrier extends Personnage implements Combattant {

    /**
     * Créer un nouveau guerrier
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
    public Guerrier(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int par, int dM, int distMax, Point2D pos) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos);
    }

    /**
     * Créer un nouveau guerrier identique à un autre
     *
     * @param a un autre guerrier
     */
    public Guerrier(Guerrier a) {
        super(a);
    }

    /**
     * Créer un nouveau guerrier par défault
     */
    public Guerrier() {
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
                    System.out.println("aie, le monstre perd " + this.getDegAtt() + " points de vie");
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                    System.out.println("Il lui en reste " + c.getPtVie());
                } else {
                    System.out.println("un peu moins aie, le monstre perd " + max(this.getDegAtt() - c.getPtPar(), 0) + " points de vie");
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
