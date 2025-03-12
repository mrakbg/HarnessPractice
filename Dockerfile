# Use Maven to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy project files
COPY pom.xml . 
COPY src ./src

# Build the JAR file
RUN mvn clean package

# Use a lightweight JDK image to run the app
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/CalculatorApp-1.0-SNAPSHOT.jar app.jar

# Install Nginx
RUN apt update && apt install -y nginx && rm -rf /var/lib/apt/lists/*

# Create a simple HTML file to confirm the app is running
RUN echo '<h1>Calculator App is Running</h1>' > /var/www/html/index.html

# Expose ports
EXPOSE 8080 9090

# Start both Nginx and Java application
CMD service nginx start && java -jar app.jar
