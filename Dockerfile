# Estágio de build
FROM ubuntu:latest AS build

# Instala dependências
RUN apt-get update && apt-get install -y openjdk-21-jdk

# Define o diretório de trabalho
WORKDIR /build

# Copia todos os arquivos do projeto para o container
COPY . .

# Dá permissão de execução ao mvnw
RUN chmod +x mvnw

# Executa o build do projeto
RUN ./mvnw clean package -DskipTests

# Estágio de execução
FROM openjdk:21-jdk-slim

# Expõe a porta da aplicação
EXPOSE 8080

# Copia o JAR gerado para o container
COPY --from=build /build/target/serie.a-0.0.1-SNAPSHOT.jar app.jar

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]