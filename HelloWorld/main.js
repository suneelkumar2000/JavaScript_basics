/**
 * 
 */

const myHeading = document.querySelector("h1");
myHeading.textContent = "Hello world!";

let myVariable = document.querySelector("h1");

let myButton = document.querySelector("button");
let myHeading = document.querySelector("h1");

function setUserName() {
	const myName = prompt("Please enter your name.");
	localStorage.setItem("name", myName);
	myHeading.textContent = `Hello world!, ${myName}`;
}
if (!localStorage.getItem("name")) {
	setUserName();
} else {
	const storedName = localStorage.getItem("name");
	myHeading.textContent = `Hello world!, ${storedName}`;
}

