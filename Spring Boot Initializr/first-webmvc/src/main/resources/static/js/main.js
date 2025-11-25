
import { cToF, fToC } from "./math.js";
import log from "./log.js";

document.getElementById('btnConvert').addEventListener('click',()=>{
	const value = document.getElementById('temp').value;
	const mode = document.getElementById('mode').value;
	
	let result;
	
	if(value === ""){
		log("Please enter value");
		return;
	}
	
	if(mode === "cToF"){
		result = cToF(value);
		log(`Converted from ${value}C to ${result}F`);
	}
	else if(mode === "fToC"){
		result = fToC(value);
		log(`Converted from ${value}F to ${result}C`);
	}
	document.getElementById('output').textContent = `${result}`;
});