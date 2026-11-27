//switch statement

let gradeValue = 91;
if(gradeValue<0 || gradeValue>100){
    console.log("Invalid Grade");
}else{
switch(gradeValue){
    case gradeValue>90 && gradeValue<=100: console.log("A");break;
    case gradeValue>80 && gradeValue<=90: console.log("B");break;
    case gradeValue>70 && gradeValue<=80: console.log("C");break;
    case gradeValue>60 && gradeValue<=70: console.log("D");break;
    case gradeValue>50 && gradeValue<=60: console.log("E");break;
    default: console.log("FAIL");
    }
}