# InstantSystem

Cette application Android est développée pour le processus de récrutement chez Instant System.

## Architecture

L'architecture utisilée pour le développement de cette application est "MVVM", ou autrement Model, View, ViewModel, ainsi que le LiveData \
Le choix pour l'architecture MVVM est dû à sa propoagation automatique des modifications, à l'intérieur de l'état de ViewModel à la vue. Ce qui nous permet la modification rapide et instantanée lors du changement des données reçues.\
L'application comprend deux activités et deux fragments:
- Activité du splashScreen, le splash screen comprend un animation basée sur l'opacité du logo.
- L'activité principale qui contient les deux fragments, le fragemnt de la liste des actualités et le fragment de ses détails.\ 

## CI/CD
J'ai intégré "GitHub Actions" et j'ai écrit le script qui exécute les tests ainsi que le build et la génération d'un apk et le rendre disponible à télécharger. Ce script se déclenche automatiquement après chaque push. 
![alt text](https://scontent.ftun1-1.fna.fbcdn.net/v/t1.15752-9/82792547_2418986781698774_487581540893589504_n.png?_nc_cat=102&_nc_oc=AQkBb_L-r8RutjBBUExqci43OTQ9j1udGMxg2crfNZES4QuHOmpl1NYhQ52wAT_qV84&_nc_ht=scontent.ftun1-1.fna&oh=72a51f1e29ccf692e94d131d81761ffa&oe=5EA3B4F5)

![alt text](https://scontent.ftun1-1.fna.fbcdn.net/v/t1.15752-9/82766903_785470041933487_4333706814383194112_n.png?_nc_cat=103&_nc_oc=AQnoRjqwYwZZDdIpixozrpPSQdDf83q6L2wKZ-mEC6ZVQqPiF8LFcmf6uwc08-DouiE&_nc_ht=scontent.ftun1-1.fna&oh=235b00c155877e6a1c982fbeec6f7bf6&oe=5EA0F75D)

![alt text](https://scontent.ftun1-1.fna.fbcdn.net/v/t1.15752-9/82165400_211645443190102_7796144019163054080_n.png?_nc_cat=108&_nc_oc=AQkzueMdMsqBZr5lo3feeGgljOzUa9_Ybzqo0UoSXNLhgHYGyrfkH3llDcJ0NtWur7Y&_nc_ht=scontent.ftun1-1.fna&oh=afb4a61950592281123141d7a0c50279&oe=5E8F48D3)

## Lancer l'application
Pour lancer l'application, il suffit de cliquer sur le bouton run dans Android Studio une fois le projet est cloné sur votre machine.
Splash screen\
![alt text](https://scontent.ftun1-1.fna.fbcdn.net/v/t1.15752-9/83339050_190016038717673_3041085232116662272_n.png?_nc_cat=111&_nc_oc=AQnQO7RJ2BLpn3A0C2GedpEJZChJN9QP6PYNFCjHSkexCl6xjZo8y41n3etgCuCsmf8&_nc_ht=scontent.ftun1-1.fna&oh=1284514edeab3057f92f1bbf6d27d4c6&oe=5EDACE61)

Une autre alternative pour lancer l'application, c'est de télécharger sur votre smartphone le fichier apk généré précédemment et l'installer.

## Test
Les tests développés dans ce projet sont des tests UI relatives au recyclerView.\
Ces tests assurent que le recyclerView est bien visible, le bon fonctionnement du click ainsi que le scroll sur le recyclerView. 


## Fonctionnalités

Cette application offre la possibilité de visualiser la liste des dernières actualités du flux RSS du journal "LeMonde".\
Le click sur une actualité permet d'afficher son titre, son image, sa description, ainsi qu'un bouton qui permet la redirection vers l'article.\
En cas d'absence ou de coupure de la connexion internet, une animation est affichée et qui indique l'absence de la connexion. 


## Screenshots

Splash screen\
![alt text](https://scontent.ftun1-1.fna.fbcdn.net/v/t1.15752-9/82763994_591779998052079_5145271435064770560_n.png?_nc_cat=108&_nc_oc=AQlJEvG8JyjfCA24cKTJC9l6ns2l5gbsNGRNP1tgHhplP8U9AhXcw8dPYm66wQBlGXQ&_nc_ht=scontent.ftun1-1.fna&oh=b33c200743b4b199ed6cf3bee3ce982d&oe=5E9EC06D)

La liste des actualités\
![alt text](https://scontent.ftun1-1.fna.fbcdn.net/v/t1.15752-9/82602469_1332050446997252_3563431243326423040_n.png?_nc_cat=107&_nc_oc=AQkEDp47aeyNEDOxvC1Peqa5xU836HyjuEbTFSCp3c1IKdYSJ4W5p3NIwpNXVm23oBE&_nc_ht=scontent.ftun1-1.fna&oh=66b34c74f292f75e32da99819779945d&oe=5E9C7121)

Les détails d'une actualité\
![alt text](https://scontent.ftun1-1.fna.fbcdn.net/v/t1.15752-9/82456456_666317097440348_3195661740754862080_n.png?_nc_cat=107&_nc_oc=AQl33q5MBD6TGxMwR92B3ujrAi-TYJFqvtUYNSqvkgZX3CTDM597dy6x4iXgRGWxGXE&_nc_ht=scontent.ftun1-1.fna&oh=3767d89e96539e9868d8ba05353c373e&oe=5ED1BC5B)

Le cas d'absence de la connexion internet\
![alt text](https://www.linkedin.com/dms/C4D06AQEb_3cLYM1URQ/messaging-attachmentFile/0?m=AQK4I2aaJnO_6AAAAW_CQEGcC2gOjGI8MQcJ8QpZCh1Z-VNPlcMY7RpS-A&ne=1&v=beta&t=ZCPocvptscDnrjwqhRNcg3RT7M44RouXJNaRdK536ok#S6624354001364234240_500)




## Librairies
Les librairies utilisées sont: 
- Retrofit pour la consmmation du webservice.
- Gide pour le chargement des images.
- Lottie pour l'intégration d'une image GIF.
