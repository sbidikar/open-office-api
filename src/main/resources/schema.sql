drop table if exists sys.office_floor_map;
drop table if exists sys.reserved_desk;

CREATE TABLE `office_floor_map`
(
    `id`       int(8) NOT NULL AUTO_INCREMENT,
    `location` varchar(20) NOT NULL,
    `building` varchar(20) NOT NULL,
    `floor`    varchar(20) NOT NULL,
    `desk`     varchar(20) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `desk_unique` (`desk`)
);

CREATE TABLE `reserved_desk`
(
    `id`           int(8) NOT NULL AUTO_INCREMENT,
    `user_id`      varchar(20) ,
    `user`         varchar(20) ,
    `location`     varchar(20) ,
    `building`     varchar(20) ,
    `floor`        varchar(20) ,
    `desk`         varchar(20) ,
    `reserved_date` date,
    PRIMARY KEY (`id`)
);