FROM openjdk:8-jdk-alpine
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
ENTRYPOINT java -jar ./target/mail-service.jar