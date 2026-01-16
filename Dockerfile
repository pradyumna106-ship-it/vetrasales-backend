FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /savvy

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /savvy

COPY --from=build /savvy/target/*.jar app.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]

