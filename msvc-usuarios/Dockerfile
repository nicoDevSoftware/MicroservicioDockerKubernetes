FROM openjdk:17-jdk-oracle
FROM maven:latest

WORKDIR /app/msvc-usuarios
# el espacio . de abajo COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
# significa que nuestra carpetaSNAPSHOT.jar se va copiar en nuestro WORKDIR /app
COPY ./pom.xml /app
COPY ./msvc-usuarios/.mvn  ./.mvn
COPY ./msvc-usuarios/mvnw ./
COPY ./msvc-usuarios/pom.xml .

RUN mvn clean package -Dmaven.test.skip  -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
# otra forma pero es mejor la de arriba= RUN mvn dependency:go-offline
COPY ./msvc-usuarios/src ./src

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java","-jar","./target/msvc-usuarios-0.0.1-SNAPSHOT.jar"]


