DROP DATABASE IF EXISTS `Student_Database`;
CREATE DATABASE `Student_Database`;
USE `Student_Database`; 

CREATE TABLE student(
sid int auto_increment,
firstname varchar(40) NOT NULL,
lastname varchar(40) NOT NULL,
DOB DATE NOT NULL,
PRIMARY KEY(sid)
);

CREATE TABLE enrolledIn(
sid int NOT NULL,
cid int NOT NULL,
FOREIGN KEY(sid) REFERENCES Student(sid),
FOREIGN KEY (cid) REFERENCES course(cid)
);

CREATE TABLE course(
startDate DATE NOT NULL,
endDate DATE NOT NULL,
timeOfDay time NOT NULL,
daysOfWeek CHAR(5) NOT NULL,
cname varchar(40) NOT NULL,
cid int auto_increment,
Primary Key(cid)
);

CREATE TABLE takesPlace(
cid int NOT NULL,
uname varchar(40) NOT NULL,
FOREIGN KEY(cid) REFERENCES course(cid),
FOREIGN KEY(uname) REFERENCES university(uname)
);

CREATE TABLE university(
adress varchar(40) NOT NULL,
uname varchar(40),
rank int,
PRIMARY KEY(uname)
);

CREATE TABLE has(
cid int NOT NULL,
iid int NOT NULL,
FOREIGN KEY(cid) REFERENCES course(cid),
FOREIGN KEY(iid) REFERENCES Instructor(iid)
);

CREATE TABLE instructor(
firstname varchar(40) NOT NULL,
lastname varchar(40) NOT NULL,
iid int auto_increment,
PRIMARY KEY(iid)
);

CREATE TABLE TA(
iid int NOT NULL,
FOREIGN KEY(iid) REFERENCES instructor
);

CREATE TABLE Professor(
iid int NOT NULL,
FOREIGN KEY(iid) REFERENCES instructor
);