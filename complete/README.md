./mvnw spring-boot:run

http://localhost:8080/demo/register/user

sudo mysql --password

mysql> create database j2e_event_manager; -- Creates the new database
mysql> create user 'admin'@'%' identified by 'adminPassword'; -- Creates the user
mysql> grant all on j2e_event_manager.* to 'admin'@'%'; -- Gives all privileges to the new user on the newly created database
