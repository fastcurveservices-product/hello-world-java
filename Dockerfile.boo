FROM fastcurve/java:21 AS builder
WORKDIR /home/app
ADD . /home/app/
RUN ./mvnw -Dmaven.test.skip=true clean package

FROM fastcurve/java:21 AS optimizer
WORKDIR /home/app
COPY --from=builder /home/app/target/hello-world.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract --layers --launcher


FROM fastcurve/java:21
WORKDIR /home/app
COPY --from=optimizer /home/app/dependencies/ ./
COPY --from=optimizer /home/app/spring-boot-loader/ ./
COPY --from=optimizer /home/app/snapshot-dependencies/ ./
COPY --from=optimizer /home/app/application/ ./
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
