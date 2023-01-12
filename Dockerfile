FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle buildFatJar --no-daemon

FROM openjdk:11 AS openjdk
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/

FROM ubuntu:22.04
COPY --from=openjdk /app/ ./
ENTRYPOINT ["java","-jar","/app/ovg-store-backend.jar"]
