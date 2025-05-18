FROM fastcurve/java:21 AS builder

WORKDIR /home/app
ADD . /home/app/
RUN ./mvnw -Dmaven.test.skip=true clean package

FROM fastcurve/java:21
WORKDIR /home/app
COPY --from=builder /home/app/target/hello-world.jar hello-world.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/hello-world.jar"]