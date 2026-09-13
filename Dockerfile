FROM amazoncorretto:11 AS build

WORKDIR /app

RUN yum install -y findutils \
    && yum clean all

COPY gradlew ./
COPY gradle ./gradle

RUN chmod +x ./gradlew

COPY . .

RUN ./gradlew build --no-daemon


FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENV JAVA_OPTS="-Xms64m -Xmx450m -XX:+UseZGC -XX:MaxMetaspaceSize=128m -XX:CompressedClassSpaceSize=32m -XX:+HeapDumpOnOutOfMemoryError -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=35 -Xlog:gc*:file=gc.log:time,uptime,level,tags:filecount=5,filesize=10m -Xss512k"

EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
