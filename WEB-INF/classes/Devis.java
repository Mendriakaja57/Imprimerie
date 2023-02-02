package service;

public class Devis {

  int idDevis;
  double montant;
  int idClient;
  int idCommande;

    public Devis(int idDevis, double montant, int idClient, int idCommande) {
        this.idDevis = idDevis;
        this.montant = montant;
        this.idClient = idClient;
        this.idCommande = idCommande;
    }
  
  

  public int getIdDevis() {
    return this.idDevis;
  }

  public void setIdDevis(int idDevis) {
    this.idDevis = idDevis;
  }

  public double getNom() {
    return this.montant;
  }

  public void setNom(double montant) {
    this.montant = montant;
  }

  public int getIdClient() {
    return this.idClient;
  }

  public void setIdClient(int idClient) {
    this.idClient = idClient;
  }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
  
  
}
