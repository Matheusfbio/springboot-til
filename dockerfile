# Build stage: uses full JDK to compile and package the application
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
# Copy Maven wrapper and pom.xml to download dependencies first (layer caching)
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
# Copy source code and build the JAR, skipping tests
COPY src/ src/
RUN ./mvnw package -DskipTests

# Runtime stage: uses lightweight JRE only to run the app
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copy only the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
