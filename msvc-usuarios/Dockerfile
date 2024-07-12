FROM openjdk:17-jdk-oracle

WORKDIR /app
# el espacio . de abajo COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
# significa que nuestra carpetaSNAPSHOT.jar se va copiar en nuestro WORKDIR /app
COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java","-jar","msvc-usuarios-0.0.1-SNAPSHOT.jar"]


