FROM openjdk:23-ea-17-jdk-bullseye
EXPOSE 8080
EXPOSE 5432
ADD target/Spotify_sample-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java","-jar","Spotify_sample-0.0.1-SNAPSHOT.jar"]