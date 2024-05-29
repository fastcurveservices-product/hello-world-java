FROM azul/zulu-openjdk-alpine:11.0.12-jre
MAINTAINER fastcurveservices.com
COPY target/hello-world.jar hello-world.jar
ENTRYPOINT ["java","-jar","/hello-world.jar"]