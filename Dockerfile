FROM adoptopenjdk/openjdk11

RUN mkdir -p /opt/app

RUN useradd app

ADD target/spring-boot-hello-world-1.0.0-SNAPSHOT.jar /opt/app/

WORKDIR /opt/app

RUN chown -R app:app /opt/app

USER app

EXPOSE 8080

CMD ["java", "-jar", "spring-boot-hello-world-1.0.0-SNAPSHOT.jar"]