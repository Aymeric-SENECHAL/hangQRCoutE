HandQRCoutE est une application qui permet de facilement partager un lien (
en soirée par exemple ) en générant des QrCode.

Pour cela, il faut renseigner un nom, et une url ce qui nous générera un QrCode
que l'on pourra partager à tout le monde. 

L'application permet de stocker ses anciens QrCode généré, en l'ajoutant tout simplement dans
sa liste.


Pour faire fonctionner l'application, il faut faire tourner le back (Spring/JAVA), qui est
relié à une base de donnée nommée hangqrcoute : 
	- identifiant : root
	- mdp: root
Il est possible de changer les configurations du back dans le fichier properties