/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Paysan extends Personnage {

    public Paysan(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int par, int dM, int distMax, Point2D pos) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos);
    }

    public Paysan(Paysan p) {
        super(p);
    }

    public Paysan() {
        super();
    }
}
