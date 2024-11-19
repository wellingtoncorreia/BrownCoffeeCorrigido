# Use uma imagem base do Java
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para a imagem
COPY target/*.jar app.jar

# Execute a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
