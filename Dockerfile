FROM adoptopenjdk/openjdk11

RUN mkdir -p /opt/app && \
        apt-get update && \
        DEBIAN_FRONTEND=noninteractive apt-get install -y maven vim && \
	cd /opt/app

#RUN useradd app

ADD * /opt/app/

WORKDIR /opt/app

#RUN rm -rf /root/.m2/repository

RUN mvn clean package -Dmaven.test.skip=true

#RUN mvn clean package spring-boot:repackage -Dmaven.test.skip=true

RUN chown -R app:app /opt/app
    #chmod -R 755 /opt/app

USER app

#RUN mvn clean package -Dmaven.test.skip=true

EXPOSE 8080

RUN ls -la ./target/spring-boot-hello-world-1.0.0-SNAPSHOT.jar

CMD ["java", "-jar", "./target/spring-boot-hello-world-1.0.0-SNAPSHOT.jar"]