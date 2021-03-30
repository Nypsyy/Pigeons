# POA Pigeons Simulator

Pour ce travail, on donnera à manger aux Pigeons ! Le but est d’implémenter une simulation d’alimentation de pigeon dans un espace public. Le jeu se passe dans une fenêtre où les pigeons attendent la nourriture. L’utilisateur, alors, leur donne à manger en cliquant sur un emplacement dans la fenêtre.
Les pigeons suivent les règles suivantes :

* Chaque pigeon est contrôlé par un thread.

* Si rien ne se passe, les pigeons s’endorment et ne bougent pas.

* En apercevant de la nourriture, un pigeon se déplace vers la nourriture la plus fraiche.

* Une nourriture fraiche touchée est mangée, donc elle doit disparaitre immédiatement de la scène.

* Nos pigeons sont gâtés ; un pigeon qui touche une nourriture pas fraiche, il l’ignore.

* Même en l’absence de la nourriture, des fois les pigeons se font effrayer et ils se dispersent à des positions aléatoires. Intégrer ce mécanisme dont la probabilité d’occurrence change d’un tour à
l’autre.

Les pigeons et la nourriture doivent être représentés graphiquement. Un simple cercle ou un objet 3D, c’est à vous de choisir. Le plus important est le multithreading et la structure des classes. En ce qui concerne le multithreading, vous serez amené à :

* S’assurer que les pigeons arrêtent de bouger le moment où il ne reste plus de nourriture.

* Aussi, s’assurer si plus qu’un pigeon touche la nourriture simultanément, uniquement un seul
pourra la supprimer.

* Prendre en compte la nourriture dans le processus de dessin. Puisque les threads ne sont pas
synchronisés, ceci permet d’ajouter de la nourriture même au moment du dessin de la scène. Il sera commode de parcourir une structure de nourriture et de faire un verrou pendant le processus de dessin.

Vous avez le choix en tout ce qui est la conception des pigeons, leurs comportements, leurs dimensions sur la fenêtre, vitesse, le nombre ... votre code est censé être robuste, des exceptions non gérées coutent des points.

# Comment jouer

* Compilé le projet avec IntelliJ IDEA ou Eclipse.

* Une fois le projet lancé, utilisé les touches suivantes :

    * Clic gauche pour faire apparaître de la nourriture.
    
    * Clic droit pour faire apparaître un pigeon.
    
    * Clic molette pour réinitialiser le jeu.
    
# Participants

* Mayeul MARSAUT - MARM19109805

* Guillaume BLANC DE LANAUTE - BLAG22029701