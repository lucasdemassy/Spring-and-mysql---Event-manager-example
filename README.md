# Spring-and-mysql---Event-manager-example
An example of an event manager working with Spring and MySQL

## Create the Database

Open a terminal (command prompt in Microsoft Windows) and open a MySQL client as a user who can create new users.

For example, on a Linux system, use the following command;

1. `sudo mysql --password`

This connects to MySQL as root and allows access to the user from all hosts. This is not the recommended way for a production server.

To create a new database, run the following commands at the mysql prompt:

2. `create database j2e_event_manager;` --> Creates the new database

3. `create user 'admin'@'%' identified by 'adminPassword';` --> Creates the user

4. `grant all on j2e_event_manager.* to 'admin'@'%';` --> Gives all privileges to the new user on the newly created database

## Access the event manager
1. `cd complete`
2. `./mvnw spring-boot:run`
3. `http://localhost:8080/demo/register/event`
