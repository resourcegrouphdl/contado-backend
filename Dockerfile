# 🏁 Etapa 1: Construcción (Build)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copiar el pom.xml
COPY pom.xml .
RUN mvn dependency:go-offline -B
# Copiar el código fuente
COPY src ./src
COPY frontend ./frontend
RUN mvn -B clean package -Pproduction -DskipTests
# 🏁 Etapa 2: Imagen final ligera
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copiar el .jar construido desde la etapa anterior
COPY --from=build /app/target/contado-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080


# forzar modo producción de Vaadin al ejecutar el JAR
ENTRYPOINT ["java", "-Dvaadin.productionMode=true", "-jar", "app.jar"]
