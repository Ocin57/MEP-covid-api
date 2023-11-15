# On utilise l'image openjdk 22
FROM openjdk:17-slim-bullseye as Builder


# Mise à jour de l'OS
RUN apt-get update

# Copiez les fichiers nécessaires pour le wrapper Gradle
COPY /covid-api /covid-api

# Définissez le répertoire de travail dans le conteneur
WORKDIR /covid-api

# Donnez les droits d'exécution de tout le dossier covid-api
RUN chmod -R +x /covid-api

# Exécutez le build Gradle
RUN ./gradlew build

#CMD ["java", "-jar", "build/libs/covid-api-0.0.1-SNAPSHOT.jar"]


FROM openjdk:17-slim-bullseye 

# Copiez le jar de l'étape de build dans le conteneur
COPY --from=Builder /covid-api/build/libs/covid-api-0.0.1-SNAPSHOT.jar /app.jar
# Commande par défaut pour lancer l'application
#CMD ["java", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-jar", "/app.jar"]