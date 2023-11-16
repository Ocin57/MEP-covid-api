# MEP Gradle de Nicolas Kieger
 
[Lien du projet Docker Hub](https://hub.docker.com/r/nicokgr/mep-backend)

# Partie 1 - LOCAL :

> Afin de réaliser cette partie, il vous faudra copier ce dépot en local à l'aide de la commande : 'git clone https://github.com/Ocin57/MEP-covid-api.git'

## Information :
Une difficulté rencontré dans cette partie et que je n'ai pas réussi à trouver une image jre pour avoir un conteneur moins volumineux avec openjdk. J'utilise donc une image jdk.

## - Commande afin de build les conteneurs Backend et Postgres :

    ```shell
    docker compose up --build -d
    ```

## - Insertion de data dans la base de donnée :
### Ouvrir une interface bash sur le conteneur Postgres:

    ```shell
    docker compose exec -it db bash
    ```

### Se connecter à postgres avec le mot de passe "postgres" :

    ```shell
    psql -h localhost -p 5432 -U postgres -d postgres
    ```

### Insérer des données à l'aide des commandes suivantes:

    ```sql
    INSERT INTO vaccination_center (id,address,city, name, postal_code) VALUES (1, '5 rue du poisson','Paris','Centre de Paris','75000');
    INSERT INTO vaccination_center (id,address,city, name, postal_code) VALUES (2, '2 rue de Brabois','Nancy','Centre de Nancy','54000');
    ```

#### Vérifier les insertions précédentes: 

    ```sql
    SELECT * FROM vaccination_center;
    ```

### Quitter Postgres puis la connexion docker en faisant les commandes : 

    ```shell
    \q
    ```
    ```shell
    exit
    ```

## - Test l'API-REST de notre backend en affichant tous les centres de vaccination:

> Par défaut, il n'y a aucun centre dans la base de donnée, et donc rien ne s'affichera

    ```
    GET http://localhost:8081/api/center/
    ```

Vous pouvez également utiliser la commande suivante:

    ```shell
    curl 'http://localhost:8081/api/center/'
    ```

## Arrêt des conteneurs :

    ```shell
    docker compose down
    ```


# Partie 2 - JENKINS :


# Source
https://github.com/jredel/jenkins-compose
