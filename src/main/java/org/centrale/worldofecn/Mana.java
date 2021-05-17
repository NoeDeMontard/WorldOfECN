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
public class Mana extends Potion {

    private int QtMana;

    /**
     *
     * @return
     */
    public int getQtMana() {
        return QtMana;
    }

    /**
     *
     * @param QtMana
     */
    public void setQtMana(int QtMana) {
        this.QtMana = QtMana;
    }

    /**
     *
     * @param nom un nom
     * @param pos une position
     * @param N niveau de la potion
     * @param P est elle pleine?
     */
    public Mana(String nom, Point2D pos, int N, boolean P) {
        super(nom, pos, N, P);
        if (super.isPleine() == false) {
            this.QtMana = 0;
        } else {
            switch (super.getNiveau()) {
                case 1:
                    this.QtMana = 5;
                    break;
                case 2:
                    this.QtMana = 10;
                    break;
                case 3:
                    this.QtMana = 15;
                    break;
                case 4:
                    this.QtMana = 20;
                    break;
            }
        }

    }

    /**
     *
     * @param s potion de mana à copier
     */
    public Mana(Mana s) {
        super(s);
        this.QtMana = s.getQtMana();
    }

    /**
     *
     */
    public Mana() {
        super();
        this.QtMana = 5;

    }

    @Override
    public int boire() {
        this.setPleine(false);
        return this.QtMana;
    }
}
