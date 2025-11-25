package com.day5.RelationsFP;

public class RelationsConcepts {

	public static void main(String[] args) {
		
		
		//Association 
		// - has - a relationship where objects are aware of each other and they can interact
		// - but they do not own the other
		// - student can enroll in some course
		// - each object can exist independently
		// - student class obj , course class obj , enroll is relation
		// - student (enroll) course
		// - loose coupling - connected and related but are independent
		// - bankAcc - you can have many accs
		// - person
		
		
		//Aggregation
		// - speacial form of association
		// - represent a whole-part relationship
		// - part can exist independently of the whole
		// - whole has reference  to parts but it does not own them
		// - Department (whole) - professor (part)
		// - week relationship/ ownership
		// - department is not owning the professor
		// - 
		
		
		//Composition
		//- strong form of aggregation
		//-  whole owns the part
		// - whole is responsible for the lifecycle of the parts
		// - there is strong ownership
		// - ex - house - rooms , cannot exist without house
		// - ex - smartphone - sim card, ..
		
		// - ex - car(whole) - engine(part) -> composition
		

	}

}
