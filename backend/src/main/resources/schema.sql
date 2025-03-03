CREATE TABLE User (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      nom VARCHAR(100) NOT NULL,
                      prenom VARCHAR(100) NOT NULL,
                      email VARCHAR(100) NOT NULL UNIQUE,
                      role VARCHAR(50) NOT NULL
);
CREATE TABLE Admin (
                       idAdmin BIGINT PRIMARY KEY,
                       motDePasseHash VARCHAR(255) NOT NULL,
                       FOREIGN KEY (idAdmin) REFERENCES User(id)
);
CREATE TABLE Candidat (
                          idCandidat BIGINT PRIMARY KEY,
                          telephone VARCHAR(20) NOT NULL,
                          partiPolitique VARCHAR(100),
                          FOREIGN KEY (idCandidat) REFERENCES User(id)
);
CREATE TABLE Electeur (
                          cin BIGINT PRIMARY KEY,
                          telephone VARCHAR(20) NOT NULL,
                          motDePasseHash VARCHAR(255) NOT NULL,
                          FOREIGN KEY (cin) REFERENCES User(id)
);
CREATE TABLE HistoriqueUpload (
                                  idHistorique INT AUTO_INCREMENT PRIMARY KEY,
                                  idAdmin BIGINT NOT NULL,
                                  dateUpload TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  fichier VARCHAR(255) NOT NULL,
                                  FOREIGN KEY (idAdmin) REFERENCES Admin(idAdmin)
);
CREATE TABLE Parrainage (
                            idParrainage INT AUTO_INCREMENT PRIMARY KEY,
                            cinElecteur BIGINT NOT NULL,
                            idCandidat BIGINT NOT NULL,
                            dateParrainage TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (cinElecteur) REFERENCES Electeur(cin),
                            FOREIGN KEY (idCandidat) REFERENCES Candidat(idCandidat)
);
CREATE TABLE PeriodeParrainage (
                                   idPeriode INT AUTO_INCREMENT PRIMARY KEY,
                                   dateDebut DATE NOT NULL,
                                   dateFin DATE NOT NULL
);