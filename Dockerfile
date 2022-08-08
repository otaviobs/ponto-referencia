FROM maven:3.6.3-jdk-13 AS build
WORKDIR /home/app/
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn clean package -DskipTests

FROM openjdk:13-jdk-oracle
ARG PORT
COPY --from=build /home/app/target/pontoReferencia-service.jar /usr/local/lib/pontoReferencia-service.jar
ENTRYPOINT [ "java", "-jar", "/usr/local/lib/pontoReferencia-service.jar" ]