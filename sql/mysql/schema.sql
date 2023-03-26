/*
drop table users;
drop table roles;
*/

create table roles(id int not null auto_increment primary key, name varchar(40) unique not null);

create table users(id bigint not null auto_increment primary key, firstname varchar(20), lastname varchar (40),patronymic varchar(40), email varchar(40) unique not null, role_id int);