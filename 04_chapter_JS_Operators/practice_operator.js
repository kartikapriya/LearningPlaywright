
let value = 5 ** 2; // exponentiation operator
console.log(value);

//comparison operators
let c = 1;
let d = "1";

console.log(c === d); // false
console.log(c == d); // true    

// ternary operator
c === d  ? console.log("c and d are equal") : console.log("c and d are not equal"); 
c == d  ? console.log("c and d are equal") : console.log("c and d are not equal"); 

typeof c === typeof d  ? console.log("c and d are of same type") : console.log("c and d are not of same type");
typeof c == typeof d  ? console.log("c and d are of same type") : console.log("c and d are not of same type");

c !== d  ? console.log("c and d are not equal") : console.log("c and d are equal");
c != d  ? console.log("c and d are not equal") : console.log("c and d are equal");

//Logical operators
let e = true;
let f = false;  
console.log(e && f); // false
console.log(e || f); // true
console.log(!e); // false

