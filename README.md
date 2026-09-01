**Simulation Marine — Projet POO**

Simulation multi-agents d'un écosystème marin en tour par tour opposant un pirate à des requins : gentils et pilleurs sur une grille 2D de ressources : algues et poissons magiques.

**Présentation** : 

L'objectif de la simulation est de modéliser la survie d'un Pirate dans un environnement marin :
A chaque tour :
Le pirate explore le terrain pour collecter des Algues et des Poissons Magiques.
Le requin gentil offre un poisson au pirate dans 60% des cas quand c'est son tour.
Le requin pilleur tue ou vide le stock actuel du pirate.

-Condition de victoire : Le pirate gagne la partie dès qu'il accumule 3 poissons magiques.
-Condition de défaite : Le pirate meurt s'il subit une attaque fatale d'un requin pilleur ou si tout son stock est pillé.

**Les Agents Marins** :
-Pirate : 
  * Se déplace sur la grille et collecte les ressources présentes sur sa case.
  * Peut offrir des algues à un requin gentil pour gagner de l'énergie.
  * Gagne s'il atteint 3 poissons magiques.
-Requin Gentil  :
  * Offre un poisson magique au pirate dans 60 % des cas lors de son tour.
  * Sinon, il mange la ressource présente sur sa case.
-Requin Pilleur :
  * 10 % de chance d'attaquer mortellement le pirate (victoire des requins.
  * 10 % de chance de piller 3 algues et 3 poissons au pirate.
  * 80 % de chance de préférer manger des algues/poissons sur le terrain plutôt que d'attaquer.

**Les Ressources** :
* Algue : Ressource végétale qui croît automatiquement à chaque manche.
* PoissonM (Poisson Magique) : Ressource rare nécessaire à la victoire du pirate.

---

**Concepts POO** :

**Hiérarchie d'héritage (3 niveaux)** : 'AgentMarin', 'AnimalMarin', 'Requingentil', 'RequinPilleur' : Spécialisation progressive des comportements marins.
**Classes et méthodes abstraites** : 'AgentMarin', 'AnimalMarin'.
**Interface** : 'InteractionMarine'
**ArrayList** : 'Simulation' :  Gestion dynamique de la liste des agents.
**Classe statique** `QuantiteRessource` : Suivi global des compteurs d'algues et de poissons en mer.
**Exception personnalisée** : 'ActionMerException' : Déclenchée si un animal tente de manger sur une case vide.
**Design Pattern Singleton** : 'EtatDesClasses' : Historique des logs et des statistiques de mortalité.
