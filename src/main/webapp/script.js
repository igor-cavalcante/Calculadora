function appendToVisor(value) {
    let visor = document.getElementById("visorInfo");
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
    var buttons = document.querySelectorAll('.button_numeros, .button_operadores');
    buttons.forEach(function (button) {
        button.onclick = function () {
            appendToVisor(this.value);
        };
    });

    document.querySelector('.button-result').onclick = calcular; // Botão de igual
    document.querySelector('.button-clear').onclick = clearVisor; // Botão DEL
};
