<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora JSP</title>
</head>
<body>

<h1>Calculadora JSP</h1>

<form action="calcular" method="post">
    <label for="number1">Número 1:</label>
    <input type="text" id="number1" name="number1" required>
    <br><br>
    <label for="number2">Número 2:</label>
    <input type="text" id="number2" name="number2" required>
    <br><br>
    <label for="operation">Operação:</label>
    <select id="operation" name="operation" required>
        <option value="+">Soma (+)</option>
        <option value="-">Subtracao (-)</option>
        <option value="*">Multiplicacao (*)</option>
        <option value="/">Divisao (/)</option>
    </select>
    <br><br>
    <button type="submit">Calcular</button>
</form>

<div class="calculadora">
    <h2>Calculadora</h2>
    <div id="visor"><span id="visorInfo"></span></div>

    <button class="button operadores" value=")" >)</button>
    <button id="dividir" class="buttons_operadores" value="/">%</button>

    <button class="button_numeros" value="1">1</button>
    <button class="button_numeros" value="2">2</button>
    <button class="button_numeros" value="3">3</button>
    <button id="multiplicar" class="buttons_operadores" value="*">x</button>

    <button class="button_numeros" value="4">4</button>
    <button class="button_numeros" value="2">5</button>
    <button class="button_numeros" value="3">6</button>
    <button id="subtrair" class="buttons_operadores" value="-">-</button>

    <button class="button_numeros" value="7">7</button>
    <button class="button_numeros" value="8">8</button>
    <button class="button_numeros" value="9">9</button>
    <button id="somar" class="buttons_operadores" value="+">+</button>


</div>


<div>
    <h1>Resultado: </h1>
    <%
        // Verifica se há um resultado para exibir
        String resultado = (String) request.getAttribute("resultado");
        if (resultado != null) {
    %>
    <h2>Resultado: <%= resultado %></h2>
    <%
        }
    %>
</div>


</body>
</html>
