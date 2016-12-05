[![alt text](/dav_logo_small.png "Davidson Consulting")](http://www.davidson.fr/)
Exemples d'utilisation de Jax-ws : client standalone appelant un service web jax-ws
===================================================================================

Prérequis
---------
Java version 7 ou plus

Ce client nécessite la dépendence suivante pour fonctionner

```
    <dependency>
        <groupId>fr.davidson.sample.jee</groupId>
        <artifactId>007-jax-ws-server-service</artifactId>           
        <classifier>wsclient</classifier>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```

Cette dépendance est générée par maven en construisant le module 007-jax-ws-server par

```
   mvn clean install
```

Pour que le client puisse appeler le service web, il faut que ce dernier soit 
déployé sur un serveur java EE tel que Glassfish ou Payara

Exemples
--------

Exercices
--------

