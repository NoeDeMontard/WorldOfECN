/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import static java.lang.Math.max;
import java.util.Random;

/**
 * Classe définissant un archer, une sous classe de personnage caractérisée par
 * un nombre de flèches et les attributs d'un personnage : son nom, ses points
 * de vie, ses points de Mana, son pourcentage d'attaque, son pourcentage de
 * parade, son pourcentage de magie, son pourcentage de résistance à la magie,
 * ses dégats d'attaque, ses dégats magiques, sa distance d'attaque maximale, sa
 * position
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Archer extends Personnage implements Combattant {

    private int nbFleches;

    /**
     * Créer un nouvel archer
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
     * @param nbF
     */
    public Archer(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int par, int dM, int distMax, Point2D pos, int nbF) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos);
        this.nbFleches = nbF;
    }

    /**
     * Créer un nouvel archer identique à un autre
     *
     * @param a un autre archer
     */
    public Archer(Archer a) { // Est ce que ça marche?
        super(a);
        nbFleches = a.getNbFleches();
    }

    /**
     * Créer un nouveau guerrier par défault
     */
    public Archer() {
        super();
        nbFleches = 5;
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println(" nbFleches = " + nbFleches);
    }
    
    @Override
    public  String toString(){
        String s = super.toString() + " " + nbFleches;
        return s;
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
            int def = generateurAleatoire.nextInt(100);
            if (def > c.getPourcentagePar()) {
                System.out.println("aie, le monstre perd " + this.getDegAtt() + "point de vie");
                c.setPtVie(c.getPtVie() - this.getDegAtt());
                System.out.println("Il lui en reste " + c.getPtVie());
            } else {
                System.out.println("un peu moins aie, le monstre perd " + max(this.getDegAtt() - c.getPtPar(), 0) + "point de vie");
                c.setPtVie(c.getPtVie() - max(this.getDegAtt() - c.getPtPar(), 0));
                System.out.println("Il lui en reste " + c.getPtVie());
            }

        }

        if (this.getPos().distance(c.getPos()) > this.getDistAttMax()) {
            System.out.println("Trop loin!");
        }

        if ((this.getPos().distance(c.getPos()) > 1) && (this.getPos().distance(c.getPos()) < this.getDistAttMax())) {
            Random generateurAleatoire = new Random();

            if (this.getNbFleches() > 0) {
                int tir = generateurAleatoire.nextInt(100);
                System.out.println("Jet de tir " + tir);
                this.setNbFleches(this.nbFleches - 1);
                if (tir > this.getPourcentageAtt()) {
                    System.out.println("A côté... ");
                }
                if (tir <= this.getPourcentageAtt()) {
                    System.out.println("Joli tir, le monstre perd" + this.getDegAtt() + "points de vie");
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                    System.out.println("Il lui en reste " + c.getPtVie());
                }
            } else {
                System.out.println("Dommage, plus assez de flèches!");
            }
        }
    }

}
