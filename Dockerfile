FROM openjdk:17-alpine3.14
ARG JAR_FILE=target/*.jar
COPY ./target/restSqlShopApi-0.0.1-SNAPSHOT.jar restSqlShopApi.jar
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/restSqlShopApi.jar"]
