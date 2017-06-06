drop table INSTANCE if exists;

create table INSTANCE (INSTANCE_ID varchar(36) not null, EC2_INSTANCE_ID varchar(36)  not null, INSTANCE_CLASS varchar(128) not null, ENGINE varchar(50), PORT int, STATUS varchar(50));