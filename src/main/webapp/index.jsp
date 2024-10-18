<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora JSP</title>
    <link rel="stylesheet" type="text/css" href="calculadora.css" media="screen" />
</head>
<body>

<center><h1>Calculadora JSP</h1></center>

<script>
    function appendToVisor(value) {
        var visor = document.getElementById("visorInfo");
        visor.innerText += value; // Adiciona o valor ao visor
    }

    function clearVisor() {
        document.getElementById("visorInfo").innerText = ""; // Limpa o visor
    }

    function calcular() {
        // Obter a expressão do visor
        var expression = document.getElementById("visorInfo").innerText;

        // Criar uma requisição AJAX
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "calcular", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Atualizar o visor com o resultado
                document.getElementById("visorInfo").innerText = xhr.responseText;
            }
        };

        // Enviar a expressão para o servlet
        xhr.send("expression=" + encodeURIComponent(expression));
    }

    // Adiciona eventos aos botões
    window.onload = function () {
        var buttons = document.querySelectorAll('.button_numeros, .buttons_operadores');
        buttons.forEach(function (button) {
            button.onclick = function () {
                appendToVisor(this.value);
            };
        });

        document.querySelector('.button-result').onclick = calcular; // Botão de igual
        document.querySelector('.button').onclick = clearVisor; // Botão DEL
    };
</script>

<div id="calculadora" class="calculadora">
    <center><h2>Calculadora</h2></center>
    <div id="visor">
        <span id="visorInfo">
            <%= request.getAttribute("resultado") != null ? request.getAttribute("resultado") : "" %>
        </span>
    </div>
    <div id="buttonGrid">
        <button class="button_operadores" value=")" >(</button>
        <button class="button" onclick="clearVisor()">DEL</button>
        <button class="button_operadores" onclick="appendToVisor(')')" value=")" >)</button>
        <button class="buttons_operadores" onclick="appendToVisor('/')" value="/">%</button>

        <button class="button_numeros" onclick="appendToVisor('1')">1</button>
        <button class="button_numeros" onclick="appendToVisor('2')">2</button>
        <button class="button_numeros" onclick="appendToVisor('3')">3</button>
        <button class="buttons_operadores" onclick="appendToVisor('*')">x</button>

        <button class="button_numeros" onclick="appendToVisor('4')">4</button>
        <button class="button_numeros" onclick="appendToVisor('5')">5</button>
        <button class="button_numeros" onclick="appendToVisor('6')">6</button>
        <button class="buttons_operadores" onclick="appendToVisor('-')" >-</button>

        <button class="button_numeros" onclick="appendToVisor('7')">7</button>
        <button class="button_numeros" onclick="appendToVisor('8')">8</button>
        <button class="button_numeros" onclick="appendToVisor('9')">9</button>
        <button class="buttons_operadores" onclick="appendToVisor('+')">+</button>
        <button class="button-result" onclick="calcular()">=</button>
    </div>
</div>

</body>
</html>
