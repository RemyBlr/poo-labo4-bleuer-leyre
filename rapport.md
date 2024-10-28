# Documentation des choix et hypothèses de travail
- Auteurs : Bleuer Rémy, Leyre Arnaut
- Date : 21.10.24
- Classe : POO-A

## Introduction
Ce document présente les choix de conception et les hypothèses de travail réalisés dans le cadre de la modélisation UML et de l'implémentation Java de 'Matrix' et de leurs opérations.

## Choix de conceptions

1. ### Interface et Class:

Les matrices peuvent être sujettes à plusieurs opérations. Ces opérations héritent de l'interface abstraite 'Opération' et définissent l'opération à effectuer entre 2 éléments des 'Matrix'.

2. ### Cardinalités :
- Il y a une cardinalité 2 entre 'Matrix' et 'Opération' car toutes les opérations demandent 2 matrices en arguments. A noter qu'il est tout à fait possible de donner deux fois la même 'Matrix'.


## Choix d'implémentation :

1. ### Exception :
- Une 'Matrix' avec un modulo n <= 0 ne fait pas beaucoup de sens. Les constructeurs renvoient donc une Runtime Exception dans ce cas.
- Une 'Matrix' avec 'rows' ou 'column' négatif ne fait pas beaucoup de sens. Le constructeur random renvoie donc une Runtime Exception dans ce cas.
- Une 'Matrix' avec soit 'rows' soit 'column' nul devrait logiquement avoir l'autre attribut nul également. Le constructeur random renvoie donc une Runtime Exception si ce n'est pas le cas.


2. ### toString
Pour des questions de lisibilité, la String d'affichage est affichée entre [] s'il n'y a qu'une seule ligne et affiche [[]] si la 'Matrix' est 0,0