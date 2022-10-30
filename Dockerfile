FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app

COPY target/inventory-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]