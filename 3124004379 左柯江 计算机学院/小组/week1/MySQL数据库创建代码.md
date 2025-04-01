```mysql
`users``users``students``student_courses``courses``students``users``users``student_courses`
CREATE DATABASE `week1`;

USE `week1`;

CREATE TABLE `users`(
`name` VARCHAR(20) NOT NULL PRIMARY KEY,
`password` INT(10),
`role` VARCHAR(20)

)ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `students`(
`name` VARCHAR(10) NOT NULL PRIMARY KEY,
`users``courses``student_courses``students`
`phone` INT(10)

)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `courses`(
`course_name` VARCHAR(10) NOT NULL PRIMARY KEY,

`credithour` INT(10),
`start_date` DATE

)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `student_courses`(
`student_name` VARCHAR(10) ,

`course_name` VARCHAR(10)

)ENGINE=INNODB DEFAULT CHARSET=utf8


INSERT INTO `students` (`name`) VALUES('梨花'),('新华');


INSERT INTO `courses` (`course_name`,`credithour`,`start_date`) VALUES ('数学','3','2025-4-9'),('语文','3','2025-4-9'),('英语','3','2025-4-9');
INSERT INTO `courses` (`course_name`,`credithour`,`start_date`) VALUES ('化学','3','2025-3-2');


```

