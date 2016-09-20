[![alt text](/dav_logo_small.png "Davidson Consulting")](http://www.davidson.fr/)
Exemples d'utilisation de Primefaces (javaee6)
==================================

Prérequis
---------
Java version 7 ou plus

Cet exemple peut être exécuté sans configuration supplémentaire sur 
 - [Oracle Glassfish 3 et plus](https://glassfish.java.net/)
 - [Apache TomEE](http://tomee.apache.org/)
 - [RedHat Jboss AS 6 et plus (Web profile)](http://jbossas.jboss.org/downloads), puis [WildFly 8 et plus](http://wildfly.org/)
 - Tous les autres serveurs supportant le profil web jee6 et jee7
 - Installer glassfish / payara et le configurer dans netbeans ([voir wiki](https://github.com/marc-bouvier-dav/dav-jee-tuto/wiki/Installer-Payara-dans-Netbeans))
 - Créer une base de données et Configurer un connection pool et une datasource ([voir wiki](https://github.com/marc-bouvier-dav/dav-jee-tuto/wiki/Configuer-datasource---connection-pool-dans-Netbeans---Payara---Glassfish))

Exemples
--------

 - [Exemple 1 : utilisation d'un tableau dans primefaces utilisant un backing bean. Insertion d'une donnée et récupération d'une liste depuis la base de données](./src/main/webapp/formateur/liste-formateurs.xhtml)
 - [Exemple 2 : JSF : update, converters. Primefaces : selection dans tableau](./src/main/webapp/formateur/liste-formateurs.xhtml)
 
Exercices
--------

 - Modifier les entités, les services et les facelets pour qu'un participant puisse assister à plusieurs sessions de formation
 - Dans l'exemple 2 ([formation.xhtml](./src/main/webapp/formation/formation.xhtml)), Permettre d'ajouter des participants à une session de formation. L'afficahge du formulaire d'ajout et de la liste des participants sera conditionné par la sélection dans la liste des sessions de formation.
