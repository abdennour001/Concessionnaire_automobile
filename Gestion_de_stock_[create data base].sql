
-- Export de la structure de la base pour concession d'automobile

DROP DATABASE IF EXISTS `concession_automobile`;
CREATE DATABASE IF NOT EXISTS `concession_automobile`;
USE `concession_automobile`;

-- Export de la structure de la table concession d'automobile. fournisseur

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id_fournisseur` int AUTO_INCREMENT,
  `nom` varchar(30),
  `prenom` varchar(30),
  `ville` varchar(30),
  `email` varchar(50),
  `num_telephone` char(10),
  `nombre_offre` int DEFAULT 0,
  PRIMARY KEY (`id_fournisseur`)
);


-- Export de la structure de la table concession d'automobile. voiture
DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `id_voiture` int AUTO_INCREMENT,
  `id_fournisseur` int,
  `id_marque` int,
  `garantie` varchar(30),
  `date_entree` date,
  CONSTRAINT `pk_voiture` PRIMARY KEY (`id_voiture`, `id_fournisseur`, `id_marque`),
  FOREIGN KEY (`id_fournisseur`) REFERENCES `fournisseur` (`id_fournisseur`),
  FOREIGN KEY (`id_marque`) REFERENCES `marque` (`id_marque`)
);

-- Export de la structure de la table concession d'automobile. marque
DROP TABLE IF EXISTS `marque`;
CREATE TABLE IF NOT EXISTS `marque` (
  `id_marque` int AUTO_INCREMENT,
  `nom_marque` varchar(20),
  PRIMARY KEY (`id_marque`)
);

-- Export de la structure de la table concession d'automobile. type_voiture
DROP TABLE IF EXISTS `type_voiture`;
CREATE TABLE IF NOT EXISTS `type_voiture` (
  `id_type_voiture` int AUTO_INCREMENT,
  `nom_type` varchar(30),
  PRIMARY KEY (`id_type_voiture`)
);


-- Export de la structure de la table concession d'automobile. type_marque
DROP TABLE IF EXISTS `type_marque`;
CREATE TABLE IF NOT EXISTS `type_marque` (
  `id_type_voiture` int,
  `id_marque` int,
  CONSTRAINT `pk_type_marque` PRIMARY KEY (`id_type_voiture`, `id_marque`),
  FOREIGN KEY (`id_type_voiture`) REFERENCES `type_voiture` (`id_type_voiture`),
  FOREIGN KEY (`id_marque`) REFERENCES `marque` (`id_marque`)
);


-- Export de la structure de la table concession d'automobile. moteur
DROP TABLE IF EXISTS `moteur`;
CREATE TABLE IF NOT EXISTS `moteur` (
  `id_moteur` int AUTO_INCREMENT,
  `carburant` ENUM('Diesel', 'Essence', 'Electrique', 'Hybrides', 'Autre énergies'),
  `nom_moteur` varchar(20),
  `puissance` varchar(11),
  PRIMARY KEY (`id_moteur`)
);


-- Export de la structure de la table concession d'automobile. modele
DROP TABLE IF EXISTS `modele`;
CREATE TABLE IF NOT EXISTS `modele` (
  `id_modele` int AUTO_INCREMENT,
  `id_moteur` int,
  `id_type_voiture` int,
  `nom_modele` char(50),
  `image` varchar(300),
  `couleur` varchar(30),
  `numero` varchar(30),
  `prix` varchar(30),
  `km` varchar(30),
  `date_sortie` char(4),
  CONSTRAINT `pk_modele` PRIMARY KEY (`id_modele`, `id_moteur`, `id_type_voiture`),
  FOREIGN KEY (`id_moteur`) REFERENCES `moteur` (`id_moteur`),
  FOREIGN KEY (`id_type_voiture`) REFERENCES `type_voiture` (`id_type_voiture`)
);


-- Export de la structure de la table concession d'automobile. compte
DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id_compte` int AUTO_INCREMENT,
  `id_fournisseur` int,
  `nombre_de_vehicule` int,
  `password_compte` varchar(30),
  `date_debut` date,
  `date_fin` date,
  CONSTRAINT `pk_compte` PRIMARY KEY (`id_compte`, `id_fournisseur`),
  CONSTRAINT `id_fournisseur` FOREIGN KEY (`id_fournisseur`) REFERENCES `fournisseur` (`id_fournisseur`)
);
