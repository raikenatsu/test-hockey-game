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