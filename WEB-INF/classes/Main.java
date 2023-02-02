/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import traitement.*;

/**
 *
 * @author DM
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("Bienvenue dans l'imprimerie");
    Traitement trtmt = new Traitement();
    double pv = trtmt.getPrixVente(14000);
    double remise = trtmt.getPrixRemise(20, pv);
    System.out.println(pv + " " + remise);
    try {
      trtmt.inserToFacture("Facture", "2023-02-01", 1, 6000, null);
    } catch (Exception e) {}
  }
}
