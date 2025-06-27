# Etapa de build com Maven e JDK 24 (pouco estável)
FROM maven:3.9.6-eclipse-temurin-24 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem final com JAR
FROM eclipse-temurin:24-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]