
create database if not exists ems_db
character set utf8mb4
collate utf8mb4_unicode_ci;

-- support full unicode - emoji, profile picture

use ems_db;


-- create employee table 

create table if not exists employee(
	id int auto_increment primary key,
	name varchar(30) not null,
	email varchar(50) not null unique,
	is_active boolean not null default true, 
	profile_pic longblob default null,  -- longblob - binary large object, allow large images
	salary decimal(12,2) default null,
	hire_date date default null,
	last_login timestamp default null   -- date+time -> often - last login/activity
	-- java.time.localdatetime
);

