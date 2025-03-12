# Use Maven to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy all project files
COPY . .

# Build the JAR file
RUN mvn clean package

# Use a lightweight JDK image to run the app
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
