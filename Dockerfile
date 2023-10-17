FROM openjdk:11-jdk-alpine

RUN adduser -D -g "app" app

COPY target/rucoy-api.jar app.jar

RUN chown app:app app.jar

USER app

EXPOSE 8081

CMD ["corretto-11", "-jar", "app.jar"]