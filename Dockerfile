# ====== Stage 1: Build the application ======
FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /savvy

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests


# ====== Stage 2: runtime ======
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /savvy

COPY --from=build /savvy/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
