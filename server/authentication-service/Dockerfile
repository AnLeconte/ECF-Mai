FROM maven:3.6.3-openjdk-11-slim AS build
LABEL maintainer="Antoine"
WORKDIR /app
RUN mkdir -p /root/.m2
RUN echo "=== Vérification des fichiers copiés ==="
RUN ls -la
COPY pom.xml .
RUN echo "=== Contenu du pom.xml ==="
RUN cat pom.xml
COPY src/ .
RUN echo "=== Structure des fichiers source ==="
RUN find . -type f
RUN echo "=== Début de la compilation ==="
RUN mvn clean package -DskipTests -Dmaven.test.skip=true
RUN echo "=== Contenu du répertoire target ==="
RUN ls -la target/
RUN echo "=== Liste des fichiers JAR ==="
RUN find target -name "*.jar"

FROM openjdk:11-slim
WORKDIR /app
RUN echo "=== Copie du JAR ==="
COPY --from=build /app/target/*.jar app.jar
RUN echo "=== Vérification de la présence du JAR ==="
RUN ls -la
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
