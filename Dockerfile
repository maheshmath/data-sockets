FROM openjdk:11.0.11-jre-slim
COPY target/data-sockets-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "app.jar","--spring.profiles.active=prod"]