# ====================== Stage 1: Build the Spring Boot App ======================
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /savvy

# Copy the Maven descriptor and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy application source code
COPY src ./src

# Build the application (skip tests for faster build)
RUN mvn clean package -DskipTests



# ====================== Stage 2: Runtime Image ======================
FROM eclipse-temurin:17-jdk-alpine

# Set app directory inside container
WORKDIR /savvy

# Copy the JAR file built in Stage 1
COPY --from=build /savvy/target/*.jar app.jar

# Expose the application port (default Spring Boot port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

