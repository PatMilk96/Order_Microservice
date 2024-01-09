FROM openjdk:19
WORKDIR /app
COPY target/Order_Microservice-0.0.1-SNAPSHOT.jar /app
EXPOSE 8082
CMD ["java", "-jar", "Order_Microservice-0.0.1-SNAPSHOT.jar"]