Compte rendu projet Laby :

## 1. Binôme :
- **Nom, Prénom :** COMTE, Gabriel
- **Nom, Prénom :** FUCHS, Thomas

## 2. Descriptif des difficultés rencontrées :

- **Difficulté :** Méthode chargementLabyrinthe() de la classe Labyrinthe, nous avons rencontré des échecs (levées d'exceptions) et personnages 
null ou à la mauvaise position.

- **Difficulté :** Méthode deplacerPerso() et getSuivant() de la classe Labyrinthe. Le personnage s'arrêtait avant la case S (sortie) ou lorsque l'utilisateur entrait "bas" dans la console, le personnage restait bloqué ou virait en diagonale vers le bas dans la colonne du côté gauche.

- **Solution :** Modification de conditions de la position de X et Y dans la classe Position (méthode valide).

- **Solution :** Ajout d'une instruction "break" (oubliée) dans le switch de la méthode getSuivant(). Ajout d'une condition permettant l'interruption de la boucle while de patinage du perso P lorsqu'il rencontre le caractère S.
 
 

## 3. Descriptif des choix effectués :





## 4. Lancement de l'application :

### 4.1. Lancement de l'application dans la console :

Pour lancer l'application dans la console, il suffit de lancer la commande suivante :

```bash
    java MainLaby <nom_fichier>.txt
```




## 5. Résultats des tests unitaires :
Tous les tests sont passés!!


## 6 .Descriptif des tests :
Nous  avons décidé de tester les colisions avec chaque type de déplacement afin de vérifier si le personnage s'arrête correctement.
Nous vérifions le chargement correct du labyrintthe avec les fichiers txt fournits.
Nous ne vérifions pas le chargement en cas de perso introuvable ou en trop ainsi que les problème de colonne ou de ligne car il n'y a pas de fichier txt préconstruit avec ces bugs.
