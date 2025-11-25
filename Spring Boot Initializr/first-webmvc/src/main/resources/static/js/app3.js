
/*

Promises = async, await, fetch, try......catch

JavaScript - single threaded - it can do only one thing at a time

jsonplaaceholder - fake and free api 

 */
 
 
 const btnLoad = document.getElementById("btnLoad");
 const statusEl = document.getElementById('status');
 const usersList = document.getElementById('usersList');
 const addForm = document.getElementById('addForm');
 const resultEl = document.getElementById('result');
 
 const API_Base = 'https://jsonplaceholder.typicode.com';
 
 //helper : show status message
 function setStatus(text){
	statusEl.textContent = text;
}

//helper : append a single user to the list
function appendUser(user){
	const li = document.createElement('li');
	li.textContent = `${user.id ? user.id + ' - ':''} ${user.name}  ${user.email}`;
	usersList.append(li);
}


//async - get users

async function fetchUsers(){
	setStatus('Loading Users....');
	try{
		const response = await fetch(`${API_Base}/users`);
		
		if(!response.ok){
			throw new Error('Server response with ${response.status} ${response.statusText}');
		}
		
		const users = await response.json();
		
		usersList.innerHTML = '';
		
		users.forEach(user => appendUser(user));
		setStatus(`Loaded ${users.length} users`);
	}
	catch(error){
		console.log('fetchUsers : ',error);
		setStatus('Error loading users : ',error.message);
	}
}

btnLoad.addEventListener('click',()=>{
	fetchUsers();
})

// post 

async function createUser(payLoad){
	setStatus('Sending new user to the server...');
	try{
		const response = await fetch(`${API_Base}/users`,{
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(payLoad)
		});
		
		if(!response.ok){
			throw new Error('Server response with ${response.status} ${response.statusText}');
		}
		
		const created = await response.json();
		
		resultEl.textContent = 'Created user {server response}: '+JSON.stringify(created);
		setStatus('User created successfully...');
		
		appendUser(created);
		return created;
	}
	catch(error){
		console.log('Careat Users error : ',error);
		setStatus('Error creating user : ',error.message);
		throw error;
	}
}

addForm.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	const name = document.getElementById('name').value.trim();
	const email = document.getElementById('email').value.trim();
	
	createUser({name, email});
})


