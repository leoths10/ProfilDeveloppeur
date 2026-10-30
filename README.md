# Profil développeur Compose

## Description

Cette application affiche une fiche « Profil développeur » sur un seul écran Jetpack Compose.
La fiche présente un nom, un rôle, une courte description, trois compétences et une information
de disponibilité. Un bouton « Contacter » permet de signaler une action à l'écran parent.
Le clic appelle un callback vide, car aucune logique n'est demandée.

## Notions utilisées

- composables et paramètres
- `Modifier` et chaînage de modifiers
- padding externe / padding interne
- callbacks (`onClick: () -> Unit`)
- `Scaffold` et `innerPadding`
- `Button`
- previews

## Explication courte

1. **Composables créés** : `ProfilScreen`, `ProfilCard`, `ProfilHeader`, `Competence`,
   `InfoDisponibilite`, `ActionButton`.
2. **Écran principal** : `ProfilScreen`, appelé dans `setContent` de `MainActivity`.
3. **Padding externe** :
   - `Modifier.padding(innerPadding)` dans `MainActivity` : le `Scaffold` place l'écran en dehors
     des barres système ;
   - `Modifier.padding(16.dp)` passé par `ProfilScreen` à `ProfilCard` ;
   - les `padding(top = ...)` passés par `ProfilCard` à ses composants enfants.
4. **Padding interne** :
   - `padding(16.dp)` sur la `Column` de `ProfilCard` (espace entre le bord de la fiche et son contenu) ;
   - `padding(12.dp)` dans `InfoDisponibilite` ;
   - `padding(start = 8.dp)` dans `Competence`.
5. **Callback** : `ActionButton` reçoit `onClick`. Il signale le clic, c'est `MainActivity`
   qui décide quoi faire (ici, rien pour le moment).
6. **Accessibilité** : je n'ai pas créé de zone cliquable personnalisée, seulement un `Button`.
   Le `Button` est déjà plus explicite qu'une simple zone cliquable : son rôle de bouton et son
   texte (« Contacter ») sont annoncés automatiquement par les lecteurs d'écran, sans avoir besoin
   d'ajouter `semantics`. Une zone cliquable personnalisée (`clickable` sur un `Text`) serait
   annoncée comme un simple texte.
7. **Réutilisables** : chaque composable reçoit ses données en paramètres (nom, compétence,
   texte, callback) et accepte `modifier: Modifier = Modifier`, donc le parent choisit le
   placement. Les deux previews le prouvent : mêmes composables, données différentes.

## Chaîne de modifiers

Dans `InfoDisponibilite` : `modifier.fillMaxWidth().padding(12.dp)` — le texte occupe toute la
largeur de la fiche, puis on ajoute un espace interne autour.

## Capture d'écran

![Application lancée](captures/appli.png)
