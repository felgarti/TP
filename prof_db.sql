-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 juin 2022 à 12:06
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `prof_db`
--
CREATE DATABASE IF NOT EXISTS `prof_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `prof_db`;

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `id_depart` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `departement`
--

INSERT INTO `departement` (`id_depart`, `nom`) VALUES
(1, 'physique'),
(3, 'informatique'),
(5, 'biologie');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `id_prof` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `cin` varchar(20) NOT NULL,
  `adresse` varchar(70) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(70) NOT NULL,
  `date_recrutement` date NOT NULL,
  `id_depart` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id_prof`, `nom`, `prenom`, `cin`, `adresse`, `telephone`, `email`, `date_recrutement`, `id_depart`) VALUES
(1, 'el garti ', 'fatima', 'test22', 'voici l adresse rue je ne sais pas  hehe', '0625668877', 'fatima@gmail.com', '2022-01-04', 3),
(2, 'argane ', 'hamza', 'test11', 'voici l adresse rue je ne sais toujours pas ', '0625658877', 'hamza@gmail.com', '2022-01-04', 1),
(3, 'chafiq', 'yousra', 'wa3360', 'bbbborgone ', '0633786595', 'yousra@gmail.com', '2021-09-21', 1),
(4, 'benrazki', 'sanae', 'lk5566', '2513254354djvjkshdku;hdv', '0566656565', 'sanae@email.com', '2015-05-02', 1),
(5, 'benr2.690581743481099', 'sanae', 'lk5566', '2513254354djvjkshdku;hdv', '0566656565', 'sanae@email.com', '2015-05-02', 1),
(6, 'benr0', 'sanae', 'lk5566', '2513254354djvjkshdku;hdv', '0566656565', 'sanae@email.com', '2015-05-02', 1),
(9, 'benr87.98089521347677', 'sanae', 'lk5566', '2513254354djvjkshdku;hdv', '0566656565', 'benr87.98089521347677@email.com', '2015-05-02', 1),
(10, 'benr97.73461286853954', 'sanae', 'lk5566', '2513254354djvjkshdku;hdv', '0566656565', 'benr97.73461286853954@email.com', '2015-05-02', 3),
(11, 'benr25.608619806714415', 'sanae', 'lk5566', '2513254354djvjkshdku;hdv', '0566656565', 'benr25.608619806714415@email.com', '2015-05-02', 3),
(12, 'benr53.98267837366005', 'sanae', 'lk5566', '2513254354djvjkshdku;hdv', '0566656565', 'benr53.98267837366005@email.com', '2015-05-02', 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`id_depart`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id_prof`),
  ADD KEY `FK_DEPART` (`id_depart`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `departement`
--
ALTER TABLE `departement`
  MODIFY `id_depart` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `id_prof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD CONSTRAINT `FK_DEPART` FOREIGN KEY (`id_depart`) REFERENCES `departement` (`id_depart`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
