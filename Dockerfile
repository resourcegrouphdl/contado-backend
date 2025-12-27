# 🏗 Etapa 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Cache de dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Código fuente
COPY src ./src
COPY frontend ./frontend
COPY src/main/frontend ./src/main/frontend

# Build Vaadin en producción
RUN mvn clean package -Pproduction -DskipTests


# 🏁 Etapa 2: Runtime
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/contado-backend-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
EXPOSE 8080

# Forma correcta ✅
ENTRYPOINT ["java", "-jar", "app.jar"]
