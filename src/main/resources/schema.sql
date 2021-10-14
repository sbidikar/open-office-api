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
    `user_id`       varchar(20),
    `user_name`     varchar(20),
    `floor_map_id`  int(8),
    `reserved_date` date,
    PRIMARY KEY (`user_id`)
);