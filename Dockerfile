FROM openjdk:10-jre
ADD ./target/word-api.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/word-api.jar"]

EXPOSE 8080