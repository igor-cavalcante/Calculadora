<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora JSP</title>
    <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
    <script src="script.js" defer></script> <!-- Inclui o script JavaScript -->
</head>
<body>

    <center><h1>Calculadora JSP</h1></center>

    <div id="calculadora" class="calculadora">
        <center><h2>Calculadora</h2></center>
        <div id="visor">
            <span id="visorInfo">
                <%= request.getAttribute("resultado") != null ? request.getAttribute("resultado") : "" %>
            </span>
        </div>
        <div id="buttonGrid">
            <button class="button_operadores" value="(" >(</button>
            <button class="button-clear">DEL</button>
            <button class="button_operadores" value=")" >)</button>
            <button class="button_operadores" value="/" >/</button>

            <button class="button_numeros" value="1">1</button>
            <button class="button_numeros" value="2">2</button>
            <button class="button_numeros" value="3">3</button>
            <button class="button_operadores" value="*">x</button>

            <button class="button_numeros" value="4">4</button>
            <button class="button_numeros" value="5">5</button>
            <button class="button_numeros" value="6">6</button>
            <button class="button_operadores" value="-">-</button>

            <button class="button_numeros" value="7">7</button>
            <button class="button_numeros" value="8">8</button>
            <button class="button_numeros" value="9">9</button>
            <button class="button_operadores" value="+">+</button>

            <button class="button_numeros" value="0">0</button>
            <button class="button_numeros" value=".">.</button>
            <button class="button-result">=</button>
        </div>
    </div>

</body>
</html>
