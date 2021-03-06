# Simple Spring Project with Docker

- [X] Create a simple spring project
- [X] install docker
  - Create docker file
  - run build
    - sudo docker build -t simple-docker-project:1.0 .
  - listing images
    - sudo docker images  
  - run container
    - sudo docker run -p 8000:8080 simple-docker-project:1.0 
      - sudo docker run -p [portOnSystem:portOnContainer] simple-docker-project:1.0 
    - sudo docker exec -it 72bdc0dfd20b  /bin/sh
      - executing given container in shell
- [ ] create a simple mongodb project
  - [X] add an employee class
  - [X] create crud operations for it
    - [X] getEmployees
    - [X] getEmployeesWithNameAndId
    - [X] addEmployee
    - [ ] deleteEmployee
    - [ ] updateEmployee
  - [ ] add rest features to it
- [X] use docker compose to deploy
  - [X] mongodb container
  - [X] springboot container  
  - notes
    - creating a volume overrides the create jar if they have the same name
  - process
    - create a docker-compose.yml file
    - run it with
      - docker-compose build
      - docker-compose up --force-recreate
      - these steps are imp otherwise u will be running old dockerfile
    - to see what is currently running 
      - docker-compose ps
- [ ] Add swagger support
- [ ] Add logging
- [ ] Check for log4j vulnerability
- [ ] Use consul
- [ ] Correct version error
- [ ] learn about why and how volumes are used
- [ ] learn to use kubernetes to do the same stuff done with docker-compose
    
