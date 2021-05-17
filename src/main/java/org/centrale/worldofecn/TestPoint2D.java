/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

import java.util.Scanner;

/**
 *
 * @author noede
 */
public class TestPoint2D {
    

    public static void main(String[] args) {
        // Scanner va permettre de lire au clavier des informations
        // c'est une classe du package java.util
        Scanner sc;

        System.out.println("Entrez une coordonnée x sous forme de nombre ");
        // on cree un Scanner qui est relie au clavier !
        // on va ainsi attendre que l'utilisateur entre une inforamtion puis appuie sur 'Enter'
        sc = new Scanner(System.in);
        // on recupere le dernier entier entre par l'utilisateur au clavier
        // si l'utilisateur ne rentre pas d'entier --> Exception et arret du programme (on verra ca en cours)
        int x = sc.nextInt();
        
        System.out.println("Entrez une coordonnée y sous forme de nombre ");
        int y = sc.nextInt();
        
        
        Point2D p = new Point2D(x, y);
        p.affiche();
        
        System.out.println("Entrez une translation dx sous forme de nombre ");
        int dx = sc.nextInt();
        
        System.out.println("Entrez une translation dy sous forme de nombre ");
        int dy = sc.nextInt();
        
        p.translate(dx, dy);
        p.affiche();
        
        System.out.println("construit par défaut: ");
        Point2D p2 = new Point2D();
        p2.affiche();
        
        System.out.println("recopie de p dans p3");
        Point2D p3 = new Point2D(p);
        p3.affiche();
        
        System.out.println("Set position de p2 à x;y rentrés au début");
        p2.setPosition(x,y);
        p2.affiche();
    }
}