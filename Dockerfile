FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle buildFatJar --no-daemon

FROM openjdk:11
EXPOSE 5432:5432
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/ovg-store-backend.jar
ENTRYPOINT ["java","-jar","/app/ovg-store-backend.jar"]