FROM amazoncorretto:11

RUN adduser -D -g "app" app

COPY out/artifacts/rucoy_api_main_jar/rucoy-api.main.jar app.jar

RUN chown app:app app.jar

USER app

EXPOSE 8080

CMD ["corretto-11", "-jar", "app.jar"]