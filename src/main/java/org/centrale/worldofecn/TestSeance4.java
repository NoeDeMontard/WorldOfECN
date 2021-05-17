/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 *
 * @author Noé de Montard (Noe.de-Montard@eleves.ec-nantes.fr)
 */
public class TestSeance4 {
    public static void main(String[] args){
        Personnage p0 = null;
        try{
            Point2D pos = p0.getPos();
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException");
        }
        
        World w = new World();
        p0 = new Personnage();
        p0.setPos(new Point2D(50, 53));
        p0.deplacer(w);
        
        
        //Calcul de barycentre (méthode itérateur): 
        try{
            int x1 = 0; //quotient du barycentre
            int y1 = 0;
            for (Personnage p : w.getPersonnages()){// il n'y a pas de personnages
                x1 += p.getPos().getX();
                y1 += p.getPos().getY();
            }
            x1 = x1/w.getPersonnages().size();
            y1 = y1/w.getPersonnages().size();

            System.out.println("barycentre : [" + x1 + "," + y1 + "]");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException : "+"aucun personnage");
        }
        
        try{// pas réussi à avoir la bonne exception (java.lang.RuntimeException)
            //Archer a = new Creature(); //java.lang.RuntimeException
            //Creature c = new Archer();// ça marche, pas d'exception
            Mage m = new Mage();
            //Monstre m1 = m;
        } catch (ClassCastException e){
            System.out.println("ClassCastException");
        }

        String s = "deux";
        try{
            int i = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            System.out.println("NumberFormatException avec \"" + s +"\"");
        }
        
        String s1 = "2 ";
        try{
            int i = Integer.parseInt(s1);
        } catch(NumberFormatException e) {
            System.out.println("NumberFormatException avec \"" + s1 +"\"");
        }
        
        try{
            ClassTestMethodes.recursif(0);
        } catch (StackOverflowError e){
            System.out.println("StackOverflowError");
        }
        
        //ConcurrentModificationException : on verra si on la rencontre 
        //naturellement, on y reviendra même si ce n'est  pas le cas
    }
}
