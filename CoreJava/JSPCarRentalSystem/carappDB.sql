create database if not exists carapp;

use carapp;

create table if not exists cars(
cid int auto_increment primary key,
carname varchar(30) not null,
cartype varchar(30) not null,
carcompany varchar(30) not null,
carcity varchar(30) not null,
carnumber varchar(30) not null,
priceperday double not null,
cardescription varchar(100) not null,
issustatus varchar(30) not null
);

alter table cars add issustatus varchar(30) not null;
insert into cars values(10,"Lamborghini","STATION WAGON","Tata Motors","Tumakur""m091",500.0,"testing","Available");


select * from cars;

create table if not exists customers(
customer_id int auto_increment primary key,
customer_name varchar(30) not null,
customer_mobile varchar(30) not null,
customer_email varchar(30) not null,
city varchar(30) not null,
state varchar(30) not null,
pincode varchar(10) not null,
address varchar(100) not null
);

select * from customers;
delete from customers where customer_id in(2,5,6,7);


create table if not exists employee(
empid int auto_increment primary key,
empfname varchar(30) not null,
empmname varchar(30) not null,
emplname varchar(30) not null,
gender varchar(30) not null,
date_Of_birth varchar(30) not null,
nationality varchar(20) not null,
email varchar(30) not null,
mobile varchar(20) not null,
address varchar(100) not null,
city varchar(30) not null,
state varchar(30) not null,
pincode varchar(10) not null,
username varchar(30) not null,
password varchar(30) not null
);


select * from employee;

delete from employee where empid in(3,4);

create table if not exists user(
uid int auto_increment primary key,
name varchar(30) not null,
user_mobile varchar(30) not null,
email varchar(30) not null,
password varchar(30) not null,
state varchar(30) not null,
city varchar(30) not null,
pincode varchar(10) not null,
address varchar(100) not null
);


create table if not exists carbook(
bookingid int auto_increment primary key,
carid int not null,
name varchar(30) not null,
mobile varchar(30) not null,
email varchar(30) not null,
fromdate varchar(30) not null,
todate varchar(30) not null,
pickupaddress varchar(100) not null,
dropaddress varchar(100) not null,
userid int not null
);
alter table carbook add carid int not null;
delete from carbook where bookingid=38;

select * from user;
select * from carbook;
select * from cars;
update cars set issustatus="Available" where cid in(8);

update cars set cardescription="6 members can travel" where cid in(13);

