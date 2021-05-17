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
import java.io.*;
import java.util.StringTokenizer;

public class ChargementPartie {

    private final String nomFichierSauvegarde;
    private final BufferedReader fichier;

    public ChargementPartie(String nomFichier) throws FileNotFoundException {
        this.nomFichierSauvegarde = nomFichier;
        fichier = new BufferedReader(new FileReader(nomFichierSauvegarde));
    }

    public World chargerPartie() throws IOException {
        World w;
        String ligne;
        String delimiteur = " ";
        StringTokenizer tokenizer;
        ligne = fichier.readLine();

        tokenizer = new StringTokenizer(ligne, delimiteur);
        String entree = tokenizer.nextToken();
        if (entree.toUpperCase().equals("TAILLEMONDE")) {
            if (tokenizer.hasMoreTokens()) {
                entree = tokenizer.nextToken();
                int taille;
                try {
                    taille = Integer.parseInt(entree);
                    w = new World(taille);
                } catch (NumberFormatException e) {
                    System.out.println("Sauvegarde corrompue");
                    w = new World();
                }
            } else {
                System.out.println("Sauvegarde corrompue");
                w = new World();
            }
        } else {
            System.out.println("Sauvegarde corrompue");
            w = new World();
        }
        ligne = fichier.readLine();

        while (ligne != null) {
            tokenizer = new StringTokenizer(ligne, delimiteur);
            entree = tokenizer.nextToken();

            switch (entree.toUpperCase()) {
                case "GUERRIER":
                    /*
                    Créer un nouveau guerrier
                    
                    @param nom un nom
                    @param ptV des points de vie
                    @param ptM des points de mana
                    @param pA pourcentage d'attaque
                    @param pP pourcentage de parade
                    @param pM pourcentage de magie
                    @param rM pourcentage de résistance à la magie
                    @param dA dégat d'attaque
                    @param par points de parade
                    @param dM dégat magiques
                    @param distMax portée
                    @param pos position
                     */
                    try{
                        String nom = tokenizer.nextToken();
                        int ptV = Integer.parseInt(tokenizer.nextToken());
                        int ptM = Integer.parseInt(tokenizer.nextToken());
                        int pA = Integer.parseInt(tokenizer.nextToken());
                        int pP = Integer.parseInt(tokenizer.nextToken());
                        int pM = Integer.parseInt(tokenizer.nextToken());
                        int rM = Integer.parseInt(tokenizer.nextToken());
                        int dA = Integer.parseInt(tokenizer.nextToken());
                        int par = Integer.parseInt(tokenizer.nextToken());
                        int dM = Integer.parseInt(tokenizer.nextToken());
                        int distMax = Integer.parseInt(tokenizer.nextToken());
                        Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

                        w.getPersonnages().add(new Guerrier(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "MAGE":
                    /*
                    Créer un nouveau Mage
                    
                    @param nom un nom
                    @param ptV des points de vie
                    @param ptM des points de mana
                    @param pA pourcentage d'attaque
                    @param pP pourcentage de parade
                    @param pM pourcentage de magie
                    @param rM pourcentage de résistance à la magie
                    @param dA dégat d'attaque
                    @param par points de parade
                    @param dM dégat magiques
                    @param distMax portée
                    @param pos position
                     */
                    try{
                        String nom = tokenizer.nextToken();
                        int ptV = Integer.parseInt(tokenizer.nextToken());
                        int ptM = Integer.parseInt(tokenizer.nextToken());
                        int pA = Integer.parseInt(tokenizer.nextToken());
                        int pP = Integer.parseInt(tokenizer.nextToken());
                        int pM = Integer.parseInt(tokenizer.nextToken());
                        int rM = Integer.parseInt(tokenizer.nextToken());
                        int dA = Integer.parseInt(tokenizer.nextToken());
                        int par = Integer.parseInt(tokenizer.nextToken());
                        int dM = Integer.parseInt(tokenizer.nextToken());
                        int distMax = Integer.parseInt(tokenizer.nextToken());
                        Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

                        w.getPersonnages().add(new Mage(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "ARCHER":
                    /*
                    Créer un nouvel archer
                    
                    @param nom un nom
                    @param ptV des points de vie
                    @param ptM des points de mana
                    @param pA pourcentage d'attaque
                    @param pP pourcentage de parade
                    @param pM pourcentage de magie
                    @param rM pourcentage de résistance à la magie
                    @param dA dégat d'attaque
                    @param par points de parade
                    @param dM dégat magiques
                    @param distMax portée
                    @param pos position
                    @param nbF nombre de flèches
                     */
                    try{
                        String nom = tokenizer.nextToken();
                        int ptV = Integer.parseInt(tokenizer.nextToken());
                        int ptM = Integer.parseInt(tokenizer.nextToken());
                        int pA = Integer.parseInt(tokenizer.nextToken());
                        int pP = Integer.parseInt(tokenizer.nextToken());
                        int pM = Integer.parseInt(tokenizer.nextToken());
                        int rM = Integer.parseInt(tokenizer.nextToken());
                        int dA = Integer.parseInt(tokenizer.nextToken());
                        int par = Integer.parseInt(tokenizer.nextToken());
                        int dM = Integer.parseInt(tokenizer.nextToken());
                        int distMax = Integer.parseInt(tokenizer.nextToken());
                        Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                        int nbF = Integer.parseInt(tokenizer.nextToken());

                        w.getPersonnages().add(new Archer(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos, nbF));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "PAYSANT":
                    /*
                    Créer un nouveau Paysan
                    
                    @param nom un nom
                    @param ptV des points de vie
                    @param ptM des points de mana
                    @param pA pourcentage d'attaque
                    @param pP pourcentage de parade
                    @param pM pourcentage de magie
                    @param rM pourcentage de résistance à la magie
                    @param dA dégat d'attaque
                    @param par points de parade
                    @param dM dégat magiques
                    @param distMax portée
                    @param pos position
                     */
                    try{
                    String nom = tokenizer.nextToken();
                        int ptV = Integer.parseInt(tokenizer.nextToken());
                        int ptM = Integer.parseInt(tokenizer.nextToken());
                        int pA = Integer.parseInt(tokenizer.nextToken());
                        int pP = Integer.parseInt(tokenizer.nextToken());
                        int pM = Integer.parseInt(tokenizer.nextToken());
                        int rM = Integer.parseInt(tokenizer.nextToken());
                        int dA = Integer.parseInt(tokenizer.nextToken());
                        int par = Integer.parseInt(tokenizer.nextToken());
                        int dM = Integer.parseInt(tokenizer.nextToken());
                        int distMax = Integer.parseInt(tokenizer.nextToken());
                        Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

                    w.getPersonnages().add(new Paysan(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "LOUP":
                    /*
                    Créer un nouveau Loup
                    
                    @param ptV des points de vie
                    @param pA pourcentage d'attaque
                    @param pP pourcentage de parade
                    @param dA dégat d'attaque
                    @param par points de parade
                    @param pos position
                     */
                    try{
                        int ptV = Integer.parseInt(tokenizer.nextToken());
                        int pA = Integer.parseInt(tokenizer.nextToken());
                        int pP = Integer.parseInt(tokenizer.nextToken());
                        int dA = Integer.parseInt(tokenizer.nextToken());
                        int par = Integer.parseInt(tokenizer.nextToken());
                        Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

                        w.getMonstres().add(new Loup(ptV, pA, pP, dA, par, pos));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "LAPIN":
                    /*
                    Créer un nouveau Lapin
                    
                    @param ptV des points de vie
                    @param pA pourcentage d'attaque
                    @param pP pourcentage de parade
                    @param dA dégat d'attaque
                    @param par points de parade
                    @param pos position
                     */
                    try{
                        int ptV = Integer.parseInt(tokenizer.nextToken());
                        int pA = Integer.parseInt(tokenizer.nextToken());
                        int pP = Integer.parseInt(tokenizer.nextToken());
                        int dA = Integer.parseInt(tokenizer.nextToken());
                        int par = Integer.parseInt(tokenizer.nextToken());
                        Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

                        w.getMonstres().add(new Loup(ptV, pA, pP, dA, par, pos));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "NUAGETOXIQUE":
                    try{
                    String nom = tokenizer.nextToken();
                    Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                    int toxicite = Integer.parseInt(tokenizer.nextToken());
                    
                    w.getItems().add(new NuageToxique(nom, pos, toxicite));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "SOIN":
                    try{
                    String nom = tokenizer.nextToken();
                    Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                    int N = Integer.parseInt(tokenizer.nextToken());
                    boolean P = Boolean.parseBoolean(tokenizer.nextToken());
                    w.getItems().add(new Soin(nom, pos, N, P));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "MANA":
                    try{
                        String nom = tokenizer.nextToken();
                        Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                        int N = Integer.parseInt(tokenizer.nextToken());
                        boolean P = Boolean.parseBoolean(tokenizer.nextToken());
                        w.getItems().add(new Mana(nom, pos, N, P));
                    } catch (NumberFormatException e) {
                        System.out.println("Sauvegarde corrompue");
                    }
                    break;
                case "JOUEUR":
                    entree = tokenizer.nextToken();
                    switch (entree.toUpperCase()) {
                        case "GUERRIER":
                            /*
                            Créer un nouveau guerrier
                            @param nom un nom
                            @param ptV des points de vie
                            @param ptM des points de mana
                            @param pA pourcentage d'attaque
                            @param pP pourcentage de parade
                            @param pM pourcentage de magie
                            @param rM pourcentage de résistance à la magie
                            @param dA dégat d'attaque
                            @param par points de parade
                            @param dM dégat magiques
                            @param distMax portée
                            @param pos position
                             */
                            try{
                                String nom = tokenizer.nextToken();
                                int ptV = Integer.parseInt(tokenizer.nextToken());
                                int ptM = Integer.parseInt(tokenizer.nextToken());
                                int pA = Integer.parseInt(tokenizer.nextToken());
                                int pP = Integer.parseInt(tokenizer.nextToken());
                                int pM = Integer.parseInt(tokenizer.nextToken());
                                int rM = Integer.parseInt(tokenizer.nextToken());
                                int dA = Integer.parseInt(tokenizer.nextToken());
                                int par = Integer.parseInt(tokenizer.nextToken());
                                int dM = Integer.parseInt(tokenizer.nextToken());
                                int distMax = Integer.parseInt(tokenizer.nextToken());
                                Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

                                w.getJoueurs().add(new Joueur(new Guerrier(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos)));
                            } catch (NumberFormatException e) {
                                System.out.println("Sauvegarde corrompue");
                            }
                            break;
                        case "MAGE":
                            /*
                            Créer un nouveau Mage

                            @param nom un nom
                            @param ptV des points de vie
                            @param ptM des points de mana
                            @param pA pourcentage d'attaque
                            @param pP pourcentage de parade
                            @param pM pourcentage de magie
                            @param rM pourcentage de résistance à la magie
                            @param dA dégat d'attaque
                            @param par points de parade
                            @param dM dégat magiques
                            @param distMax portée
                            @param pos position
                             */
                            try{
                                String nom = tokenizer.nextToken();
                                int ptV = Integer.parseInt(tokenizer.nextToken());
                                int ptM = Integer.parseInt(tokenizer.nextToken());
                                int pA = Integer.parseInt(tokenizer.nextToken());
                                int pP = Integer.parseInt(tokenizer.nextToken());
                                int pM = Integer.parseInt(tokenizer.nextToken());
                                int rM = Integer.parseInt(tokenizer.nextToken());
                                int dA = Integer.parseInt(tokenizer.nextToken());
                                int par = Integer.parseInt(tokenizer.nextToken());
                                int dM = Integer.parseInt(tokenizer.nextToken());
                                int distMax = Integer.parseInt(tokenizer.nextToken());
                                Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

                                w.getJoueurs().add(new Joueur(new Mage(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos)));
                            } catch (NumberFormatException e) {
                                System.out.println("Sauvegarde corrompue");
                            }
                            break;
                        case "ARCHER":
                            /*
                            Créer un nouvel archer

                            @param nom un nom
                            @param ptV des points de vie
                            @param ptM des points de mana
                            @param pA pourcentage d'attaque
                            @param pP pourcentage de parade
                            @param pM pourcentage de magie
                            @param rM pourcentage de résistance à la magie
                            @param dA dégat d'attaque
                            @param par points de parade
                            @param dM dégat magiques
                            @param distMax portée
                            @param pos position
                            @param nbF nombre de flèches
                             */
                            try{
                                String nom = tokenizer.nextToken();
                                int ptV = Integer.parseInt(tokenizer.nextToken());
                                int ptM = Integer.parseInt(tokenizer.nextToken());
                                int pA = Integer.parseInt(tokenizer.nextToken());
                                int pP = Integer.parseInt(tokenizer.nextToken());
                                int pM = Integer.parseInt(tokenizer.nextToken());
                                int rM = Integer.parseInt(tokenizer.nextToken());
                                int dA = Integer.parseInt(tokenizer.nextToken());
                                int par = Integer.parseInt(tokenizer.nextToken());
                                int dM = Integer.parseInt(tokenizer.nextToken());
                                int distMax = Integer.parseInt(tokenizer.nextToken());
                                Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                                int nbF = Integer.parseInt(tokenizer.nextToken());

                                w.getJoueurs().add(new Joueur(new Archer(nom, ptV, ptM, pA, pP, pM, rM, dA, par, dM, distMax, pos, nbF)));
                            } catch (NumberFormatException e) {
                                System.out.println("Sauvegarde corrompue");
                            }
                            break;
                        default:
                            System.out.println("le chargement de cette classe ( " + entree + " ) n'est pas prise en charge.");
                    }

                    break;
                default:
                    System.out.println("Entrée \"" + entree + "\" inconnue, IGNOREE");
            }

            ligne = fichier.readLine();
        }
        return w;
    }
}
