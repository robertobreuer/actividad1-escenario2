# Dockerfile
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN addgroup -g 1001 spring && adduser -S spring -u 1001
USER spring
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
