FROM openjdk:11
EXPOSE 8080
ADD target/e-shop.jar e-shop.jar
ENTRYPOINT ["java", "-jar", "/e-shop.jar"]