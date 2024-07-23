FROM openjdk:17-jdk-oracle
FROM maven:latest

WORKDIR /app/msvc-usuarios
# el espacio . de abajo COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
# significa que nuestra carpetaSNAPSHOT.jar se va copiar en nuestro WORKDIR /app
COPY ./pom.xml /app
COPY ./msvc-usuarios .

RUN mvn clean package -DskipTests



EXPOSE 8001

ENTRYPOINT ["java","-jar","./target/msvc-usuarios-0.0.1-SNAPSHOT.jar"]


