# define base docker image
FROM openjdk:11
LABEL maintainer="Nick Ang"
ADD target/kotlin-demo-0.0.1-SNAPSHOT.jar kotlin-demo.jar
ENTRYPOINT ["java", "-jar", "kotlin-demo.jar"]
EXPOSE 8080