# Etapa 1: build da aplicação com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem final com JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]