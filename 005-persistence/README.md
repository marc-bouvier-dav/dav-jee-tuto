[![alt text](/dav_logo_small.png "Davidson Consulting")](http://www.davidson.fr/)
Exemples d'utilisation de Primefaces (javaee6)
==================================

Prérequis
---------
Java version 7 ou plus

Cet exemple peut être exécuté sans configuration supplémentaire sur 
 - [Oracle Glassfish 3 et plus](https://glassfish.java.net/)

Exemples
--------

 - [Exemple 1 : Ajout d'un formateur, liste des formateurs.](./src/main/webapp/formateur/liste-formateurs.xhtml) (Primefaces : Tableau, ligne éditable. JPA : Insertion, suppression, recherche simple d'une donnée depuis la base de données)
 - [Exemple 2 : Ajout d'une formation, d'une session de formation.](./src/main/webapp/formateur/liste-formateurs.xhtml)  (JSF : update, converters. Primefaces : selection dans tableau. JPA lister des données)
 - [Exemple 3 : Recherche.](./src/main/webapp/session-formation/recherche-sessions.xhtml) (JPA : recherche filtrée multicritère)
 
Exercices
--------

 - Modifier les entités, les services et les facelets pour qu'un participant puisse assister à plusieurs sessions de formation
 - Dans l'exemple 2 ([formation.xhtml](./src/main/webapp/formation/formation.xhtml)), Permettre d'ajouter des participants à une session de formation. L'afficahge du formulaire d'ajout et de la liste des participants sera conditionné par la sélection dans la liste des sessions de formation.
