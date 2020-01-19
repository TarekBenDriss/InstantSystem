# InstantSystem

Cette application Android est développée pour le processus de récrutement chez Instant System.

## Architecture

L'architecture utisilée pour le développement de cette application est "MVVM", ou autrement Model, View, ViewModel, ainsi que le LiveData \
L'application comprend deux activités et deux fragments:
- Activité du splashScreen, le splash screen comprend un animation basée sur l'opacité du logo.
- L'activité principale qui contient les deux fragments, le fragemnt de la liste des actualités et le fragment de ses détails.


## Fonctionnalités

Cette application offre la possibilité de visualiser la liste des dernières actualités du flux RSS du journal "LeMonde".\
Le click sur une actualité permet d'afficher son titre, son image, sa description, ainsi qu'un bouton qui permet la redirection vers l'article.\
En cas d'absence ou de coupure de la connexion internet, une animation est affichée et qui indique l'absence de la connexion. 



## Librairies
Les librairies utilisées sont: 
- Retrofit pour la consmmation du webservice.
- Gide pour le chargement des images.
- Lottie pour l'intégration d'une image GIF.