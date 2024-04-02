# Define base docker image
FROM adoptopenjdk/openjdk11:jre-11.0.12_7-alpine

# Set the desired heap size (128MB in this example)
ENV JAVA_OPTS="-Xmx256m"

# Copy the JAR file to the container and start the Kotlin application with the specified heap size
COPY target/kotlin-demo-0.0.1-SNAPSHOT.jar kotlin-demo.jar
ENTRYPOINT ["java", "-jar", "/kotlin-demo.jar"]

# Expose the port (if needed)
EXPOSE 8080