package emp;

import java.sql.Date;

public class Employe {

  String idEmploye;
  String nom;
  String prenom;
  Date dateNaissance;
  String adresse;
  String genre;
  String telephone;
  int idSalaire;

  public Employe(
    String idEmploye,
    String nom,
    String prenom,
    Date dateNaissance,
    String adresse,
    String genre,
    String telephone,
    int idSalaire
  ) {
    this.idEmploye = idEmploye;
    this.nom = nom;
    this.prenom = prenom;
    this.dateNaissance = dateNaissance;
    this.adresse = adresse;
    this.genre = genre;
    this.telephone = telephone;
    this.idSalaire = idSalaire;
  }

  public String getIdEmploye() {
    return this.idEmploye;
  }

  public void setIdEmploye(String idEmploye) {
    this.idEmploye = idEmploye;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Date getDateNaissance() {
    return this.dateNaissance;
  }

  public void setDateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public String getAdresse() {
    return this.adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getGenre() {
    return this.genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public int getIdSalaire() {
    return this.idSalaire;
  }

  public void setIdSalaire(int idSalaire) {
    this.idSalaire = idSalaire;
  }
}
