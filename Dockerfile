# ── Etapa 1: Build ──────────────────────────────
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build

WORKDIR /app

# Copia o pom.xml e baixa dependências (cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e gera o JAR
COPY src ./src
RUN mvn clean package -DskipTests

# ── Etapa 2: Runtime ────────────────────────────
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Porta que a aplicação usa
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]