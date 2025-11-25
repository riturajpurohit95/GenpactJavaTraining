/*

DOM, Events, Query Methods and Listners

document object model

- 


*/


const btnHello = document.getElementById("btn-hello"); //fastest dom query method
const btnAdd = document.querySelector('#btn-add'); //select using CSS selector 
const btnToggle = document.querySelector('#btn-toggle');
const form = document.getElementById('demo-form');
const input = document.getElementById('text-input');
const itemList = document.getElementById('items-list');
const log = document.getElementById('log');
const items = document.querySelectorAll('#items-list.item');

//Helper function - Loggin Messages
function appendLog(message){
	const time = new Date().toLocaleTimeString(); //current time 
	log.textContent += `[${time}] ${message}`;
	log.scrollTop = log.scrollHeight; //log auto-scrolls
}

//Event Listners

//1. Hello Button - Click Event
btnHello.addEventListener('click', function(ev){
	appendLog('Hello button clicked');
	alert('Hello from Hello button');
});

//2. Add Item Button - dynamically add list items
btnAdd.addEventListener('click',function(ev){
	const li = document.createElement('li'); // <li></li>
	li.className='item';
	li.textContent = 'Item'+(itemList.children.length + 1);
	itemList.appendChild(li);
	appendLog('Added: ' + li.textContent);
});

//3. Toggle 
btnToggle.addEventListener('click',()=>{
	if(input.style.display === 'none'){
		input.style.display = 'inline-block';
		appendLog("Input shown ");
	}
	else{
		input.style.display = 'none';
		appendLog('Input hidden ');
	}
});


//4. submit - form submit preventDefault
form.addEventListener('submit',function (event){
	event.preventDefault(); //prevent actucall form submission page reload
	const value = input.value.trim();
	if(value){
		appendLog('Form submitted with: '+value );
		input.value = ''; //clear the value
	}
	else{
		appendLog('Form submitted with empty input');
	}
});


// toDo btn

const btnToDo = document.getElementById("btn-task");
const inputTask = document.getElementById("task-input");
const taskList = document.getElementById("task-list");

btnToDo.addEventListener('click',()=>{
	
	const task = inputTask.value.trim();
	
	if (task === ""){
		alert("Please enter task");
	}
		else{
		const Taskli = document.createElement("li");
		
		Taskli.className = "task-item";
		Taskli.innerHTML = `${task} <button class="btn-delete">Delete</button>`;
							
		Taskli.querySelector(".btn-delete").addEventListener('click',()=>{
			Taskli.remove();
		});
		
		taskList.appendChild(Taskli);
	}
});


