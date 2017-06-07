drop table INSTANCE if exists;

create table INSTANCE (ID int, INSTANCE_ID varchar(36), NAME varchar(50) not null, FLAVOR_ID varchar(128), STATUS varchar(50));

create table FLAVOR (FLAVOR_ID varchar(128), vCPU int, MEM_IN_GIB float, constraint pk_flavor primary key (FLAVOR_ID));

INSERT INTO FLAVOR VALUES ('m3.medium', 1, 3.75);
