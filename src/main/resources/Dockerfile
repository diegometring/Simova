# Imagem base do Java
FROM eclipse-temurin:17-jdk-alpine

# Define diretório de trabalho dentro do container
WORKDIR /app

# Copia o jar gerado para dentro do container
COPY build/libs/*.jar app.jar

# Porta que a aplicação usa
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
