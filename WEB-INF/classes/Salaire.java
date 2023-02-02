package service;

public class Salaire {

  int idSalaire;
  double salaire;

  public Salaire(int idSalaire, double salaire) {
    this.idSalaire = idSalaire;
    this.salaire = salaire;
  }

  public int getIdSalaire() {
    return this.idSalaire;
  }

  public void setIdSalaire(int idSalaire) {
    this.idSalaire = idSalaire;
  }

  public double getSalaire() {
    return this.salaire;
  }

  public void setSalaire(double salaire) {
    this.salaire = salaire;
  }
}
