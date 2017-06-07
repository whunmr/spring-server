drop table INSTANCE if exists;

create table INSTANCE (INSTANCE_ID varchar(36) not null, EC2INSTANCE_ID varchar(36) not null, INSTANCE_CLASS varchar(128) not null, ENGINE varchar(50), PORT int, AVAILABLE_ZONE varchar(50) not null, SOURCE_DBID varchar(36) not null, STATUS varchar(50));
create table SNAPSHOT (SNAPSHOT_ID varchar(36) not null, INSTANCE_ID varchar(36) not null);
