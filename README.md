# Spring-and-mysql---Event-manager-example
An example of an event manager working with spring and mysql

##Create the Database

Open a terminal (command prompt in Microsoft Windows) and open a MySQL client as a user who can create new users.

For example, on a Linux system, use the following command;

`sudo mysql --password`

This connects to MySQL as root and allows access to the user from all hosts. This is not the recommended way for a production server.

To create a new database, run the following commands at the mysql prompt:

`create database db_example;` --> Creates the new database
`create user 'springuser'@'%' identified by 'ThePassword';` --> Creates the user
`grant all on db_example.* to 'springuser'@'%';` --> Gives all privileges to the new user on the newly created database
