FROM openjdk:8
EXPOSE 8080
ADD target/logging.jar logging.jar 
ENTRYPOINT ["java","-jar","/logging.jar"]
