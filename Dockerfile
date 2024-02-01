# Use the latest OpenJDK image as the base image
FROM openjdk:latest
# Copy the compiled Java classes from the local directory to /tmp/com in the container
COPY "./target/group7-0.1.0.3(0.1-alpha-3)-jar-with-dependencies.jar" /tmp
# Set the working directory to /tmp
WORKDIR /tmp
# Specify the entry point for the container, running the main class 'com.napier.g7.App'
ENTRYPOINT ["java", "-jar", "group7-0.1.0.3(0.1-alpha-3)-jar-with-dependencies.jar"]