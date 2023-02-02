/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author DM
 */
public class Service {
    int idService;
    String nomService;
    double montantService;
    double quantite;

    public Service(int idService, String nomService, double montantService, double quantite) {
        this.idService = idService;
        this.nomService = nomService;
        this.montantService = montantService;
        this.quantite = quantite;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public double getMontantService() {
        return montantService;
    }

    public void setMontantService(double montantService) {
        this.montantService = montantService;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
    
}
