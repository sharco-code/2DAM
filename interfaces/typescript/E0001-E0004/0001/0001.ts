function greeter(person) {
    return "Hello, " + person;
}
let user = "Jane User";
document.body.innerHTML = greeter(user)+" <br> <p id='demo'></p>";
document.getElementById("demo").innerHTML = "Hello World!";