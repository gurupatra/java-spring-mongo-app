FROM openjdk:8-jdk-alpine
RUN addgroup -S prag && adduser -S patrag -G prag
USER patrag:prag
ADD target/java-app-1.0-SNAPSHOT.jar /java-app-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "java-app-1.0-SNAPSHOT.jar"]