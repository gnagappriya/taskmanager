create database concretepage;

use  concretepage;




CREATE TABLE IF NOT EXISTS `parent_task_table` (
 
  `parent_id` int(5) NOT NULL AUTO_INCREMENT,
  `parent_task` varchar(100) ,
  
  PRIMARY KEY (`parent_id`)
);
CREATE TABLE IF NOT EXISTS `task_table` (
	`id` int(5) NOT NULL AUTO_INCREMENT,
  `task_id` int(5) ,
  `parent_id` int(5),
  `task` varchar(100) ,
  `start_date` varchar(100) ,
  `end_date` varchar(100) ,
  `priority` int(5),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`parent_id`) REFERENCES parent_task_table(`parent_id`)
  
  
);

select * from parent_task_table;

SELECT * from task_table;