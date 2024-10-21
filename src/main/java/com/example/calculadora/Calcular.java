package com.example.calculadora;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "calcular", value = "/calcular")
public class Calcular extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expression = request.getParameter("expression");

        try {
            // Separar operadores e operandos
            String[] Tokens = expression.split("([+\\-*/])");
            List<Double> operandos = new ArrayList<>();
            List<Character> operadores = new ArrayList<>();

            // Adicionando os operandos à lista
            for (String token : Tokens) {
                operandos.add(Double.parseDouble(token));
            }

            // Adicionando os operadores à lista
            for (char c : expression.toCharArray()) {
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    operadores.add(c);
                }
            }

            // Processar multiplicação e divisão primeiro
            for (int i = 0; i < operadores.size(); i++) {
                char op = operadores.get(i);
                if (op == '*' || op == '/') {
                    if (i + 1 < operandos.size()) {
                        Double number1 = operandos.get(i);
                        Double number2 = operandos.get(i + 1);
                        Double result = op == '*' ? number1 * number2 : number1 / number2;

                        operandos.set(i, result);
                        operandos.remove(i + 1);
                        operadores.remove(i);
                        i--;
                    }
                }
            }

            // Processar adição e subtração
            double ResultadoFinal = operandos.get(0);
            for (int i = 0; i < operadores.size(); i++) {
                char operador = operadores.get(i);
                if (i + 1 < operandos.size()) {
                    Double number2 = operandos.get(i + 1);
                    ResultadoFinal = operador == '+' ? ResultadoFinal + number2 : ResultadoFinal - number2;
                }
            }

            // Enviar o resultado para o AJAX
            response.setContentType("text/plain");
            response.getWriter().write(String.valueOf(ResultadoFinal));

        } catch (NumberFormatException e) {
            response.setContentType("text/plain");
            response.getWriter().write("Erro: Formato de número inválido");
        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().write("Erro: Expressão inválida");
        }
    }
}
