/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 * Classe définissant un personnage, caractérisé par son nom, ses points de vie,
 * ses points de Mana, son pourcentage d'attaque, son pourcentage de parade, son
 * pourcentage de magie, son pourcentage de résistance à la magie, ses dégats
 * d'attaque, ses dégats magiques, sa distance d'attaque maximale, sa position
 *
 * @author Jean Rebora (jean.rebora@eleves.ec-nantes.fr)
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class Personnage extends Creature {

    private String nom;
    private int ptMana;
    private int pourcentageMag;
    private int pourcentageResistMag;
    private int degMag;
    private int distAttMax;

    /**
     * Créer un nouveau personnage
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
    public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int par, int dM, int distMax, Point2D pos) {
        super(ptV, pA, pP, dA, par, pos);
        this.nom = nom;
        this.ptMana = ptM;
        this.pourcentageMag = pM;
        this.pourcentageResistMag = rM;
        this.degMag = dM;
        this.distAttMax = distMax;
    }

    /**
     * Créer un nouveau personnage identique à un autre
     *
     * @param p un autre personnage à copier
     */
    public Personnage(Personnage p) {
        super(p);
        this.nom = p.getNom();
        this.ptMana = p.getPtMana();
        this.pourcentageMag = p.getPourcentageMag();
        this.pourcentageResistMag = p.getPourcentageResistMag();
        this.degMag = p.getDegMag();
        this.distAttMax = p.getDistAttMax();
    }

    /**
     * Créer un nouveau personnage par défault
     */
    public Personnage() {
        super();
        this.nom = "Roger";
        this.ptMana = 5;
        this.pourcentageMag = 50;
        this.pourcentageResistMag = 50;
        this.degMag = 25;
        this.distAttMax = 5;
    }

    public String getNom() {
        return nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * affiche les caractéristiques du personnage
     */
    @Override
    public void affiche() {
        System.out.println(ptMana + " points de Mana");
        System.out.println(pourcentageMag + " chances de réussir sa magie");
        System.out.println(pourcentageResistMag + " chances de résister à la magie");
        System.out.println(degMag + " dégats magiques");
        System.out.println(distAttMax + " de distance d'attaque");
        System.out.println("s'appelle " + nom);
        System.out.println();
    }
    
    @Override
    public String toString(){
        String s = this.getClass().getSimpleName() + " " + nom + " " 
                + getPtVie() + " " + ptMana + " " + getPourcentageAtt() + " " 
                + getPourcentagePar() + " " + pourcentageMag + " " 
                + pourcentageResistMag + " " + getDegAtt() + " " 
                + getPourcentagePar() + " " + degMag + " " + distAttMax + " " 
                + getPos().toString();
        return s;
    }

}