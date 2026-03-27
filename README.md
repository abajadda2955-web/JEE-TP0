📦 Gestion d'Inventaire - Application Jakarta EE
---
📋 Description du Projet

L'application Gestion d'Inventaire est une application web développée dans le cadre du cours d'Architecture Répartie. Elle permet de gérer efficacement les utilisateurs et les produits d'une entreprise via une interface web intuitive.

Ce projet illustre l'implémentation complète de l'architecture MVC (Modèle-Vue-Contrôleur) avec les technologies Jakarta EE, intégrant un DAO générique pour la réutilisation du code et Hibernate comme framework ORM.

---
🏗️ Architecture du Projet
Structure MVC
text

┌─────────────────────────────────────────────────────────────┐
│                     ARCHITECTURE MVC                        │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌──────────────┐    ┌──────────────┐    ┌──────────────┐  │
│  │   MODÈLE     │    │    VUE       │    │ CONTRÔLEUR   │  │
│  │              │    │              │    │              │  │
│  │ • User       │    │ • JSP        │    │ • Servlets   │  │
│  │ • Product    │◄──►│ • JSTL       │◄──►│ • @WebServlet│  │
│  │ • DAO        │    │ • Bootstrap  │    │              │  │
│  └──────────────┘    └──────────────┘    └──────────────┘  │
│         │                  │                   │           │
│         └──────────────────┴───────────────────┘           │
│                          │                                 │
│                   ┌───────▼───────┐                        │
│                   │   Hibernate   │                        │
│                   │   (ORM)       │                        │
│                   └───────┬───────┘                        │
│                           │                                │
│                   ┌───────▼───────┐                        │
│                   │  Base de      │                        │
│                   │  Données H2   │                        │
│                   └───────────────┘                        │
└─────────────────────────────────────────────────────────────┘


---
Organisation des packages
text

inventory-management/
├── src/main/java/com/example/
│   ├── controller/           # Servlets (Contrôleurs)
│   │   ├── UserListServlet.java
│   │   ├── UserFormServlet.java
│   │   ├── UserCreateServlet.java
│   │   ├── UserUpdateServlet.java
│   │   ├── UserDeleteServlet.java
│   │   ├── ProductListServlet.java
│   │   ├── ProductFormServlet.java
│   │   ├── ProductCreateServlet.java
│   │   ├── ProductUpdateServlet.java
│   │   └── ProductDeleteServlet.java
│   │
│   ├── dao/                   # Accès aux données
│   │   ├── GenericDAO.java     # Interface générique
│   │   ├── GenericDAOImpl.java # Implémentation générique
│   │   ├── UserDAO.java
│   │   └── ProductDAO.java
│   │
│   ├── model/                 # Entités (Modèle)
│   │   ├── User.java
│   │   └── Product.java
│   │
│   ├── util/                  # Utilitaires
│   │   └── HibernateUtil.java
│   │
│   └── listener/              # Écouteurs
│       └── HibernateListener.java
│
└── src/main/webapp/           # Vues JSP
    ├── header.jsp
    ├── footer.jsp
    ├── index.jsp
    ├── user-list.jsp
    ├── user-form.jsp
    ├── product-list.jsp
    ├── product-form.jsp
    └── error.jsp


---
✨ Fonctionnalités
---
Gestion des Utilisateurs

➕ Ajouter	:Création d'un nouvel utilisateur avec prénom, nom, email et mot de passe
✏️ Modifier : Édition des informations d'un utilisateur existant
❌ Supprimer :	Suppression d'un utilisateur avec confirmation
📋 Lister :	Affichage de tous les utilisateurs dans un tableau
---
Gestion des Produits

➕ Ajouter :	Création d'un produit avec nom, description, prix, stock et SKU
✏️ Modifier	: Édition des informations d'un produit
❌ Supprimer :	Suppression d'un produit avec confirmation
📋 Lister	: Affichage de tous les produits dans un tableau
🔍 Rechercher : 	Recherche de produits par mot-clé (nom ou description)
---

🛠️ Technologies Utilisées
Technologie	Version	Description
Jakarta EE	9.1	Spécifications pour applications d'entreprise
Jakarta Servlet	5.0	Traitement des requêtes HTTP
Jakarta JSP	3.0	Pages dynamiques côté serveur
Jakarta JSTL	2.0	Bibliothèque de balises standard
Hibernate ORM	6.0	Framework de mapping objet-relationnel
H2 Database	2.1	Base de données en mémoire (tests)
Apache Tomcat	10.1	Serveur d'application (conteneur Jakarta EE)
Maven	3.11	Gestionnaire de dépendances et build
Bootstrap	4.3	Framework CSS pour l'interface
Java	11	Langage de programmation
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
📊 Diagrammes
Architecture Technique
text

┌─────────────────────────────────────────────────────────────────────┐
│                           NAVIGATEUR                                │
│                    (Requêtes HTTP / Réponses)                       │
└────────────────────────────────┬────────────────────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────┐
│                         TOMCAT 10.1                                 │
│  ┌─────────────────────────────────────────────────────────────┐   │
│  │                     Contrôleurs (Servlets)                   │   │
│  │  UserListServlet │ UserCreateServlet │ ProductListServlet   │   │
│  └─────────────────────────────────────────────────────────────┘   │
└────────────────────────────────┬────────────────────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────┐
│                      COUCHE SERVICE (DAO)                           │
│  ┌─────────────────────────────────────────────────────────────┐   │
│  │                    GenericDAOImpl<T, ID>                    │   │
│  │  save() │ update() │ findById() │ findAll() │ delete()     │   │
│  └─────────────────────────────────────────────────────────────┘   │
│                              ▲                                      │
│              ┌───────────────┴───────────────┐                     │
│              │                               │                     │
│     ┌────────▼────────┐           ┌─────────▼─────────┐           │
│     │    UserDAO      │           │   ProductDAO      │           │
│     │ findByEmail()   │           │ findBySku()       │           │
│     └─────────────────┘           │ findByNameContaining()│       │
│                                   └───────────────────┘           │
└────────────────────────────────┬────────────────────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────┐
│                    HIBERNATE (ORM)                                  │
│         Mappage Objet → Relationnel                                 │
└────────────────────────────────┬────────────────────────────────────┘
                                 │
                                 ▼
┌─────────────────────────────────────────────────────────────────────┐
│                    BASE DE DONNÉES H2                               │
│              Tables : users │ products                              │
└─────────────────────────────────────────────────────────────────────┘

---

👥 Auteurs
Nom	               Rôle
Asma Bajadda	     Développeuse Full Stack

📅 Version
Version	Date	Description
1.0	Mars 2026	Version initiale avec gestion des utilisateurs et produits

