FROM adoptopenjdk/openjdk8
EXPOSE 8080:8080
ARG WAR_FILE=build/libs/myomyo-backend-0.0.1-SNAPSHOT.war
COPY ${WAR_FILE} app.war
ENTRYPOINT [ "java", "-jar", "/app.war" ]