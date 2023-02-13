FROM openjdk:8
EXPOSE 8080
ADD target/kameleoon-trial.jar kameleoon-trial.jar
ENTRYPOINT ["java", "-jar", "kameleoon-trial.jar"]