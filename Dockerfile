FROM openjdk:8
#COPY /target /myapp
#WORKDIR /myapp

VOLUME /myapp
WORKDIR /myapp
ADD /target/simpleDockerProject-0.0.1-SNAPSHOT.jar app.jar
# directly runs
# RUN ["java","-jar", "simpleDockerProject-0.0.1-SNAPSHOT.jar"]
# runs when container is started
EXPOSE 8080
CMD ["java","-Dspring.data.mongodb.uri=mongodb://mongo_db:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false","-Dspring.data.mongodb.database=employee","-jar", "app.jar"]