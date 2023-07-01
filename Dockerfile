FROM openjdk:11-ea-9-jdk-slim
LABEL authors="Aakash Nakarmi"
EXPOSE 8090
ENTRYPOINT ["java", "-jar","/app.jar"]