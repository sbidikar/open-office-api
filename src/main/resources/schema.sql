drop table if exists office_floor_map;

create table office_floor_map
(
    id          integer      not null auto_increment,
    available   varchar(255) not null,
    building    varchar(255) not null,
    desk        varchar(255) not null,
    floor       varchar(255) not null,
    location    varchar(255) not null,
    reserved_by varchar(255) not null,
    primary key (id)
);