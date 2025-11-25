

-- DATABASE
create database if not exists CabBookingDB;
use CabBookingDB;


-- there are 4 tables:


-- users
create table users(

	user_id int auto_increment primary key,
	name varchar(100) not null,
	email varchar(150) not null unique,
	password varchar(200) not null,
	phone varchar(20)
	
);


-- drivers
create table drivers(

	driver_id int auto_increment primary key,
	name varchar(100) not null,
	vehicle_no varchar(50) not null,
	availability boolean default true

);

-- routes
create table if not exists routes ( 
	route_id int auto_increment primary key,
	source varchar(50) not null,
	destination varchar(50) not null, 
	distance_km int not null,
	unique(source, destination)
);


-- bookings
create table bookings(

	booking_id int auto_increment primary key,
	user_id int not null,
	driver_id int not null,
	routes_id int not null,
	source varchar(200) not null,
	destination varchar(200) not null,
	fare double not null,
	booking_time datetime default current_timestamp,
	status varchar(20) default 'Booked',
	foreign key (user_id) references users(user_id),
	foreign key (driver_id) references drivers(driver_id),
	foreign key (route_id) references routes(route_id)

);








-- triggers


-- when booking
delimiter //
create trigger set_driver_unavailable_after_booking
after insert on bookings
for each row
begin
	update drivers
	set availability = 0
	where driver_id = NEW.driver_id;
end  //
delimiter ;


-- when booking is cancelled or completed

delimiter //
create trigger set_driver_available_after_cancel
after update on bookings
for each row
begin
	if new.status = "Cancelled" or new.status = "Completed" then
		update drivers
		set availability = 1
		where driver_id = new.driver_id;
	end if;
end  //
delimiter ;


-- 