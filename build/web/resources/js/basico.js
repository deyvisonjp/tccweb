/*!
 * Copyright 2014-2017 Materialize
 * MIT License (https://raw.githubusercontent.com/Dogfalo/materialize/master/LICENSE)
 */
function calcular(){
    var valor1 = parseInt(document.getElementById('txtNotaOri').value, 10);
    var valor2 = parseInt(document.getElementById('txtNotaAva').value, 10);
    document.getElementById('result').value = (valor1 + valor2)/2;
}

function calcular2() {
    var n1 = parseInt(document.getElementById('n1').value, 10);
    var n2 = parseInt(document.getElementById('n2').value, 10);
    document.getElementById('resultado').innerHTML = n1 + n2;
}