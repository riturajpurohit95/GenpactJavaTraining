package com.restapiproject.hotelManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}

}



/*
 * REST API -
 * 
 * created project using spring initializr
 * 
 * created hotelmgmt_db in database and then hotels table 
 * mysql> create table hotels(
    -> id BIGINT auto_increment primary key,
    -> name varchar(50) not null,
    -> address varchar(100) not null,
    -> total_rooms int not null,
    -> available_rooms int not null,
    -> price_per_night decimal(12,2) not null,
    -> created_at timestamp default current_timestamp,
    -> updated_at timestamp default current_timestamp on update current_timestamp
    -> );
    
    
 * 
 * application.properties-  set the datasource and port
 * 
 * then created the package structure - controller, repository, dto, service, model, util, exception
 * 
 * then created Hotel model class
 * 
 * then created HoletDto - data transfer object - used for communication between layers (controller , service, client layers)
 * dto - also used to validate user input without exposing internal database structure
 * also - makes api independent of database changes
 * customizable - what data goes out and what comes in
 * 
 * postman/frontend -> controller layer (accept HotleDto) -> validation happens 
 * 																	|
 * 				return response		<-	response layer		<-	 service layer
 * 	convert hotel entity to hoteldto    save entry in db	   (convert HotelDto -> Hotel entity)
 * 						
 * then created HotelRowMapper class
 * 
 * then created HotelDao interface		
 * 
 * then created HotelDaoImplement - write operations like crud - directly interact with database	
 * 
 * 
 * 
 * open postman -> enter url  http://localhost:9090/api/hotels -> choose post -> body -> raw -> json
 * then enter ->   {
    "name":"Taj Palace",
    "address":"New Delhi",
    "totalRooms":100,
    "availableRooms":45,
    "pricePerNight":5500
	}					
 * 
 */