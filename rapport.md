# Documentation des choix et hypothèses de travail
- Auteurs : Bleuer Rémy, Leyre Arnaut
- Date : 21.10.24
- Classe : POO-A

## Introduction
Ce document présente les choix de conception et les hypothèses de travail réalisés dans le cadre de la modélisation UML et de l'implémentation Java de `Matrix` et de leurs opérations mathématiques modulo n. L'objectif est de fournir une base de code extensible et robuste pour gérer les opérations entre matrices, tout en respectant les contraintes de la donnée.

## Choix de conceptions

### 1. Interface et Class:
Les matrices peuvent être sujettes à plusieurs opérations (addition, soustraction, multiplication élément par élément). Ces opérations héritent de l'interface abstraite `Opération` et définissent l'opération à effectuer entre 2 éléments des `Matrix`. Cette interface est implémentée par des classes individuelles (`Addition`, `Subtraction`, `Multiplication`), chacune appliquant sa propre logique à deux éléments des matrices.

### 2. Cardinalités :
Il y a une cardinalité 2 entre `Matrix` et `Opération` car toutes les opérations demandent 2 matrices en arguments. A noter qu'il est tout à fait possible de donner deux fois la même matrice.

### 3. Factorisation
Les méthodes d'addition, de soustraction et de multiplication de matrices partagent une structure similaire. Au lieu de dupliquer le code pour chaque opération, une méthode générique `performOperation` a été créée. Elle prend une instance d'`Operation` et applique l'opération correspondante. Cela permet d'ajouter facilement de nouvelles opérations en créant simplement une nouvelle classe implémentant l'interface `Operation`.

### 4. Redimensionnement des matrices
Pour garantir que les matrices font la même taille avant de faire une opération, nous avons utilisé la méthode `resizedCopy()`, qui permet de créer une copie redimensionnée d'une matrice sans modifier les matrices d'origine. Cela assure que les tests peuvent se baser sur des matrices inchangées tout au long des opérations.

## Choix d'implémentation :

### 1. Exception :
- Une `Matrix` avec un modulo n <= 0 ne fait pas beaucoup de sens. Les constructeurs renvoient donc une `Runtime Exception` dans ce cas.
- Une `Matrix` avec `rows` ou `cols` négatif ne fait pas beaucoup de sens. Le constructeur random renvoie donc une `Runtime Exception` dans ce cas.
- Une `Matrix` avec soit `rows` soit `cols` nul devrait logiquement avoir l'autre attribut nul également. Le constructeur random renvoie donc une `Runtime Exception` si ce n'est pas le cas.
- Les matrices doivent partager le même modulo afin de faire une opérations dessus. Si ce n’est pas le cas, une `RuntimeException` est levée avec le message "Les modulos n des deux matrices ne correspondent pas."


### 2. toString
Pour des questions de lisibilité, la String d'affichage est affichée entre [] s'il n'y a qu'une seule ligne et affiche [[]] si la 'Matrix' est 0,0

## Tests unitaires :
1. Opéartions : Valide le comportement des opérations (addition, soustraction, multiplication) élément par élément modulo `n`. Chaque opération est comparée avec une matrice de référence pour vérifier qu'on obtient bien le résultat voulu. Les tests incluent également la gestion des tailles différentes grâce au redimensionnement automatique et au remplissage par des zéros lorsqu'il y en a besoin.
2. Exception : Un test spécifique vérifie que la différence de modulo entre deux matrices entraîne bien une exception.
   
Les tests ont également révélé un point important dans la gestion des redimensionnements : l'implémentation de la méthode `resize()` initialement modifiait les matrices en place, ce qui modifiait les résultats des tests qui suivaient. En remplaçant `resize()` par `resizedCopy()`, nous avons évité les effets de bord, ce qui a stabilisé les tests.

## Conclusion : 
Cette implémentation répond aux demandes de la donnée de manière modulaire et maintenable. Le choix d’utiliser des interfaces pour les opérations permet une extension facile des opérations. Les tests unitaires couvrent l'ensemble des cas d'usage, incluant les cas limites de redimensionnement et de différences de modulo. L’architecture proposée offre une grande flexibilité et garantit que les matrices d’origine ne sont pas altérées lors des opérations.
