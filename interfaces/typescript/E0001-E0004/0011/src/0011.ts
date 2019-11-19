setTimeout( function() {
    var xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://www.google.es", true);
    xhttp.send();

    xhttp.onload = function() {
        console.log("Ha funcionadio")
    }

    xhttp.onerror = function() {
        console.log("No ha funcionado")
    }
}

, 3000) //Espera 3 segundos para ejecutar la funcion
