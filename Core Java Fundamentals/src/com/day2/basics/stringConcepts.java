package com.day2.basics;

public class stringConcepts {
	 
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//string- sequence of character

		//- not a primitive type 

		//declare strings and initialize srtings 

//		String str1 = "khushi bharti"; // laga literal 

//		String str2 = new String("khushi bharti"); //use constructor 

//		String str3 = "khushi bharti";

//		

//

//		//string pool - literal goes to string pool, stored in as string pool

//		//heap memory - separate memory are alloted to str2

//		//str3 - will not created separately

//		// str1 -> |java| <- str3

//		

//		//strings are also immutable- cannot be modified

//		//improved security , saves memory 

//		// many methods associated with string

//		

//		String firstname ="khushi";

//		String lastname = "bharti";

//		

//		//String concatenation +

//		String fullname = firstname + " " + lastname;

//		System.out.println("full name : " + fullname );

//		

//		//String Length 

//		System.out.println("length of name :" + fullname.length());

//		

//		//fetch character at specifc position - charAt(index)

//		System.out.println("character at index 3: "+ fullname.charAt(3));

//		

//		//fetch substring out of a string - substring(start, end)

//		System.out.println("substring(3-12) :" +fullname.substring(3,12));	

//		

//		//equals , equalsIgnoreCase - it ignores the upper and lowercase 

//		System.out.println("compare fullname with 'khushi bharti' :" +fullname.equals("khushi bharti"));

//		System.out.println("compare fullname with 'khushi bharti' :" +fullname.equalsIgnoreCase("khushi Bharti"));

//		System.out.println("compare fullname with str2 :" +fullname.equals(str2));

//		System.out.println("compare fullname with str3 :" +fullname.equals(str3));

//		System.out.println("compare fullname with str2 with str3:" +str2.equals(str3)); // comparing content

//		System.out.println("compare fullname with str1 with str3 ==:" + (str1==str3)); 

//		System.out.println("compare fullname with str2 with str3 ==:" + (str2==str3)); // comparing reference 

//		

//		//contains 

//		System.out.println("does fullname contains bharti :" +fullname.contains("bharti")); // case sensitive 

//		

//		//immutable 

//		

//		String str ="java";

//		System.out.println(" original value of str :" + str );

//		

//		//concat -> concationation

//		str.concat("Programming");

//		System.out.println("value of str :" + str ); // will not upadte the value of str 

//		

//		//actually concat with programming 

//		 str = str.concat("Programming"); // assigning 

//		 System.out.println("value of str :" + str ); // changes the value by assigning and change in reference 

//		 

		 //Application - frequent - file operations - insert , replace, delete 

		 //stringBuilder and StringBuffer - mutable sequence of character 

		 //unlike string , it can be modified  without creating new objects 

		 //synchronization -

		// StringBuilder (not synchronized, not thread safe class), faster than Stringbuffer

		 //StringBuffer - thread safe(synchronized), slightly slower than StringBuilder

		 //stringBuilder

		 StringBuilder sb = new StringBuilder("java");

		 System.out.println("original sb : " + sb );

		 sb.append(" Programming");

		 System.out.println("value of sb:" + sb);

		 sb.insert(4, ",");

		 System.out.println("value of sb:" + sb);

		 sb.replace(0, 4, "python");

		 System.out.println("value of sb:" + sb);

		 sb.delete(6, 8);

		 System.out.println("value of sb:" + sb);

		 sb.reverse();

		 System.out.println("value of sb:" + sb);

		 System.out.println("__________________");

		 //sringBuffer

		 StringBuffer sbr = new StringBuffer("java");

		 System.out.println("original sbr : " + sbr );

		 sbr.append(" Programming");

		 System.out.println("value of sbr:" + sbr);

		 sbr.insert(4, ",");

		 System.out.println("value of sbr:" + sbr);

		 sbr.replace(0, 4, "python");

		 System.out.println("value of sbr:" + sbr);

		 sbr.delete(6, 8);

		 System.out.println("value of sbr:" + sbr);

		 sbr.reverse();

		 System.out.println("value of sbr:" + sbr);
 
	

	}
 
}

 
