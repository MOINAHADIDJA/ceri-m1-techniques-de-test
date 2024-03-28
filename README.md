

## Nom et Prenom

- Moinahadidja Mohamed Chakir

## Groupe
- ILSEN CLA

## Badges

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/MOINAHADIDJA/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/MOINAHADIDJA/ceri-m1-techniques-de-test/tree/master)

[![codecov](https://codecov.io/gh/MOINAHADIDJA/ceri-m1-techniques-de-test/graph/badge.svg?token=R8S81SVJOP)](https://codecov.io/gh/MOINAHADIDJA/ceri-m1-techniques-de-test)

## Implémentation

Les implémentations concrètes des interfaces sont fournies par les classes telles que PokedexImpl, PokemonFactoryImpl, PokemonMetadataProviderImpl, etc.

Factories : Les factories sont utilisées pour créer les instances des différentes composantes de l'API. Cela permet de déléguer la responsabilité de la création d'objets à des composantes dédiées, ce qui facilite la gestion des dépendances et améliore la modularité du code.

- IPokedex

    Implémentation : PokedexImpl

    Description : Cette classe implémente l'interface IPokedex et fournit les fonctionnalités pour gérer les Pokémon dans le Pokédex, telles que l'ajout de nouveaux Pokémon, la récupération des Pokémon existants, etc.
    

- IPokemonFactory

    Implémentation : PokemonFactoryImpl

    Description : Cette classe implémente l'interface IPokemonFactory et fournit une méthode pour créer de nouveaux Pokémon à partir des statistiques spécifiées.


- IPokedexFactory

    Implémentation : PokedexFactoryImpl

    Description : Cette interface définit une méthode permettant de créer des instances de la classe Pokedex, qui sont utilisées pour gérer les Pokémon dans le Pokédex. Une implémentation typique de cette interface, telle que PokedexFactoryImpl, utilise un IPokemonMetadataProvider et un IPokemonFactory pour créer un nouveau Pokédex. Cette interface joue un rôle crucial dans la création de nouveaux Pokédex pour les dresseurs de Pokémon.


- IPokemonMetadataProvider

    Implémentation : PokemonMetadataProviderImpl

    Description : Cette classe implémente l'interface IPokemonMetadataProvider et fournit une méthode pour récupérer les métadonnées des Pokémon, telles que leur nom, leurs statistiques de base, etc.


- IPokemonTrainerFactory

    Implémentation : PokemonTrainerFactoryImpl

    Description : Cette classe implémente l'interface IPokemonTrainerFactory et fournit une méthode pour créer de nouveaux dresseurs de Pokémon.

# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
