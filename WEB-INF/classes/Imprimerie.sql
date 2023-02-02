CREATE TABLE Salaire (
    idSalaire SERIAL NOT NULL, 
    Salaire varchar(20) NOT NULL, 
    PRIMARY KEY (idSalaire)
);

CREATE TABLE Specialite(
    idSpecialite SERIAL NOT NULL,
    Specialite varchar(20) NOT NULL,
    PRIMARY KEY (idSpecialite)
);

CREATE TABLE Employe (
    idEmploye SERIAL NOT NULL, 
    Nom varchar(20) NOT NULL, 
    Prenom varchar(20) NOT NULL, 
    DateNaissance date NOT NULL, 
    Adresse varchar(20) NOT NULL, 
    Genre varchar(20) NOT NULL, 
    Telephone varchar(20) NOT NULL, 
    idSalaire int4 NOT NULL, 
    idSpecialite int,
    PRIMARY KEY (idEmploye)
);

CREATE TABLE EmployeSpecialite(
    idEmploye int4 NOT NULL,
    idSpecialite int4 NOT NULL
);

CREATE TABLE Admins (
    idAdmin SERIAL NOT NULL, 
    username varchar(50) NOT NULL, 
    motdepasse varchar(20) NOT NULL, 
    PRIMARY KEY (idAdmin)
);

CREATE TABLE Categorie (
    idCategorie SERIAL NOT NULL, 
    Categorie varchar(10) NOT NULL, 
    PRIMARY KEY (idCategorie)
);

CREATE TABLE Produits (
    idProduit SERIAL NOT NULL, 
    Nom varchar(20) NOT NULL, 
    idCategorie int4 NOT NULL, 
    PRIMARY KEY (idProduit)
);

CREATE TABLE Client (
    idClient SERIAL NOT NULL, 
    username varchar(50) NOT NULL, 
    motdepasse varchar(20) NOT NULL, 
    PRIMARY KEY (idClient)
);

CREATE TABLE Devis (
    idDevis SERIAL NOT NULL, 
    Montant_total decimal NOT NULL, 
    idClient int4 NOT NULL, 
    PRIMARY KEY (idDevis)
);

CREATE TABLE GrammagePapier (
    idGram SERIAL NOT NULL, 
    grammage decimal NOT NULL, 
    prix decimal NOT NULL, 
    PRIMARY KEY (idGram)
);

CREATE TABLE Jirama (
    idJirama SERIAL NOT NULL, 
    dates date NOT NULL, 
    total decimal NOT NULL,
    PRIMARY KEY (idJirama)
);

CREATE TABLE Depense (
    idDepense SERIAL NOT NULL, 
    idEmploye int4 NOT NULL, 
    Dates date NOT NULL, 
    idType int4 NOT NULL, 
    idJirama int,
    PRIMARY KEY (idDepense)
);

CREATE TABLE Format (
    idFormat SERIAL NOT NULL, 
    format varchar(20) NOT NULL, 
    prix decimal NOT NULL, 
    PRIMARY KEY (idFormat)
);

CREATE TABLE ModeImpression (
    idMode SERIAL NOT NULL, 
    Mode varchar(20) NOT NULL, 
    prix decimal NOT NULL, 
    PRIMARY KEY (idMode)
);

CREATE TABLE TypePapier (
    idType SERIAL NOT NULL, 
    types varchar(20) NOT NULL, 
    prix decimal NOT NULL, 
    PRIMARY KEY (idType)
);


CREATE TABLE Commande (
    idCommande SERIAL NOT NULL, 
    Quantite int,
    idProduit int4 NOT NULL, 
    idFormat int4 NOT NULL, 
    idType int4 NOT NULL, 
    idGram int4 NOT NULL, 
    idMode int4 NOT NULL, 
    idDevis int4 NOT NULL, 
    PRIMARY KEY (idCommande)
);

CREATE TABLE Materiel(
    idMateriel SERIAL,
    nom VARCHAR,
    prix FLOAT8
);

CREATE TABLE Facture(
    idFacture int Primary key,
    date DATE,
    idClient INT,
    paye FLOAT8,
    foreign key (idClient) REFERENCES Client(idClient)
);
CREATE SEQUENCE idfacture START WITH 1 INCREMENT BY 1 MINVALUE 1;

CREATE TABLE Service(
    idService int primary key,
    nomService varchar,
    montantService FLOAT8,
    quantite FLOAT8
);
CREATE SEQUENCE idservice START WITH 1 INCREMENT BY 1 MINVALUE 1;


CREATE TABLE DetailFacture(
    idFacture int,
    idService int,
    foreign key (idFacture) REFERENCES Facture(idFacture),
    foreign key (idService) REFERENCES Service(idService)
);

ALTER TABLE Produits ADD CONSTRAINT FKProduits731650 FOREIGN KEY (idCategorie) REFERENCES Categorie (idCategorie);
ALTER TABLE Commande ADD CONSTRAINT FKCommande632643 FOREIGN KEY (idFormat) REFERENCES Format (idFormat);
ALTER TABLE Commande ADD CONSTRAINT FKCommande498867 FOREIGN KEY (idMode) REFERENCES ModeImpression (idMode);
ALTER TABLE Commande ADD CONSTRAINT FKCommande562073 FOREIGN KEY (idGram) REFERENCES GrammagePapier (idGram);
ALTER TABLE Commande ADD CONSTRAINT FKCommande495034 FOREIGN KEY (idProduit) REFERENCES Produits (idProduit);
ALTER TABLE Employe ADD CONSTRAINT FKEmploye422676 FOREIGN KEY (idSalaire) REFERENCES Salaire (idSalaire);
ALTER TABLE Depense ADD CONSTRAINT FKDepense987443 FOREIGN KEY (idEmploye) REFERENCES Employe (idEmploye);
ALTER TABLE Devis ADD CONSTRAINT FKDevis616305 FOREIGN KEY (idClient) REFERENCES Client (idClient);
ALTER TABLE Commande ADD CONSTRAINT FKCommande42535 FOREIGN KEY (idDevis) REFERENCES Devis (idDevis);
ALTER TABLE Depense ADD CONSTRAINT FKDepense139172 FOREIGN KEY (idType) REFERENCES TypePapier (idType);
ALTER TABLE Depense ADD CONSTRAINT FKDepense858626 FOREIGN KEY (idJirama) REFERENCES Jirama (idJirama);
ALTER TABLE Commande ADD CONSTRAINT FKCommande465537 FOREIGN KEY (idType) REFERENCES TypePapier (idType);
ALTER TABLE EmployeSpecialite ADD FOREIGN KEY (idEmploye) REFERENCES Employe (idEmploye);
ALTER TABLE EmployeSpecialite ADD FOREIGN KEY (idSpecialite) REFERENCES Specialite (idSpecialite);

INSERT INTO DetailFacture values('1','1');
INSERT INTO DetailFacture values('1','2');
INSERT INTO DetailFacture values('1','3');
INSERT INTO DetailFacture values('2','4');
INSERT INTO DetailFacture values('2','5');
INSERT INTO DetailFacture values('3','6');
INSERT INTO DetailFacture values('3','7');
INSERT INTO DetailFacture values('3','8');
INSERT INTO DetailFacture values('3','9');
INSERT INTO DetailFacture values('2','10');
INSERT INTO DetailFacture values('2','11');
INSERT INTO DetailFacture values('1','12');





INSERT INTO Facture values(nextval('idfacture'),current_timestamp,'1','3000');
INSERT INTO Facture values(nextval('idfacture'),current_timestamp,'2','3000');
INSERT INTO Facture values(nextval('idfacture'),current_timestamp,'3','3000');
INSERT INTO Facture values(nextval('idfacture'),current_timestamp,'3','3000');
INSERT INTO Facture values(nextval('idfacture'),current_timestamp,'1','3000');

INSERT INTO Service values(nextval('idservice'),'Encre','6000','5');
INSERT INTO Service values(nextval('idservice'),'Photocopie','500','50');
INSERT INTO Service values(nextval('idservice'),'Impression','1000','9');
INSERT INTO Service values(nextval('idservice'),'Reliure','2000','2');
INSERT INTO Service values(nextval('idservice'),'Plastification','3000','2');
INSERT INTO Service values(nextval('idservice'),'Plastification','3000','16');
INSERT INTO Service values(nextval('idservice'),'Impression','1000','100');
INSERT INTO Service values(nextval('idservice'),'Photocopie','500','53');
INSERT INTO Service values(nextval('idservice'),'Encre','6000','7');
INSERT INTO Service values(nextval('idservice'),'Papier','1000','250');
INSERT INTO Service values(nextval('idservice'),'Reliure','2000','1');
INSERT INTO Service values(nextval('idservice'),'Papier','1000','7');

INSERT INTO Salaire(Salaire) values('10000');
INSERT INTO Salaire(Salaire) values('30000');
INSERT INTO Salaire(Salaire) values('70000');

INSERT INTO Employe(Nom,Prenom,DateNaissance,Adresse,Genre,Telephone,idSalaire) VALUES('ANDRIATAHIANA','Joide','2000-12-05','Avaradrano','Masculin','0321578945',1);
INSERT INTO Employe(Nom,Prenom,DateNaissance,Adresse,Genre,Telephone,idSalaire) VALUES('NOMENJANAHARY','Cerafin','2001-03-25','Andraharo','Masculin','0326598716',2);
INSERT INTO Employe(Nom,Prenom,DateNaissance,Adresse,Genre,Telephone,idSalaire) VALUES('RAZANABOLOLONA','Cassy','2000-05-14','Antanimena','Feminin','0323402198',3);

INSERT INTO Specialite(Specialite) VALUES('Machinistes');
INSERT INTO Specialite(Specialite) VALUES('Designer');
INSERT INTO Specialite(Specialite) VALUES('Decoupeur');

INSERT INTO EmployeSpecialite(idEmploye,idSpecialite) VALUES(1,1);
INSERT INTO EmployeSpecialite(idEmploye,idSpecialite) VALUES(2,2);
INSERT INTO EmployeSpecialite(idEmploye,idSpecialite) VALUES(3,3);

INSERT INTO Admins(username,motdepasse) VALUES('rova','rova');
INSERT INTO Admins(username,motdepasse) VALUES('melky','melky');

INSERT INTO Categorie(Categorie) VALUES('Publicite');
INSERT INTO Categorie(Categorie) VALUES('Papeterie');
INSERT INTO Categorie(Categorie) VALUES('Carterie');
INSERT INTO Categorie(Categorie) VALUES('Adhesif');

INSERT INTO Produits(Nom,idCategorie) VALUES('Affiche','1');
INSERT INTO Produits(Nom,idCategorie) VALUES('Carte de visite','2');
INSERT INTO Produits(Nom,idCategorie) VALUES('Classeurs','3');
INSERT INTO Produits(Nom,idCategorie) VALUES('Flyers','4');

INSERT INTO Client(username,motdepasse) VALUES('Nomentsoa','nomentsoa');
INSERT INTO Client(username,motdepasse) VALUES('Mendrika','mendrika');
INSERT INTO Client(username,motdepasse) VALUES('Paul','paul');

INSERT INTO Devis(Montant_total,idClient) VALUES(5000,1);
INSERT INTO Devis(Montant_total,idClient) VALUES(7500,2);
INSERT INTO Devis(Montant_total,idClient) VALUES(1500,3);

INSERT INTO GrammagePapier(grammage,prix) VALUES('50','500');
INSERT INTO GrammagePapier(grammage,prix) VALUES('75','700');
INSERT INTO GrammagePapier(grammage,prix) VALUES('100','1000');

INSERT INTO Jirama(dates,total) VALUES('2022-11-07','35000');
INSERT INTO Jirama(dates,total) VALUES('2022-12-09','30000');
INSERT INTO Jirama(dates,total) VALUES('2023-01-06','55000');

INSERT INTO TypePapier(types,prix) VALUES('Velin','1500');
INSERT INTO TypePapier(types,prix) VALUES('Couche brillant','4000');
INSERT INTO TypePapier(types,prix) VALUES('Pellure','2500');
INSERT INTO TypePapier(types,prix) VALUES('Couche matte','3500');
INSERT INTO TypePapier(types,prix) VALUES('Velure','1500');

INSERT INTO Depense(idEmploye,Dates,idType,idJirama) VALUES(1,'2022-11-07',1,1);
INSERT INTO Depense(idEmploye,Dates,idType,idJirama) VALUES(2,'2022-12-13',2,2);
INSERT INTO Depense(idEmploye,Dates,idType,idJirama) VALUES(3,'2023-01-10',3,3);
INSERT INTO Depense(idEmploye,Dates,idType,idJirama) VALUES(1,'2023-01-01',2,2);
INSERT INTO Depense(idEmploye,Dates,idType,idJirama) VALUES(3,'2022-12-18',2,1);

INSERT INTO Format(format,prix) VALUES('A4','6000');
INSERT INTO Format(format,prix) VALUES('A5','5000');
INSERT INTO Format(format,prix) VALUES('A6','4000');
INSERT INTO Format(format,prix) VALUES('A7','3000');

INSERT INTO ModeImpression(Mode,prix) VALUES('Recto','1000');
INSERT INTO ModeImpression(Mode,prix) VALUES('Recto-verso','2000');

INSERT INTO Commande(Quantite,idProduit,idFormat,idType,idGram,idMode,idDevis) VALUES(12,1,1,1,1,1,1);
INSERT INTO Commande(Quantite,idProduit,idFormat,idType,idGram,idMode,idDevis) VALUES(25,2,2,2,2,2,2);
INSERT INTO Commande(Quantite,idProduit,idFormat,idType,idGram,idMode,idDevis) VALUES(7,3,3,3,3,1,3);

INSERT INTO Materiel VALUES(default,'Encre','5000');
INSERT INTO Materiel VALUES(default,'Papier','1000');


create view v_commande as select Commande.Quantite,Produits.Nom,Format.format,(Format.prix) as formatprix,(TypePapier.types) as papierType,(TypePapier.prix) as papier_prix,GrammagePapier.grammage,(GrammagePapier.prix) as grammage_prix,ModeImpression.Mode,(ModeImpression.prix) as impression_prix,Devis.Montant_total from Commande 
join Produits on Commande.idProduit=Produits.idProduit
join Format on Commande.idFormat=Format.idFormat
join TypePapier on Commande.idType=TypePapier.idType
join GrammagePapier on Commande.idGram=GrammagePapier.idGram
join ModeImpression on Commande.idMode=ModeImpression.idMode
join Devis on Commande.idDevis=Devis.idDevis;

create view v_depense as select Employe.Nom,Salaire.Salaire,(TypePapier.types) as papierType,(TypePapier.prix) as papier_prix,(Jirama.dates) as dateJirama,(Jirama.total) as TotalJirama from Depense 
join Employe on Depense.idEmploye=Employe.idEmploye
join Salaire on Employe.idSalaire=Salaire.idSalaire
join TypePapier on Depense.idType=TypePapier.idType
join Jirama on Depense.idJirama=Jirama.idJirama;

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Liantsoa
 * Created: 12 janv. 2023
 */

alter table commande add column quantite int;
alter table commande drop column iddevis;
alter table devis add column idCommande int4;
alter table devis drop column quantite;

update commande set quantite = 5 where idcommande = 1;

create view pu as select Commande.idCommande as id,(format.prix+TypePapier.prix+ GrammagePapier.prix+ ModeImpression.prix) as montant from commande 
    join format on format.idformat = commande.idformat
    join TypePapier on TypePapier.idtype = commande.idtype
    join GrammagePapier on GrammagePapier.idgram = commande.idgram
    join ModeImpression on ModeImpression.idmode = commande.idmode
    group by Commande.idCommande, format.prix, TypePapier.prix, GrammagePapier.prix, ModeImpression.prix;

create view montantTot as select detailfacture.idfacture,facture.date,sum(service.montantservice*service.quantite) as montantTot from detailfacture
    join facture on facture.idfacture = detailfacture.idfacture
    join service on service.idservice = detailfacture.idservice
    group by detailfacture.idfacture,facture.date;

select montantTot.idfacture,montantTot.date,montantTot.montantTot,facture.paye,(montantTot.montantTot-facture.paye)as reste from montantTot
    join facture on facture.idfacture = montantTot.idfacture
    where facture.idFacture = '1';

create view V_Facture as select detailfacture.idfacture,detailfacture.idservice,facture.date,facture.paye,service.nomservice,service.montantservice,service.quantite,(service.montantservice*service.quantite) as qteTot from detailfacture
    join facture on facture.idfacture = detailfacture.idfacture
    join service on service.idservice = detailfacture.idservice
    group by detailfacture.idfacture,detailfacture.idservice,facture.date,facture.paye,service.nomservice,service.montantservice,service.quantite order by detailfacture.idFacture;
