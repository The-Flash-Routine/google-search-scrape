FROM gradle:7.1.0-jdk11

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files (build.gradle, settings.gradle) and the source code into the container
COPY build.gradle .
COPY settings.gradle .
COPY src ./src

# Build the application using Gradle
RUN gradle build

# Expose the port that the Spring Boot application will run on (usually 8080)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "build/libs/google-search-scrape-1.0-SNAPSHOT.jar"]