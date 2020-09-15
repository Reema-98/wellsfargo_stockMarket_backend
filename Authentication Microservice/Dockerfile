FROM openjdk:8-jre-alpine
EXPOSE 8080
ADD target/docker-jenkins-spring.jar docker-jenkins-spring.jar
ENTRYPOINT ["java", "-jar", "/docker-jenkins-spring.jar"]
