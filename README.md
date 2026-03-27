📦 Gestion d'Inventaire - Application Jakarta EE
---
📋 Description du Projet

L'application Gestion d'Inventaire est une application web développée dans le cadre du cours d'Architecture Répartie. Elle permet de gérer efficacement les utilisateurs et les produits d'une entreprise via une interface web intuitive.

Ce projet illustre l'implémentation complète de l'architecture MVC (Modèle-Vue-Contrôleur) avec les technologies Jakarta EE, intégrant un DAO générique pour la réutilisation du code et Hibernate comme framework ORM.





---
✨ Fonctionnalités
Gestion des Utilisateurs

➕ Ajouter	:Création d'un nouvel utilisateur avec prénom, nom, email et mot de passe
✏️ Modifier : Édition des informations d'un utilisateur existant
❌ Supprimer :	Suppression d'un utilisateur avec confirmation
📋 Lister :	Affichage de tous les utilisateurs dans un tableau



Gestion des Produits

➕ Ajouter :	Création d'un produit avec nom, description, prix, stock et SKU
✏️ Modifier	: Édition des informations d'un produit
❌ Supprimer :	Suppression d'un produit avec confirmation
📋 Lister	: Affichage de tous les produits dans un tableau
🔍 Rechercher : 	Recherche de produits par mot-clé (nom ou description)


---

🚀 Installation et Exécution
Prérequis

    Java JDK 11 ou supérieur

    Apache Maven 3.6+

    Tomcat 10.1+ (ou utilisation du plugin Jetty intégré)

Étapes d'installation

    Cloner le projet

bash

git clone https://github.com/votre-repo/inventory-management.git
cd inventory-management

    Compiler et générer le WAR

bash

mvn clean package

    Déployer sur Tomcat

bash

# Copier le WAR dans webapps
copy target\inventory-management.war %CATALINA_HOME%\webapps\

# Démarrer Tomcat
%CATALINA_HOME%\bin\catalina.bat run

    Accéder à l'application

text

http://localhost:8888/inventory-management/

---
📸 Captures d'écran
1. Page d'Accueil

<img width="824" height="664" alt="accueil " src="https://github.com/user-attachments/assets/e75c18df-6505-46ab-afa2-6d7ed8a58560" />


3. Ajout d'un Utilisateur

<img width="846" height="559" alt="add-user" src="https://github.com/user-attachments/assets/66c566d6-c8ed-461a-adb1-cba5b298b73e" />


Formulaire d'ajout d'un nouvel utilisateur avec validation des champs obligatoires.

5. Liste des Produits

<img width="847" height="383" alt="list-prod" src="https://github.com/user-attachments/assets/718a3c65-3f02-4ee1-a4a4-94431dbe87e9" />


Tableau des produits avec barre de recherche et actions Modifier/Supprimer.
6. Ajout d'un Produit

<img width="824" height="662" alt="add-prod" src="https://github.com/user-attachments/assets/ae443193-fb0a-47f4-b001-73819fef4334" />


Formulaire d'ajout de produit avec champs pour le prix, la quantité et le SKU unique.
7. Modification d'un Produit

<img width="832" height="603" alt="update-prod" src="https://github.com/user-attachments/assets/caf70fcf-3057-4c97-ace5-94b3a3883255" />


Formulaire de modification de produit avec toutes les informations pré-chargées.

---

👥 Auteurs

Asma Bajadda	     Développeuse Full Stack


