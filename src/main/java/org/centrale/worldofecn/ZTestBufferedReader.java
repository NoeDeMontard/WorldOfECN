/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.worldofecn;

/**
 *
 * @author Jean-Marie Normand (jean-marie.normand@ec-nantes.fr)
 */
import java.io.*;

public class ZTestBufferedReader {
  protected String source;
  
  public ZTestBufferedReader(String source) {
    this.source = source;
    lecture();
  }

  public static void main(String args[]) {
      ZTestBufferedReader testBufferedReader = new ZTestBufferedReader("source.txt");
  }

  private void lecture() { 
    try {
      String ligne ;
      BufferedReader fichier = new BufferedReader(new FileReader(source));
      ligne = fichier.readLine();
      while (ligne != null) {
          System.out.println(ligne);
          ligne = fichier.readLine();
      }

      fichier.close();
    } catch (Exception e) {
      e.printStackTrace();
    }     
  }    
}