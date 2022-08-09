FROM openjdk:1.8
ARG JAR_FILE=target/BookMyTicketServiceRegistry-1.0.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8889