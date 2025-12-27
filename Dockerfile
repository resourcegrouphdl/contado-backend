FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copiar el pom.xml y descargar dependencias primero (cacheo)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Instalar Node.js (Node 18) en la etapa de build
RUN apt-get update && apt-get install -y curl gnupg2 ca-certificates \
  && curl -fsSL https://deb.nodesource.com/setup_18.x | bash - \
  && apt-get install -y nodejs \
  && node -v && npm -v


# Copiar el código fuente
COPY src ./src
COPY frontend ./src/main/frontend

# Construir el .jar
RUN mvn clean package -DskipTests -Pproduction
# 🏁 Etapa 2: Imagen final ligera
FROM eclipse-temurin:17-jdk
WORKDIR /app
# Copiar el .jar construido desde la etapa anterior
COPY --from=build /app/target/contado-backend-0.0.1-SNAPSHOT.jar app.jar
ENV PORT 8080
EXPOSE 8080
# Ejecutar la aplicación
#ENTRYPOINT ["java", "-jar", "app.jar"]
#ENTRYPOINT ["sh", "-c", "exec java -jar app.jar"]
ENTRYPOINT ["sh", "-c", "exec java -Dvaadin.productionMode=true -jar app.jar --server.port=${PORT}"]
