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
public abstract class Potion extends Item {

    private int Niveau;
    private boolean Pleine;

    public int getNiveau() {
        return Niveau;
    }

    public boolean isPleine() {
        return Pleine;
    }

    public void setNiveau(int Niveau) {
        this.Niveau = Niveau;
    }

    public void setPleine(boolean Pleine) {
        this.Pleine = Pleine;
    }
    @Override
    public String toString(){
        String s = super.toString() + " " + Niveau + " " + Pleine;
        return s;
    }
    /**
     *
     * @param nom un nom
     * @param pos une position
     * @param N niveau de la potion
     * @param P est elle pleine?
     */
    public Potion(String nom, Point2D pos, int N, boolean P) {
        super(nom, pos);
        this.Niveau = N;
        this.Pleine = P;
    }

    /**
     *
     * @param P potion à copier
     */
    public Potion(Potion P) {
        super(P);
        this.Niveau = P.getNiveau();
        this.Pleine = P.isPleine();

    }

    public Potion() {
        super();
        this.Niveau = 1;
        this.Pleine = true;
    }

    public abstract int boire();

}
