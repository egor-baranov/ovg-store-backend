FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle buildFatJar --no-daemon

FROM ubuntu:22.04
RUN mkdir /app
ONBUILD COPY --from=build /home/gradle/src/build/libs/*.jar /app/ovg-store-backend.jar
ENTRYPOINT ["java","-jar","/app/ovg-store-backend.jar"]
