# Use OpenJDK 17 to match your project's Java version
FROM openjdk:17
# Expose port 8080 for the application
EXPOSE 8080
# Copy the jar file from your target directory into the image
COPY target/Spring-Boot-E-Shop-0.0.1-SNAPSHOT.jar e-shop.jar
# Command to run the application
ENTRYPOINT ["java", "-jar", "/e-shop.jar"]