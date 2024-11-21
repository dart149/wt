
function Animal(name) {
    this.name = name;
}
Animal.prototype.speak = function () {
    console.log(`${this.name} makes a noise.`);
};

function Dog(name, breed) {
    Animal.call(this, name);
    this.breed = breed;
}
Dog.prototype = Object.create(Animal.prototype);
Dog.prototype.constructor = Dog;
Dog.prototype.speak = function () {
    console.log(`${this.name} barks!`);
};

const myDog = new Dog("Buddy", "Golden Retriever");
myDog.speak(); 

function counter() {
    let count = 0;
    return function () {
        count++;
        console.log(`Count: ${count}`);
    };
}
const increment = counter();
increment(); 
increment(); 

function fetchData(callback) {
    setTimeout(() => {
        console.log("Fetching data...");
        const data = { id: 1, name: "John Doe" };
        callback(data);
    }, 1000);
}
function displayData(data) {
    console.log("Data received:", data);
}
fetchData(displayData); 


function fetchDataPromise() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("Fetching data with Promise...");
            const data = { id: 2, name: "Jane Doe" };
            resolve(data);
        }, 1000);
    });
}
fetchDataPromise()
    .then((data) => {
        console.log("Promise resolved with data:", data);
    })
    .catch((error) => {
        console.log("Promise rejected with error:", error);
    });

async function fetchDataAsync() {
    try {
        const data = await fetchDataPromise();
        console.log("Data fetched with async/await:", data);
    } catch (error) {
        console.log("Error with async/await:", error);
    }
}
fetchDataAsync();

