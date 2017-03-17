TODO

- projet de micro service en thin war
- lancement avec docker
- possibilité de lancer la meme chose sur différents serveurs
- comme adam bien

Créer l'image pour docker

    docker build -t davidson/009micro .

Lancer l'image avec docker

    docker run -d -p 8080:8080 --name micro davidson/009micro

Ouvrir l'application [http://localhost:8080/009-microservice-thin-war/resources/message](http://localhost:8080/009-microservice-thin-war/resources/message)