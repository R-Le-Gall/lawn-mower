## Lawn mower

Lorsqu'un ensemble pelouse + tondeuses est traité les tondeuses sont ajoutées et retirées au fur et à mesure de leur déclaration, i.e. aucune gestion de collision ou de superposition n'est implémentée.

### Pré-requis 

scala 2.10 +
sbt 0.12 +

### Usage

#### Création du jar 
    > sbt package

### Utilisation
    > scala target/scala-2.10/lawn-mower_2.10-0.1.jar LawnMowerInstructions.txt
    > 4 8 N
    > 5 10 S
    > 8 4 S

où `LawnMowerInstructions.txt` correspond au fichier analysé et les lignes suivantes aux résultats des instructions.