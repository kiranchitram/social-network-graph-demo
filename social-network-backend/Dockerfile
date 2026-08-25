FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY . .

# Ensure mvnw is executable
RUN chmod +x mvnw

# Build with Maven Wrapper
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/social-network-backend-0.0.1-SNAPSHOT.jar"]
