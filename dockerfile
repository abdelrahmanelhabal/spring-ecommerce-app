FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml . 
COPY database .
COPY /src /app/src

RUN mvn clean package

FROM tomcat:9.0-jdk17

WORKDIR /usr/local/tomcat/webapps/

COPY --from=build /app/target/spring-ecommerce-app.war ./ROOT.war 


EXPOSE 8080

CMD ["catalina.sh" , "run"]