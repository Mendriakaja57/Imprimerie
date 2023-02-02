package service;

public class Produits{
    int idProduit;
    String nom;
    int idCategorie;

    public Produits(int idProduit, String nom, int idCategorie) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.idCategorie = idCategorie;
    }

    public int getIdProduit() {
        return this.idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdCategorie() {
        return this.idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

}