# Remarques

## Données de tests
Lors du démarrage de l'application, les "teams" 2019 et 2020 seront créées automatiquement grâce au service DataLoader.

## Endpoint création de joueur
Il me semble y avoir une incohérence pour l'écriture de ce endpoint.

Le titre stipule une url POST **/api/team/{year}** mais le endpoint prend en body un "player" et renvoi un "player",
l'exemple donné montre une url **/api/player** qui semble plus appropriée mais il n'est pas possible de préciser à quelle
équipe le joueur appartient.

Je conserve l'url **/api/team/{year}** comme précisé dans le postman.

## Endpoint mettre à jour le capitaine
Il me semble y avoir une incohérence pour l'écriture de ce endpoint.

Ce endpoint est censé promouvoir un "player" grâce à son ID, seulement le modèle donnée ne fait mention que d'un "number",
le "number" n'étant pas unique d'une "team" à l'autre il est nécessaire de renseigner quelle "team" est concernée ou
d'ajouter un identifiant unique à chaque "player".

Pour que le postman fonctionne toujours je fais le choix de rajouter un id sur les joueurs.



# Test Développeur JAVA/Spring intermédiaire

## Objectif du test

Votre objectif pour ce test est de créer un API Rest avec Java et Spring Boot pour ajouter et obtenir les joueurs et les informations de l'équipe de Hockey des Canadiens du Montréal.
Le but est donc d'avoir la composition de cette équipe pour chaque année ou elle a participé à la Ligue Nationale de Hockey.

**Vous devez créer les endpoints suivants dans l'API:**

-   Un GET pour obtenir la composition de l’équipe en fonction de l'année dans la base de données en mémoire (H2).
-   Un POST pour t'ajouter en tant que nouveau joueur de l'équipe d'une année définie dans la base de données en mémoire (H2).
-   Un PUT pour mettre à jour le capitaine de l'equipe pour une année définie 

## **Présomptions**

-   Ne vous souciez pas de valider l'entrée de l'utilisateur, vous pouvez présumer que la requête sera toujours valide.
-   Il n'est pas nécessaire d'implémenter un mécanisme de sécurité.
-   Il n'est pas nécessaire d'écrire des tests unitaires.

## Critères

-   3 endpoints REST fonctionnels
-   Structure des classes
-   Qualité du code
-   Utilisation des meilleurs pratiques de développement

## Outils à utiliser

Le projet contient déjà les dépendances Maven requises et la configuration nécessaire pour H2.

Vous avez aussi, optionnellement, la possibilité d'utiliser les librairies Lombok et MapStruct si vous le désirez (Hors kotlin).

-   Java 11 ou Kotlin
-   Maven
-   Spring Boot
-   Spring Data JPA
-   Base de donnée en mémoire H2
-   Lombok (Optionnel)
-   Mapstruct (Optionnel)

## Modèle

Team

```
{
    "id": long,
    "coach": string
    "year" : long
    "players": [
        {
            "number": long,
            "name": string,
            "lastname": string,
            "position":"defenseman",
            "isCaptain" : boolean
        }
    ]
}

```

## Endpoints

### GET /api/team/{year}

-   Requête: Year dans l'URI
-   Réponse: Objet Team (Voir modèle ci-dessus)
-   Status: 200 OK


    http://localhost:8080/api/team/2020
    {
       "id":2,
       "coach":"Dominique Ducharme",
       "year":"2020",
       "players":[
          {
             "number":31,
             "name":"Carey",
             "lastname":"Price",
             "position":"goaltender"
          },
          {
             "number":14,
             "name":"Nick",
             "lastname":"Suzuki",
             "position":"forward"
          },
          {
             "number":15,
             "name":"Jesperi",
             "lastname":"Kotkaniemi",
             "position":"forward"
          },
          {
             "number":71,
             "name":"Jake",
             "lastname":"Evans",
             "position":"forward"
          },
          {
             "number":27,
             "name":"Alexander",
             "lastname":"Romanov",
             "position":"defenseman"
          },
          {
             "number":6,
             "name":"Shea",
             "lastname":"Weber",
             "position":"defenseman",
             "isCaptain" : true
          }
       ]
    }

    http://localhost:8080/api/team/2019
    {
       "id":1,
       "coach":"Dominique Ducharme",
       "year":"2019",
       "players":[
          {
             "number":31,
             "name":"Carey",
             "lastname":"Price",
             "position":"goaltender"
          },
          {
             "number":14,
             "name":"Nick",
             "lastname":"Suzuki",
             "position":"forward"
          },
          {
             "number":15,
             "name":"Jesperi",
             "lastname":"Kotkaniemi",
             "position":"forward"
          },
          {
             "number":71,
             "name":"Jake",
             "lastname":"Evans",
             "position":"forward"
          },
          {
             "number":27,
             "name":"Alexander",
             "lastname":"Romanov",
             "position":"defenseman"
          },
          {
             "number":6,
             "name":"Shea",
             "lastname":"Weber",
             "position":"defenseman",
             "isCaptain" : true
          }
       ]
    }

### POST /api/team/{Year}

-   Requête: Objet Joueur dans le body
-   Réponse: Objet Joueur crée
-   Status: 201 CREATED


```
http://localhost:8080/api/player --header "Content-Type:application/json"

{
  "number":99,
  "name":"Marion",
  "lastname":"Félix",
  "position":"forward",
  "isCaptain" : false
}

```

### PUT /api/player/captain/{ID}

-   Requête: ID du joueur dans l'URI
-   Réponse: Objet Player
-   Status: 200 OK

## Validation des endpoints

Vous pouvez utiliser la collection postman incluse dans le projet si vous désirez valider votre API avec des assertions.

Celle-ci se retrouve dans le dossier **postman** du projet.

## Soumettre le test

Une fois terminé, veuillez créer un nouveau dépot sur GitHub et l'envoyer par courriel.

**Bonne chance et bon game ! 🏒**

          
