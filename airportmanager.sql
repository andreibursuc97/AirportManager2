CREATE DATABASE  IF NOT EXISTS `airport-schedule`; 
USE `airport-schedule`;

/*DROP TABLE IF EXISTS `student`;*/

CREATE TABLE IF NOT EXISTS Administrator
(id int unique auto_increment primary key,
username char(20),
password_admin BINARY(32)
);


CREATE TABLE IF NOT EXISTS Clients
(id int unique auto_increment primary key,
username char(20),
nume char(20),
password_client BINARY(32)
);

CREATE TABLE IF NOT EXISTS City
(id int unique auto_increment primary key,
city_name char(20),
longitude char(20),
latitude char(20)
);

CREATE TABLE IF NOT EXISTS Flight
(id int unique auto_increment primary key,
airplane_type char(20),
departure_city_id int,
departure_date char(20),
arrival_city_id int,
arrival_date char(20),
foreign key (departure_city_id) references City(id),
foreign key (arrival_city_id) references City(id)
);

insert into administrator(username,password_admin) values('admin',X'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

insert into City(city_name,longitude,latitude) values("New York","-74.0059","40.7127"),
("San Francisco","-122.416667","37.783333");

insert into Flight(airplane_type,departure_city_id,departure_date,arrival_city_id,arrival_date)
values ("airbus",1,"2018-11-11 13:23:44",2,"2018-11-11 19:23:44"),
	   ("airbus",2,"2018-12-11 13:23:44",2,"2018-12-11 19:23:44");