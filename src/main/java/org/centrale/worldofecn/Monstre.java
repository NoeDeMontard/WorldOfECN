/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 * Classe définissant un monstre, une entité possédant des points de vie, un
 * pourcentage d'attaque, de parade, des dégâts d'attaque, une position et qui
 * peut se déplacer
 *
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Monstre extends Creature {

    /**
     * Constructeur de Monstre à partir des points de vie, du pourcentage
     * d'attaque, de parade, des dégâts d'attaque et d'une position
     *
     * @param ptV points de vie
     * @param PA pourcentage d'attaque
     * @param PP pourcentage de parade
     * @param dA dégats d'attaque
     * @param ps position
     * @param par points de parade
     */
    public Monstre(int ptV, int PA, int PP, int dA, int par, Point2D ps) {
        super(ptV, PA, PP, dA, par, ps);
    }

    /**
     * Constructeur de Monstre à partir d'un autre monstre
     *
     * @param m un monstre à copier
     */
    public Monstre(Monstre m) {
        super(m);
    }

    /**
     * Constructeur de Monstre par défaut
     */
    public Monstre() {
        super();
    }
}
