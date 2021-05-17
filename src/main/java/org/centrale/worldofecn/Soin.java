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
public class Soin extends Potion {

    private int Qtsoin;

    public int getQtsoin() {
        return Qtsoin;
    }

    public void setQtsoin(int Qtsoin) {
        this.Qtsoin = Qtsoin;
    }

    /**
     *
     * @param nom un nom
     * @param pos une position
     * @param N niveau de la potion
     * @param P est elle pleine?
     */
    public Soin(String nom, Point2D pos, int N, boolean P) {
        super(nom, pos, N, P);
        if (super.isPleine() == false) {
            this.Qtsoin = 0;
        } else {
            switch (super.getNiveau()) {
                case 1:
                    this.Qtsoin = 5;
                    break;
                case 2:
                    this.Qtsoin = 10;
                    break;
                case 3:
                    this.Qtsoin = 15;
                    break;
                case 4:
                    this.Qtsoin = 20;
                    break;
            }
        }

    }

    /**
     *
     * @param s une potion de soins à copier
     */
    public Soin(Soin s) {
        super(s);
        this.Qtsoin = s.getQtsoin();
    }

    public Soin() {
        super();
        this.Qtsoin = 5;
    }

    @Override
    public int boire() {
        this.setPleine(false);
        return this.Qtsoin;
    }
}
