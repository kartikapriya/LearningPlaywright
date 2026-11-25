//increment and decrement operators
let a = 1; 
console.log(a);
console.log(a++ + ++a + a++ + ++a + a++); // 1 + 3 + 3 + 5 + 5 = 17 ,
console.log(a);

let b = 0;
console.log(--b + b-- + --b + b-- + --b);
console.log(b);


//Nullishing operator
let x = null;
let y = 10;
console.log(x ?? y); // 10

let response = null;
let defaultResponse = "Default Response";
console.log(response ?? defaultResponse); // Default Response

let result = "JS";
let defaultResult = "{}";
console.log(result ?? defaultResult); // JS
