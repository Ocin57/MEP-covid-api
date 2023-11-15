# MEP Gradle de Nicolas Kieger

# Configuration et mise en place:
## - Commande afin de build le contenaire :
    docker compose up --build -d
## - Commande ouvrir une interface bash sur le conteneur db:
    docker compose exec -it db bash

## - Une fois dans l'interface bash, se connecter à postgres avec le mot de passe "postgres" :
    psql -h localhost -p 5432 -U postgres -d postgres

## - Insérer des données à l'aide de la commande suivante:
    INSERT INTO vaccination_center (id,address,city, name, postal_code) VALUES (1, '5 rue du poisson','Paris','Centre de Paris','75000');
    INSERT INTO vaccination_center (id,address,city, name, postal_code) VALUES (2, '2 rue de Brabois','Nancy','Centre de Nancy','54000');

## - Si l'on souhaite vérifier les insertions précédentes: 
    SELECT * FROM vaccination_center;

### Vous pouvez ensuite quitter postgres puis la connexion docker en faisant les commandes : 
\q puis exit

# Test l'API-REST de notre backend, on peut appeler la fonction getAllCenter() comme suit:
    GET http://localhost:8081/api/center


## Source
https://github.com/jredel/jenkins-compose
