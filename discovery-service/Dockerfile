#Quand on veut creer une image docker on se base sur une autre image qui existe deja , par exemple ici de Oracle
FROM openjdk:17-oracle
#Quand on creer une image docker les BD sont creer a l'interieur de docker , c'est pourquoi tmp un fichier tmp a l'exterieur de docker
VOLUME /tmp
COPY target/*.jar app.jar
#Au demarage de conteneur il faut execute ca
ENTRYPOINT ["java","-jar","app.jar"]