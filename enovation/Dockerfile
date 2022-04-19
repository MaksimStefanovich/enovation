# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.8.5-jdk-11 AS MAVEN_BUILD
WORKDIR /app
# copy the pom and src code to the container
COPY src ./src
COPY pom.xml ./


# package our application code
RUN mvn clean package

# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:11-jre

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /app/target/enovation-0.0.1-SNAPSHOT.jar /run
WORKDIR /run

# set the startup command to execute the jar
CMD ["java", "-jar", "enovation-0.0.1-SNAPSHOT.jar"]