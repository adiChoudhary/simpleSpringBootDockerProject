# Simple Spring Project with Docker

- Create a simple spring project
- install docker
  - Create docker file
  - run build
    - sudo docker build -t simple-docker-project:1.0 .
  - listing images
    - sudo docker images  
  - run container
    - sudo docker run -p 8000:8080 simple-docker-project:1.0 
      - sudo docker run -p [portOnSystem:portOnContainer] simple-docker-project:1.0 