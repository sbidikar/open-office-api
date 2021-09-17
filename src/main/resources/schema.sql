drop table if exists sys.office_floor_map;

CREATE TABLE `office_floor_map` (
                        `id` int(8) NOT NULL AUTO_INCREMENT,
                        `location` varchar(20) NOT NULL,
                        `building` varchar(20) NOT NULL,
                        `floor` varchar(20) NOT NULL,
                        `desk` varchar(20) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `desk_unique` (`desk`)
);