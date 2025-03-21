FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-21-jdk maven

WORKDIR /build

COPY . .

ENV MAVEN_OPTS="-Dfile.encoding=UTF-8"

RUN ./mvnw clean package -DskipTests -Dmaven.resources.filtering=false -Dmaven.test.skip=true

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /build/target/serie.a-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]