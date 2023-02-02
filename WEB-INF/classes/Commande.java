package service;

public class Commande {

  int idCommande;
  int idProduit;
  int idFormat;
  int idType;
  int idGram;
  int idMode;
  int quantite;

  public Commande(int idCommande, int idProduit, int idFormat, int idType, int idGram, int idMode, int quantite) {
    this.idCommande = idCommande;
    this.idProduit = idProduit;
    this.idFormat = idFormat;
    this.idType = idType;
    this.idGram = idGram;
    this.idMode = idMode;
    this.quantite = quantite;
  }


  public int getQuantite() {
    return this.quantite;
  }

  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }


  public int getIdCommande() {
    return this.idCommande;
  }

  public void setIdCommande(int idCommande) {
    this.idCommande = idCommande;
  }

  public int getIdProduit() {
    return this.idProduit;
  }

  public void setIdProduit(int idProduit) {
    this.idProduit = idProduit;
  }

  public int getIdFormat() {
    return this.idFormat;
  }

  public void setIdFormat(int idFormat) {
    this.idFormat = idFormat;
  }

  public int getIdType() {
    return this.idType;
  }

  public void setIdType(int idType) {
    this.idType = idType;
  }

  public int getIdGram() {
    return this.idGram;
  }

  public void setIdGram(int idGram) {
    this.idGram = idGram;
  }

  public int getIdMode() {
    return this.idMode;
  }

  public void setIdMode(int idMode) {
    this.idMode = idMode;
  }
}
