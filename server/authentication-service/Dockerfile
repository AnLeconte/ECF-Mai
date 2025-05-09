FROM maven:3.6.3-openjdk-11-slim AS build
LABEL maintainer="Antoine"
WORKDIR /app
RUN mkdir -p /root/.m2
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .
COPY mvnw.cmd .
RUN mvn dependency:resolve
RUN mvn clean install -DskipTests

FROM openjdk:11-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
