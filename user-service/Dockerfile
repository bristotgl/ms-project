FROM eclipse-temurin:17
LABEL authors="bristotgl"

WORKDIR /app

COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]