# Usar una imagen base con JDK 8 y Gradle
FROM maven:3.8.4-openjdk-17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Ejecutar Gradle para construir el proyecto
RUN mvn clean package

# Crear una nueva imagen basada en OpenJDK 8
FROM openjdk:17-jre-slim-buster

# Exponer el puerto que utilizará la aplicación
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/build/libs/inmobiliaria-vives-0.0.1-SNAPSHOT.jar /app/inmobiliaria-vives-0.0.1-SNAPSHOT.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/inmobiliaria-vives-0.0.1-SNAPSHOT.jar"]