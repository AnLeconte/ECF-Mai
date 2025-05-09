FROM maven:3.6.3-openjdk-11-slim AS build
LABEL maintainer="Antoine"
WORKDIR /app
RUN mkdir -p /root/.m2
COPY pom.xml .
COPY src src/
RUN mvn clean install -DskipTests -Dmaven.test.skip=true
RUN ls -la target/

FROM openjdk:11-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
