# Use the latest OpenJDK image as the base image
FROM openjdk:latest
# Copy the compiled Java classes from the local directory to /tmp/com in the container
COPY ./target/group7.jar /tmp
# Set the working directory to /tmp
WORKDIR /tmp
# Specify the entry point for the container, running the main class 'com.napier.g7.App'
ENTRYPOINT ["java", "-jar", "group7.jar", "db:3306", "30000"]