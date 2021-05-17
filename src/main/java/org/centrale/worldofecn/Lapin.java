/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 * Classe définissant un lapin, qui est une sous-classe de monstre
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Lapin extends Monstre {

    /**
     * Constructeur de Lapin à partir des points de vie, du pourcentage
     * d'attaque, de parade, des dégâts d'attaque et d'une position
     *
     * @param ptV des points de vie
     * @param pA pourcentage d'attaque
     * @param pP pourcentage de parade
     * @param dA dégat d'attaque
     * @param par points de parade
     * @param pos position
     */
    public Lapin(int ptV, int pA, int pP, int dA, int par, Point2D pos) {
        super(ptV, pA, pP, dA, par, pos);
    }

    /**
     * Constructeur de Lapin à partir d'un autre monstre
     *
     * @param l un lapin à copier
     */
    public Lapin(Lapin l) {
        super(l);
    }

    /**
     * Constructeur de Lapin par défaut
     */
    public Lapin() {
        super();
    }
}
