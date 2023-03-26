# Multi module maven project 

#### This project is a web application that allows you to register users, change their parameters, delete them and view each one separately. 
#### The site uses a Maven multi-module architecture in Java.
#### Spring Boot 2 is technology were used to implement the functionality of the site. 
#### With this application, you can manage users and control access to various functions of the site. 
#### All data is stored in a database MySQL.

### Build application:

- Run docker-compose file
- After build open terminal in main folder and use command: docker exec -it mysql8 -uroot -proot
- In mysql console run next commands:
1. create database usertask;
2. use usertask;
3. source docker/mysql/schema.sql;
4. source docker/mysql/data.sql;
- Run Application class in client-api/src/main/java/com/it_academy/client

### Open in browser on localhost port 8080