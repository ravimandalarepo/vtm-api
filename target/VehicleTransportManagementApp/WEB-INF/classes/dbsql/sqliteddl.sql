

drop table pickup_points;

CREATE TABLE `pickup_points` (
  `id` bigint(20) NOT NULL,
  'route_id' bigint(20) not null,
  `latitude` decimal(10,2) DEFAULT NULL,
  `longitude` decimal(10,2) DEFAULT NULL,
  `vehicle_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `pickup_point_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
 );