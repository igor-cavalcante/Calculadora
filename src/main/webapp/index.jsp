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
</body>
</html>
