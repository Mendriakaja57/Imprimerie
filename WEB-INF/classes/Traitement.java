package traitement;

import connect.*;
import emp.*;
import java.sql.*;
import login.login_Admin;
import login.login_Client;
import service.*;

public class Traitement {

  public Connection psqlConnected() throws Exception {
    Connexion con = new Connexion();
    return con.connex(
      "jdbc:postgresql://localhost:5432/imprimerie",
      "postgres",
      "366325"
    );
  }

  public Object[][] getAllClient(Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Object[][] obj = new Object[1][1];
    try {
      Statement countStat = con.createStatement();
      ResultSet count = countStat.executeQuery("select count(*) from client");

      Statement stat = con.createStatement();
      String sql = "select * from client";
      System.out.println(sql);
      ResultSet res = stat.executeQuery(sql);

      int col = res.getMetaData().getColumnCount();
      int n = 0;

      while (count.next()) {
        n = count.getInt(1);
      }

      obj = new Object[n][col];
      int j = 0;
      while (res.next()) {
        for (int i = 0; i < col; i++) {
          if (res.getObject(i + 1) != null) {
            obj[j][i] = res.getObject(i + 1);
          } else {
            obj[j][i] = 0;
          }
        }
        j++;
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }

    return obj;
  }

  public void inserToFacture(
    String table,
    String date,
    int idClient,
    double paye,
    Connection con
  ) throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    try {
      stat = con.createStatement();
      System.out.println(
        "insert into " +
        table +
        " values(nextval('idfacture'),'" +
        date +
        "'," +
        idClient +
        "," +
        paye +
        ")"
      );
      stat.executeUpdate(
        "insert into " +
        table +
        " values(nextval('idfacture'),'" +
        date +
        "'," +
        idClient +
        "," +
        paye +
        ")"
      );
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      con.rollback();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public double getPrixRemise(double remise, double prix) {
    double val = 0;
    val = prix - (prix * remise / 100);
    return val;
  }

  public Object[][] getAllFacture(Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Object[][] obj = new Object[1][1];
    try {
      Statement countStat = con.createStatement();
      ResultSet count = countStat.executeQuery("select count(*) from facture");

      Statement stat = con.createStatement();
      String sql = "select * from facture";
      System.out.println(sql);
      ResultSet res = stat.executeQuery(sql);

      int col = res.getMetaData().getColumnCount();
      int n = 0;

      while (count.next()) {
        n = count.getInt(1);
      }

      obj = new Object[n][col];
      int j = 0;
      while (res.next()) {
        for (int i = 0; i < col; i++) {
          if (res.getObject(i + 1) != null) {
            obj[j][i] = res.getObject(i + 1);
          } else {
            obj[j][i] = 0;
          }
        }
        j++;
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }

    return obj;
  }

  public Object[][] getServForFact(String idFacture, Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Object[][] obj = new Object[1][1];
    try {
      Statement countStat = con.createStatement();
      ResultSet count = countStat.executeQuery(
        "select count(*) from V_Facture where idFacture = '" + idFacture + "'"
      );

      Statement stat = con.createStatement();
      String sql =
        "select * from V_Facture where idFacture = '" + idFacture + "'";
      System.out.println(sql);
      ResultSet res = stat.executeQuery(sql);

      int col = res.getMetaData().getColumnCount();
      int n = 0;

      while (count.next()) {
        n = count.getInt(1);
      }

      obj = new Object[n][col];
      int j = 0;
      while (res.next()) {
        for (int i = 0; i < col; i++) {
          if (res.getObject(i + 1) != null) {
            obj[j][i] = res.getObject(i + 1);
          } else {
            obj[j][i] = 0;
          }
        }
        j++;
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }

    return obj;
  }

  public Object[][] getMont_Reste(String idFacture, Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Object[][] obj = new Object[1][1];
    try {
      Statement countStat = con.createStatement();
      ResultSet count = countStat.executeQuery(
        "select count(*) from montantTot join facture on facture.idfacture = montantTot.idfacture where facture.idFacture = '" +
        idFacture +
        "'"
      );

      Statement stat = con.createStatement();
      String sql =
        "select montantTot.idfacture,montantTot.date,montantTot.montantTot,facture.paye,(montantTot.montantTot-facture.paye)as reste from montantTot join facture on facture.idfacture = montantTot.idfacture where facture.idFacture = '" +
        idFacture +
        "'";
      System.out.println(sql);
      ResultSet res = stat.executeQuery(sql);

      int col = res.getMetaData().getColumnCount();
      int n = 0;

      while (count.next()) {
        n = count.getInt(1);
      }

      obj = new Object[n][col];
      int j = 0;
      while (res.next()) {
        for (int i = 0; i < col; i++) {
          if (res.getObject(i + 1) != null) {
            obj[j][i] = res.getObject(i + 1);
          } else {
            obj[j][i] = 0;
          }
        }
        j++;
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }

    return obj;
  }

  public Object[][] getPU(Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Object[][] obj = new Object[1][1];
    try {
      Statement countStat = con.createStatement();
      ResultSet count = countStat.executeQuery("select count(*) from pu");

      Statement stat = con.createStatement();
      String sql = "select * from pu";
      System.out.println(sql);
      ResultSet res = stat.executeQuery(sql);

      int col = res.getMetaData().getColumnCount();
      int n = 0;

      while (count.next()) {
        n = count.getInt(1);
      }

      obj = new Object[n][col];
      int j = 0;
      while (res.next()) {
        for (int i = 0; i < col; i++) {
          if (res.getObject(i + 1) != null) {
            obj[j][i] = res.getObject(i + 1);
          } else {
            obj[j][i] = 0;
          }
        }
        j++;
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }

    return obj;
  }

  public login_Client verifyLogClient(
    Connection con,
    String username,
    String password
  ) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    login_Client client = new login_Client();
    try {
      Statement stmt = con.createStatement();
      String sql =
        "select count(*) from client where username='" +
        username +
        "' and motdepasse='" +
        password +
        "'";
      ResultSet rSet = stmt.executeQuery(sql);
      int ind = 0;
      while (rSet.next()) {
        ind = rSet.getInt(1);
      }
      if (ind == 0) {
        client = null;
      } else {
        Statement stmt2 = con.createStatement();
        String sql2 =
          "select * from client where username='" +
          username +
          "' and motdepasse='" +
          password +
          "'";
        ResultSet rSet2 = stmt2.executeQuery(sql2);
        while (rSet2.next()) {
          client =
            new login_Client(
              rSet2.getInt(1),
              rSet2.getString(2),
              rSet2.getString(3)
            );
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
    return client;
  }

  public login_Admin verifyLogAdmin(
    Connection con,
    String username,
    String password
  ) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    login_Admin admin = new login_Admin();
    try {
      Statement stmt = con.createStatement();
      String sql =
        "select count(*) from admins where username='" +
        username +
        "' and motdepasse='" +
        password +
        "'";
      ResultSet rSet = stmt.executeQuery(sql);
      int ind = 0;
      while (rSet.next()) {
        ind = rSet.getInt(1);
      }
      if (ind == 0) {
        admin = null;
      } else {
        Statement stmt2 = con.createStatement();
        String sql2 =
          "select * from admins where username='" +
          username +
          "' and motdepasse='" +
          password +
          "'";
        ResultSet rSet2 = stmt2.executeQuery(sql2);
        while (rSet2.next()) {
          admin =
            new login_Admin(
              rSet2.getInt(1),
              rSet2.getString(2),
              rSet2.getString(3)
            );
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
    return admin;
  }

  public double getPrixVente(double prix) {
    double val = 0;
    val = prix + getMarge(prix);
    return val;
  }

  public double getMarge(double prix) {
    double val = 0;
    val = prix * getPercent(prix);
    return val;
  }

  public double getPercent(double prix) {
    double val = 0;
    if (prix >= 1000 && prix < 5000) {
      val = 0.3;
    } else if (prix >= 5000 && prix < 8000) {
      val = 0.25;
    } else if (prix >= 8000 && prix < 10000) {
      val = 0.20;
    } else if (prix >= 10000 && prix < 13000) {
      val = 0.15;
    } else if (prix >= 13000 && prix < 15000) {
      val = 0.10;
    } else if (prix >= 15000) {
      val = 0.05;
    }
    return val;
  }

  public double getSalParService(
    double TpsService1,
    double salMensuel1,
    double TpsService2,
    double salMensuel2,
    double TpsService3,
    double salMensuel3
  ) {
    double val = 0;
    val =
      (TpsService1 * salMensuel1 / 720) +
      (TpsService2 * salMensuel2 / 720) +
      (TpsService3 * salMensuel3 / 720);
    return val;
  }

  public Commande[] getAllCommandeClient(Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Commande[] commande = new Commande[1];
    try {
      Statement stmt = con.createStatement();
      String sql = "select count(*) from commande";
      ResultSet rSet = stmt.executeQuery(sql);
      int ind = 0;
      while (rSet.next()) {
        ind = rSet.getInt(1);
      }
      if (ind == 0) {
        commande = null;
      } else {
        Statement stmt2 = con.createStatement();
        String sql2 = "select * from commande";
        ResultSet rSet2 = stmt2.executeQuery(sql2);
        commande = new Commande[ind];
        int i = 0;
        while (rSet2.next()) {
          commande[i] =
            new Commande(
              rSet2.getInt(1),
              rSet2.getInt(2),
              rSet2.getInt(3),
              rSet2.getInt(4),
              rSet2.getInt(5),
              rSet2.getInt(6),
              rSet2.getInt(7)
            );
          i++;
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
    return commande;
  }

  public Devis[] getAllDevisAdmin(Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Devis[] devis = new Devis[1];
    try {
      Statement stmt = con.createStatement();
      String sql = "select count(*) from devis";
      ResultSet rSet = stmt.executeQuery(sql);
      int ind = 0;
      while (rSet.next()) {
        ind = rSet.getInt(1);
      }
      if (ind == 0) {
        devis = null;
      } else {
        Statement stmt2 = con.createStatement();
        String sql2 = "select * from devis";
        ResultSet rSet2 = stmt2.executeQuery(sql2);
        devis = new Devis[ind];
        int i = 0;
        while (rSet2.next()) {
          devis[i] =
            new Devis(
              rSet2.getInt(1),
              rSet2.getDouble(2),
              rSet2.getInt(3),
              rSet2.getInt(4)
            );
          i++;
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
    return devis;
  }

  public Produits[] getAllProduits(Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Produits[] produits = new Produits[1];
    try {
      Statement stmt = con.createStatement();
      String sql = "select count(*) from produits";
      ResultSet rSet = stmt.executeQuery(sql);
      int ind = 0;
      while (rSet.next()) {
        ind = rSet.getInt(1);
      }
      if (ind == 0) {
        produits = null;
      } else {
        Statement stmt2 = con.createStatement();
        String sql2 = "select * from produits";
        ResultSet rSet2 = stmt2.executeQuery(sql2);
        produits = new Produits[ind];
        int i = 0;
        while (rSet2.next()) {
          produits[i] =
            new Produits(rSet2.getInt(1), rSet2.getString(2), rSet2.getInt(3));
          i++;
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
    return produits;
  }

  public Employe[] getAllEmploye(Connection con) {
    boolean open = false;
    if (con == null) {
      try {
        con = psqlConnected();
        open = true;
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    Employe[] employe = new Employe[1];
    try {
      Statement stmt = con.createStatement();
      String sql = "select count(*) from employe";
      ResultSet rSet = stmt.executeQuery(sql);
      int ind = 0;
      while (rSet.next()) {
        ind = rSet.getInt(1);
      }
      if (ind == 0) {
        employe = null;
      } else {
        Statement stmt2 = con.createStatement();
        String sql2 = "select * from employe";
        ResultSet rSet2 = stmt2.executeQuery(sql2);
        employe = new Employe[ind];
        int i = 0;
        while (rSet2.next()) {
          employe[i] =
            new Employe(
              rSet2.getString(1),
              rSet2.getString(2),
              rSet2.getString(3),
              rSet2.getDate(4),
              rSet2.getString(5),
              rSet2.getString(6),
              rSet2.getString(7),
              rSet2.getInt(8)
            );
          i++;
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      if (open == true) {
        try {
          con.close();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
    return employe;
  }

  public void insertionDevis(String[] tab, Connection con) throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    try {
      inserToTable("Devis", tab, con);
      con.commit();
    } catch (Exception e) {
      // TODO: handle exception
      con.rollback();
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public void insertionCommandeAdmin(String[] tab, Connection con)
    throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    try {
      inserToTable("Commande", tab, con);
      con.commit();
    } catch (Exception e) {
      // TODO: handle exception
      con.rollback();
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public void insertionEmp(String[] tab, Connection con) throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    try {
      inserToTable("Employe", tab, con);
      con.commit();
    } catch (Exception e) {
      // TODO: handle exception
      con.rollback();
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public void createSeq(String seqName, int incr, int min, Connection con)
    throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    try {
      stat = con.createStatement();
      stat.executeUpdate(
        "create sequence " +
        seqName +
        " increment by " +
        incr +
        " start with " +
        min +
        " minvalue 1"
      );

      con.commit();
    } catch (Exception e) {
      // TODO: handle exception
      con.rollback();
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public void delete(String table, String col, String ind, Connection con)
    throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    try {
      stat = con.createStatement();
      stat.executeUpdate(
        "delete from " + table + " where " + col + " = '" + ind + "'"
      );

      con.commit();
    } catch (Exception e) {
      // TODO: handle exception
      con.rollback();
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public void update(
    String table,
    String value,
    String col,
    String col1,
    String ind,
    Connection con
  ) throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    try {
      stat = con.createStatement();
      stat.executeUpdate(
        "update " +
        table +
        " set " +
        col +
        " = " +
        value +
        " where " +
        col1 +
        " = '" +
        ind +
        "'"
      );

      con.commit();
    } catch (Exception e) {
      // TODO: handle exception
      con.rollback();
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public void inserToTable(String table, String[] value, Connection con)
    throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    try {
      StringBuilder str = new StringBuilder();
      String[] valeur = new String[value.length];
      for (int i = 0; i < valeur.length - 1; i++) {
        valeur[i] = "'" + value[i] + "',";
        str = str.append(valeur[i]);
      }
      valeur[value.length - 1] = "'" + value[valeur.length - 1] + "'";
      str.append(valeur[value.length - 1]);
      System.out.println("string" + str.toString());

      stat = con.createStatement();
      System.out.println("insert into " + table + " values(" + str + ")");
      stat.executeUpdate("insert into " + table + " values(" + str + ")");
      con.commit();
    } catch (Exception e) {
      // TODO: handle exception
      con.rollback();
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public void select(String table, String att, Connection con)
    throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    Object[][] obj = null;
    try {
      stat = con.createStatement();
      ResultSet rSet = stat.executeQuery("select count(*) from " + table);
      int row = 0;
      while (rSet.next()) {
        row = rSet.getInt(1);
      }

      ResultSet rSet2 = rsltset(table, att, con);
      ResultSetMetaData rSetMetaData = rSet2.getMetaData();
      int col = rSetMetaData.getColumnCount();
      obj = new Object[row][col];
      int j = 0;
      while (rSet2.next()) {
        for (int i = 0; i < col; i++) {
          if (rSet2.getObject(i + 1) == null) {
            obj[j][i] = 0;
            //  System.out.println("null");
          } else {
            obj[j][i] = rSet2.getObject(i + 1);
          }
        }
        j++;
      }
      // System.out.println(obj[0][0]);
      for (int l = 0; l < row; l++) {
        for (int m = 0; m < col; m++) {
          System.out.println(obj[l][m].toString());
        }
      }
      rSet.close();
      rSet2.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
  }

  public Object[][] result_tObjects(String table, Connection con)
    throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    Object[][] obj = null;
    try {
      stat = con.createStatement();
      ResultSet rSet = stat.executeQuery("select count(*) from " + table);
      int row = 0;
      while (rSet.next()) {
        row = rSet.getInt(1);
      }

      ResultSet rSet2 = rsltset(table, "*", con);
      ResultSetMetaData rSetMetaData = rSet2.getMetaData();
      int col = rSetMetaData.getColumnCount();
      obj = new Object[row][col];
      int j = 0;
      while (rSet2.next()) {
        for (int i = 0; i < col; i++) {
          if (rSet2.getObject(i + 1) == null) {
            obj[j][i] = 0;
            //  System.out.println("null");
          } else {
            obj[j][i] = rSet2.getObject(i + 1);
          }
        }
        j++;
      }
      rSet.close();
      rSet2.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
    return obj;
  }

  public ResultSet rsltset(String table, String att, Connection con)
    throws Exception {
    boolean open = true;
    if (con == null) {
      con = psqlConnected();
    } else {
      open = false;
    }
    Statement stat = null;
    ResultSet rSet = null;
    try {
      stat = con.createStatement();
      rSet = stat.executeQuery("select " + att + " from " + table);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    } finally {
      if (open == true) {
        con.close();
      }
    }
    return rSet;
  }
}
