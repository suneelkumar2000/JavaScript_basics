
let map = new Map();
map.set("suneel","java");//adding value
map.set("kumar","Android");
map.set("suneel","ML");//updating value

console.log(map.keys());//to all keys

console.log(map.has("suneel"));// used to check the key is present

//to print all values 
for (let [key,value] of map){
    console.log(key," : ",value);
}
//print all values using forEach
map.forEach((value,key) =>{
    console.log(key," : ",value);
});

