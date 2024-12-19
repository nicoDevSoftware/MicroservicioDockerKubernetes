FROM openjdk:17-jdk-oracle
FROM maven:latest

WORKDIR /app/msvc-cursos
# el espacio . de abajo COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
# significa que nuestra carpetaSNAPSHOT.jar se va copiar en nuestro WORKDIR /app
COPY ./pom.xml /app
COPY ./msvc-cursos/.mvn  ./.mvn
COPY ./msvc-cursos/mvnw ./
COPY ./msvc-cursos/pom.xml .

RUN mvn clean package -Dmaven.test.skip  -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
# otra forma pero es mejor la de arriba= RUN mvn dependency:go-offline
COPY ./msvc-cursos/src ./src

RUN mvn clean package   -DskipTests

EXPOSE 8002

CMD ["java","-jar","./target/msvc-cursos-0.0.1-SNAPSHOT.jar"]


