/* 
var lang = "JavaScript";
var lang = "Python";
console.log("Value using var: ",lang);


let lang2 = "JavaScript";
// let lang2 = "Python";  --->  this will be error
console.log("Value using let: ",lang2);

const pie = 3.14;
// pie = 3.47;   ---> error 
console.log("Value using const: ",pie);

//block scope - function scope

function testScope(){
	if(true){
		var x =10;
		let y =20;
		const z =30;
		console.log("From block: ",x);
		console.log("From block: ",y);
		console.log("From block: ",z);
	}
	
	console.log("From block: ",x);
//	console.log("From block: ",y);   -- these two are block scoped
// 	console.log("From block: ",z);
}

testScope();


//operators:
//arithmetic operators : +,-,*,/,%,**
//comparison operators : ==, !=, ===, !==
//== - compares values only
console.log(5=="5");  //true  - performs typeconversion
console.log(5==="5"); //false

console.log(7 != "8");  //true
console.log(7 !== "8"); //true
console.log(7 !== 8); //true

//logical operators
let age = 25;
console.log(age>18 && age<30);  //true
console.log(age>18 || age<30);  //true
console.log(!age>18);  //false

let marks = 50;
let result = marks>=50? "pass":"fail";
console.log(result);


//template literals
//-introduced on es6 - new way to create strings in js
//-more powerful and flexible than normal string

//older way
let name = "Ritu";
let message = "Hello "+name;

//template literal
let msg = `Hello ${name}`;

//String Interpolation - insert variables inside a string
//embeded expression - math, function
let a = 10;
let b = 20;
let res = `Sum: ${a+b}`;
console.log(res);

function welcome(name){
	return `Hello ${name}`;
}

let msgFun = `Message: ${welcome("Ritu")}`;
console.log(msgFun);

//multi line strings 
let msgg = `
Line1 - content
Line2 - content
Line3 - content`;
console.log(msgg);

//embed arrays and objects

let nums = [101,102,103];
console.log(`Number: ${nums}`);

let user = {
	name:"Ritu",
	age:21,
	city:"jodhpur"
}
console.log(`User data : ${user.name} aged ${user.age} lives in ${user.city}`);


//Strings:

let str = "JavaScript ES6";
console.log(str.length);
console.log(str.toLocaleLowerCase());
console.log(str.substring(0,10));
console.log(str.includes("Script"));
console.log(str.startsWith("Java"));
console.log(str.endsWith("6"));

//split and join strings

let data = "HTML, CSS, JS, React";
let topics = data.split(',');
console.log(topics);

let joined = topics.join(" | ");
console.log("Joined data: ",joined);

//replace and trim 
let msg = " Learning JS E6 in   the session .    ";
console.log(msg.trim);

console.log(msg.replace("E6","ES6"));


// Arrays:

let tech = ["Java","Python","C","Cpp"];
console.log("Technologies: ",tech);

//access elements
console.log("First Element : ",tech[0]);
console.log("First Element : ",tech.length);

//add/remove elements
tech.push("Golang");
console.log("Technologies:",tech);
tech.unshift("MySQL"); //add at start
console.log(tech);

tech.pop();
console.log(tech);
tech.shift();  //remove from first
console.log(tech);

console.log(tech.indexOf('Python'));
console.log(tech.includes("Java"));


//iterate over arrays
//for loop

for(let i=0; i<tech.length; i++){
	console.log(tech[i]);
}

//for of loop

for(let t of tech){
	console.log(t);
}

//forEachLoop
tech.forEach((t, index)=>{
	console.log(`index: ${index} - value: ${t}`);
});


//map() filter() reduce() sort()

let nums = [11,31,51,21];
let squares = nums.map(x => x**2);
console.log(squares);

let above30 = nums.filter(x => x>30);
console.log(above30);

let sumNums = nums.reduce((a,val)=> a+val,0);
console.log(sumNums);


//js sorts as strings lexicographical order
//compare function is needed to sort nums
nums.sort((a,b)=> a-b);   // asc order
console.log(nums);

nums.sort((a,b)=> b-a);   // desc order
console.log(nums);


//slice()  - extracts a portion without modifying the original array
let nums = [11,31,51,21];
let nums2 = nums.slice(1,3);
console.log(nums2);

//splice() - add/remove elemetns - modifies the original array
//aray.aplice(startindex, deleteCount, itemstoadd)
nums.splice(1,2);
console.log(nums)

nums.splice(1,0,12,34);
console.log(nums);

//concat()
let num3 = [101,201,301]
let new_nums3 = nums.concat(num3);
console.log(new_nums3);

//spread operator 
//copy one array to another, merge two arrays, add elements

let num4 = [...num3];
console.log(num4);

let nums5 = [...nums, ...num4];  //merge
console.log(nums5);

let arr = [10,20];
let newArr = [5, ...arr, 25];  //added elemtns
console.log(newArr);


//array destructuring  - extract value in variable out of an array
let tech = ["Java","Python","C","Cpp"];
let [lang1, lang2, lang3, lang4]= tech;
console.log(lang1);
console.log(lang2);
console.log(lang3);
console.log(lang4);


//skkip some value
let [a, b, ,d] = tech;
console.log(a);
console.log(b);
console.log(d);


//multidimentional arrays
let matrix = [
	[1,2,3],
	[4,5,6],
	[7,8,9]
];
console.log(matrix);

let numbers = [5,13,45,23];
let first_matched_num = numbers.find(n => n>10);
console.log(first_matched_num);

let first_matched_index = numbers.findIndex(n => n>20);
console.log(first_matched_index);

//some() - check that atleast one element matche -
console.log(numbers.some(n => n>120));

//every() - all elements should match
console.log(numbers.every(n => n%2===0));

//Array.from()  - convert to array
let str = "python";
console.log(Array.from(str)); 

let arr_of = Array.of(100,200,300,400);
console.log(arr_of);

let nested_arr = [10,[20,30],[40,50]];
//flat() - flatens the nested array
console.log(nested_arr);
console.log(nested_arr.flat(1));
console.log(nested_arr.flat(2));

//flatMap() 
let nums_n = [10,20,30];
let output = nums_n.flatMap(n => [n, n*2]);
console.log(output);

// isArray() - check if value is an array
console.log(Array.isArray([1,2,3]));
console.log(Array.isArray("python"));



//Objects - key - value pairs
let user = {
	name:"Ritu",
	age:21,
	city:"Jodhpur"
};
console.log(user.city);
console.log(user["age"]);

//update
user.city="Jaipur";
console.log(user.city);

//add new properties
user.email="rr@gmail.com";
console.log(user);

//delete
delete user.email;

console.log(user);

//objects with methods - 
let students = {
	name: "Ritu",
	marks:21,
	display: function(){
		console.log("Marks scored: ",this.marks);
	}
};
students.display(); 

//nested objects
let employee={
	name:"Ritu",
	id:101,
	address:{
		city:"Jodhpur",
		pincode:"342606",
		state:"Rajasthan"
	}
};
console.log(employee.address.city);

//array of objects - most used - hotel
let emps=[
	{id:101, name:"Emp1",email: "ee1@gma.com"},
	{id:201, name:"Emp2",email:"ee2@gmal.com"},
	{id:301, name:"Emp3",email:"ee3@gmal.com"},
	{id:401, name:"Emp4",email:"ee4@gmal.com"}
];
console.log(emps[0]);
console.log(emps[1].email);


//loop through objects
let student = {
	name:"Ritu",
	marks:95,
	course:"Compuer Science"
};

for(let key in student){
	console.log(key, " : ",student[key]);
};

//entries() - whole entry of object
console.log(Object.keys(student));
console.log(Object.values(student));
console.log(Object.entries(student));

//spread 
//copy
let student_new = {...student};
console.log(student_new);

//merge
let st = {
	email:"rr@gmail.com",
	city:"New Delhi"
};

let student_merged = {...student,...st};
console.log(student_merged);

//object destructuring
let product = {
	id: 101,
	name:"laptop",
	price:57000
};

let {id, name, price}= product;
console.log(id, name, price);

//constructor functions - create many objects
function Person(name, age, city){
	this.name=name;
	this.age=name;
	this.city = city;
};
let p1 = new Person("Ritu",21,"Jaipur");
let p2 = new Person("Anil",21,"Jodhpur");
console.log(p1,p2);

//object.freeze() - no change allowed
let obj = {a:10};
Object.freeze(obj);
obj.a = 20;
console.log(obj.a);

//seal()  - properties cannot be added or removed but can be modified
let obj2 = {b:30};
Object.seal(obj2);
obj2.b=40;
console.log(obj2.b);
obj2.c = 50;
console.log(obj2.c);

//optional chaining 
//used to avoid errors when accessing nested properties
let employee = {
	name:"Ritu",
	age:21,
	address:{
		city:"jodhpur",
		pincode:342606
	}
};
console.log(employee.address?.city);
console.log(employee.address?.pincode);


//send some data over network - JSON format
//{"name":"emp1","age":21}

//conversions - object - json -> json or json -> object

//convert object - json
let jsonStr = JSON.stringify(employee);

//JSON -> object
let obj_json = JSON.parse(jsonStr);
console.log(obj_json);



//switch ->

let num1 = 34;
let num2 = 89;
console.log("num1 = "+num1+", num2 = "+num2);
let operator = '+';
console.log("operator chosed: "+operator);
switch(operator){
	case '+': console.log(num1+num2); break;
	case '-': console.log(num1-num2); break;
	case '*': console.log(num1*num2); break;
	case '/': console.log(num1/num2); break;
	default: console.log("Not a valid choice.");
};

//while 

let data = [1,23,'abc','vb',56,true];
i=0;
l=data.length;
let new_data =[];
while(i<l){
	if (typeof data[i]=== "number") new_data.push(data[i]);
	i++;
};

console.log(new_data);

*/
