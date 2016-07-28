[![alt text](/dav_logo_small.png "Davidson Consulting")](http://www.davidson.fr/)
Exemples d'utilisation de pages JSF (javaee6)
===================================

Prérequis
---------
Java version 7 ou plus

Cet exemple peut être exécuté sans configuration supplémentaire sur 
 - [Oracle Glassfish 3 et plus](https://glassfish.java.net/)
 - [Apache TomEE](http://tomee.apache.org/)
 - [RedHat Jboss AS 6 et plus (Web profile)](http://jbossas.jboss.org/downloads), puis [WildFly 8 et plus](http://wildfly.org/)
 - Tous les autres serveurs supportant le profil web jee6 et jee7

Exemples
--------
        <ul>
            <li><h:link value="Exemple 1 : Facelet simple" outcome="exemple1"/></li>

        </ul>
        <h1>Exemples de managed beans</h1>
        <ul>
            <li><h:link value="Exemple 2 : Facelet et managed beans" outcome="exemple2"/></li>
            <li>TODO : managed beans : différents scopes</li>
            <li>TODO : converters : conversion de types non supportés</li>
            <li>TODO : différents type de managed beans : séparation des responsabilités</li>
        </ul>
        <h1>Exemples d'utilisation de templates JSF</h1>
        <ul>
            <li><h:link value="Exemple 3 : surcharge des ui:include d'un template avec ui:define" outcome="exemple3"/></li>
            <li><h:link value="Exemple 3 : utilisation des valeurs par défaut des ui:include d'un template" outcome="exemple3-default"/></li>
        </ul>
