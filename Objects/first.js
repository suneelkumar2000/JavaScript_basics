// The functions in object are called as method.

let laptop = {
    cpu: 'i9',
    ram: 16,
    brand: 'HP',

    greet: function(){
        console.log('Hello World');
    }
}

laptop.greet();