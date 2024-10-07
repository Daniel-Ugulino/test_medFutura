FROM openjdk:22-jdk-slim

WORKDIR /app

COPY target/test_medFutura-0.0.1-SNAPSHOT.jar /app/test_medFutura.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "test_medFutura.jar"]