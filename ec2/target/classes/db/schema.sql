drop table INSTANCE if exists;

create table INSTANCE (ID int, INSTANCE_ID varchar(36), IMAGE_ID varchar(128), NAME varchar(50) not null, AZ varchar(128), FLAVOR_ID varchar(128));