FROM eclipse-temurin:21
WORKDIR /app
COPY target/genie-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","genie-0.0.1-SNAPSHOT.jar"]