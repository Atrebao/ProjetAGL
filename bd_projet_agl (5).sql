-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 14 fév. 2023 à 20:16
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bd_projet_agl`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `ID_EMPLOYE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) DEFAULT NULL,
  `PRENOM` varchar(30) DEFAULT NULL,
  `SEXE` varchar(30) DEFAULT NULL,
  `TELEPHONE` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `DOMICILE` varchar(30) DEFAULT NULL,
  `NOM_UTILISATEUR` varchar(30) DEFAULT NULL,
  `MDP` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_EMPLOYE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `ID_CLIENT` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) DEFAULT NULL,
  `PRENOM` varchar(30) DEFAULT NULL,
  `NUM_TELEPHONE` varchar(30) DEFAULT NULL,
  `DOMICILE` varchar(30) DEFAULT NULL,
  `CODE_RESERVATION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENT`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `ID_EMPLOYE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) DEFAULT NULL,
  `PRENOM` varchar(30) DEFAULT NULL,
  `SEXE` varchar(30) DEFAULT NULL,
  `TELEPHONE` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `DOMICILE` varchar(30) DEFAULT NULL,
  `NOM_UTILISATEUR` varchar(30) DEFAULT NULL,
  `MDP` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_EMPLOYE`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`ID_EMPLOYE`, `NOM`, `PRENOM`, `SEXE`, `TELEPHONE`, `EMAIL`, `DOMICILE`, `NOM_UTILISATEUR`, `MDP`) VALUES
(1, 'Kageyama', 'Ritsu', 'Masculin', '0102030405', 'kageyama@ritsugmail.com', 'Koweit', 'mob', 'mob123');

-- --------------------------------------------------------

--
-- Structure de la table `numero_depart`
--

DROP TABLE IF EXISTS `numero_depart`;
CREATE TABLE IF NOT EXISTS `numero_depart` (
  `id_numDepart` int(10) NOT NULL AUTO_INCREMENT,
  `numero` varchar(30) NOT NULL,
  PRIMARY KEY (`id_numDepart`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `numero_depart`
--

INSERT INTO `numero_depart` (`id_numDepart`, `numero`) VALUES
(1, '1er depart'),
(2, '2e depart'),
(3, '3e depart');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `NUM_RESERVATION` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EMPLOYE` int(11) NOT NULL,
  `NUMTRANSACTION` int(11) NOT NULL,
  `ID_CLIENT` int(11) NOT NULL,
  `DATE_DEPART` varchar(30) DEFAULT NULL,
  `NUM_DEPART` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `VILLE_DEPART` varchar(30) DEFAULT NULL,
  `VILLE_ARRIVEE` varchar(30) DEFAULT NULL,
  `Prix` int(11) NOT NULL,
  PRIMARY KEY (`NUM_RESERVATION`),
  KEY `FK_EFFECTUER` (`ID_CLIENT`),
  KEY `FK_ENREGISTRER` (`ID_EMPLOYE`),
  KEY `FK_LIER` (`NUMTRANSACTION`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `NUMTRANSACTION` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_TRANSACTION` varchar(30) DEFAULT NULL,
  `MONTANT` int(11) DEFAULT NULL,
  PRIMARY KEY (`NUMTRANSACTION`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `villes`
--

DROP TABLE IF EXISTS `villes`;
CREATE TABLE IF NOT EXISTS `villes` (
  `id_ville` int(10) NOT NULL AUTO_INCREMENT,
  `ville` varchar(30) NOT NULL,
  PRIMARY KEY (`id_ville`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `villes`
--

INSERT INTO `villes` (`id_ville`, `ville`) VALUES
(1, 'GUIGLO'),
(2, 'ABIDJAN'),
(3, 'DUEUKOUE');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
