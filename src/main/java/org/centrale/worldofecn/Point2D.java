/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 * Classe définissant une position à partir d'une abscisse et d'une ordonnée
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Point2D {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    /**
     *
     * @param newX nouvelle coordonnée x
     * @param newY nouvelle coordonnée y
     */
    public void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     *
     * @param dx déplacement selon x
     * @param dy déplacement selon y
     */
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        String res = this.x + " " + this.y;
        return res;
    }

    /**
     *
     */
    public void affiche() {
        System.out.println("[" + this.x + ";" + this.y + "]");
    }

    public boolean compare(Point2D p) {
        return (this.getX() == p.getX()) && (this.getY() == p.getY());
    }

    /**
     * public double distance(Point2D d)
     *
     * @param d point auquel mesurer la distance
     * @return distance
     */
    public double distance(Point2D d) {
        int a = (this.x - d.getX()) * (this.x - d.getX());
        int b = (this.y - d.getY()) * (this.y - d.getY());
        double distance = Math.sqrt(a + b);
        return distance;
    }
}
