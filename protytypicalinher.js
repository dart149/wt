// Prototypal Inheritance
function Person(name, age) {
    this.name = name;
    this.age = age;
}

Person.prototype.greet = function () {
    console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
};

function Employee(name, age, job) {
    Person.call(this, name, age);
    this.job = job;
}

// Setting up inheritance and adding a new method to Employee prototype
Employee.prototype = Object.create(Person.prototype);
Employee.prototype.constructor = Employee;

Employee.prototype.work = function () {
    console.log(`${this.name} is working as a ${this.job}.`);
};

// Closure
function createCounter() {
    let count = 0;
    return function () {
        count += 1;
        return count;
    };
}

const counter = createCounter();

// Callback function
function processJob(employee, callback) {
    console.log("Processing job for", employee.name);
    callback(employee);
}

// Promises
function simulateDatabaseFetch(employeeId) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (employeeId === 1) {
                resolve(new Employee("Alice", 30, "Engineer"));
            } else {
                reject("Employee not found.");
            }
        }, 2000);
    });
}

// Async/Await with Promises
async function fetchAndGreetEmployee(employeeId) {
    try {
        const employee = await simulateDatabaseFetch(employeeId);
        employee.greet();
        employee.work();
    } catch (error) {
        console.error("Error:", error);
    }
}

// Using Prototypal Inheritance
const employee1 = new Employee("John", 28, "Designer");
employee1.greet();
employee1.work();

// Using Closure
console.log("Counter:", counter()); // 1
console.log("Counter:", counter()); // 2

// Using Callback
processJob(employee1, (emp) => {
    console.log(`${emp.name} has completed the job.`);
});

// Using Promises and Async/Await
fetchAndGreetEmployee(1); // Fetch a valid employee
fetchAndGreetEmployee(2); // Try fetching an invalid employee (to demonstrate error handling)
