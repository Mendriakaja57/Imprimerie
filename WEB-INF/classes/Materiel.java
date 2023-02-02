package materiel;

public class Materiel {

  int idMateriel;
  String nom;
  double prix;

  public Materiel(int idMateriel, String nom, double prix) {
    this.idMateriel = idMateriel;
    this.nom = nom;
    this.prix = prix;
  }

  // public double getPrixVente() {
  //   double val = 0;
  //   val = this.prix + getMarge(this.prix);
  //   return val;
  // }

  // public double getMarge(double prix) {
  //   double val = 0;
  //   val = this.prix * getPercent(this.prix);
  //   return val;
  // }

  // public double getPercent() {
  //   double val = 0;
  //   if (this.prix >= 1000 && this.prix < 5000) {
  //     val = 0.3;
  //   } else if (this.prix >= 5000 && this.prix < 8000) {
  //     val = 0.25;
  //   } else if (this.prix >= 8000 && this.prix < 10000) {
  //     val = 0.20;
  //   } else if (this.prix >= 10000 && this.prix < 13000) {
  //     val = 0.15;
  //   } else if (this.prix >= 13000 && this.prix < 15000) {
  //     val = 0.10;
  //   } else if (this.prix >= 15000) {
  //     val = 0.05;
  //   }
  //   return val;
  // }

  public int getIdMateriel() {
    return this.idMateriel;
  }

  public void setIdMateriel(int idMateriel) {
    this.idMateriel = idMateriel;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public double getPrix() {
    return this.prix;
  }

  public void setPrix(double prix) {
    this.prix = prix;
  }
}
