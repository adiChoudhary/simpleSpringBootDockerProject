FROM openjdk:11
COPY /target myapp/
WORKDIR myapp/
# directly runs
# RUN ["java","-jar", "simpleDockerProject-0.0.1-SNAPSHOT.jar"]
# runs when container is started
EXPOSE 8080
CMD ["java","-jar", "simpleDockerProject-0.0.1-SNAPSHOT.jar"]