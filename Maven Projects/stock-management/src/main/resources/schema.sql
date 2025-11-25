
create database inventory_db;
use inventory_db;


-- inventory table --
create table items(
	id bigint auto_increment primary key,
	name varchar(30) not null,
	description text,
	unit_price decimal(12,2) not null default 0.0,
	quantity int not null default 0,
	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp on update current_timestamp

);


-- sample data --
insert into items(name, description, unit_price, quantity)
values
('bluetooth mouse',"wireless mouse",1500.00,20),
('usb-c cable',"usb-c to usb-c cable connector",500.00,50),
('AA batteries pack',"pack of 4 AA batteries",600.00,100);


--    --
