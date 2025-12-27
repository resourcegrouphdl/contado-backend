FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el pom.xml y descargar dependencias primero (cacheo)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src



# Construir el .jar
RUN mvn clean package -DskipTests -Pproduction

COPY frontend ./frontend

# 🏁 Etapa 2: Imagen final ligera
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el .jar construido desde la etapa anterior
COPY --from=build /app/target/contado-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]


