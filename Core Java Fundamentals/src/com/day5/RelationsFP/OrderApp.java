package com.day5.RelationsFP;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderApp {

	public static void main(String[] args) {
		
		List<Order> orders = Arrays.asList(
				new Order("order001",2000),
				new Order("order002",8000),
				new Order("order003",12000),
				new Order("order004",4500)
				);
		
		//printAllOrders
		orders.forEach(Order::printOrder);
		
		//filter out orders - amount > 5000 - using stream
		//then - convert names to upper case
		List<String> highValueOrders =  orders.stream()
				.filter(Order :: isHighValue)
				.map(o -> o.id.toUpperCase())
				.collect(Collectors.toList());
		
		System.out.println(highValueOrders);
		
		orders.stream()
		.filter(Order :: isHighValue)
		.forEach(System.out :: println);

	}

}
