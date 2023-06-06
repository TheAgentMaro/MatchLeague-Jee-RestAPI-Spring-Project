# MatchLeague
MatchLeague est une application de gestion de matchs sportifs. Elle permet aux utilisateurs de créer des saisons, des journées et d'organiser des matchs entre différentes équipes.

## Technologies utilisées

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (base de données)
- Maven (gestion des dépendances)
- Postman (test des API) / Swagger UI

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés :

- Java Development Kit (JDK)
- Maven
- MySQL Server

## Configuration de la base de données

Créez une base de données MySQL vide pour MatchLeague.

Ouvrez le fichier application.properties dans le répertoire src/main/resources.

Modifiez les propriétés suivantes en remplaçant les valeurs entre < et > par vos propres informations de connexion à la base de données :

```bash
spring.datasource.url=jdbc:mysql://<your-database-host>:<your-database-port>/<your-database-name>?useSSL=false&serverTimezone=UTC
spring.datasource.username=<your-database-username>
spring.datasource.password=<your-database-password>
```
## Compilation et exécution du projet

Ouvrez une ligne de commande et accédez au répertoire racine du projet.

Exécutez la commande suivante pour compiler le projet :

```bash
mvn clean install
```

Une fois la compilation terminée avec succès, exécutez la commande suivante pour démarrer l'application :

```bash
mvn spring-boot:run
```

L'application sera lancée et sera accessible à l'adresse http://localhost:8080.

## Utilisation des API

### SwaggerUI
Accédez à Swagger UI en utilisant le lien suivant : http://localhost:8080/swagger-ui/index.html
Swagger UI vous permet d'explorer les différentes API disponibles, d'afficher leurs détails, de tester les endpoints et même de générer des exemples de code pour les appels d'API.

### Postman
Vous pouvez utiliser les outils tels que Postman pour tester les API de MatchLeague. Voici quelques exemples d'API disponibles :

```bash
Créer une saison : POST /api/seasons
Obtenir une saison par ID : GET /api/seasons/{id}
Mettre à jour une saison : PUT /api/seasons/{id}
Supprimer une saison : DELETE /api/seasons/{id}
```
Veuillez vous référer à la documentation de l'API pour obtenir la liste complète des endpoints et des opérations disponibles.

## Contribuer

Les contributions à MatchLeague sont les bienvenues ! Si vous souhaitez contribuer au projet, veuillez suivre ces étapes :

Fork du projet.

Créez une branche pour votre fonctionnalité ou votre correction de bogue : git checkout -b feature/ma-nouvelle-fonctionnalite.

Effectuez les modifications nécessaires et effectuez les commits : git commit -am 'Ajouter une nouvelle fonctionnalité'.

Poussez vos modifications vers la branche : git push origin feature/ma-nouvelle-fonctionnalite.

Ouvrez une Pull Request et décrivez votre contribution.

## Auteur

MatchLeague est développé par Mohamed Marwen Meddeb.

## Licence

Ce projet est sous licence MIT.
