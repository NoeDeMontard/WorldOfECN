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
public class Item {

    private String nom;
    private Point2D pos;

    public String getNom() {
        return nom;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     *
     * @param nom un nom
     * @param pos une position
     */
    public Item(String nom, Point2D pos) {
        this.nom = nom;
        this.pos = pos;
    }

    /**
     *
     * @param i un item à copier
     */
    public Item(Item i) {
        this.nom = i.getNom();
        this.pos = i.getPos();
    }

    /**
     *
     */
    public Item() {
        this.nom = "Quelconque";
        this.pos = new Point2D();

    }
    @Override
    public String toString(){
        String s = this.getClass().getSimpleName() + " " + nom + " " + pos.toString();
        return s;
    }
}
