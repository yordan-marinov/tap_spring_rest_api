FROM openjdk:17

ADD target/transaction_service-0.0.1-SNAPSHOT.jar docker.jar

ENTRYPOINT ["java", "-jar","docker.jar"]
EXPOSE 8083