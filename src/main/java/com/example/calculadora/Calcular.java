package com.example.calculadora;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "calcular", value = "/calcular")
public class Calcular extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number1str = request.getParameter("number1");
        String number2str = request.getParameter("number2");
        String op = request.getParameter("operation");
        try {
            Double number1 = Double.parseDouble(number1str);
            Double number2 = Double.parseDouble(number2str);
            Double calculo = null;
            if (op.equals("+")){
               calculo = number1 + number2;
            } else if (op.equals("-")) {
                calculo = number1 - number2;
            } else if (op.equals("*")) {
                calculo = number1 * number2;;
            } else if (op.equals("/")) {
                calculo = number1 / number2;
            }else {
            response.setContentType("text/html");
            response.getWriter().println("<h2>Erro: Divisão por zero não é permitida.</h2>");
            return;
            }

            // Enviar o resultado para o cliente
            response.setContentType("text/html");
            response.getWriter().println("<h2>O resultado é: " + calculo + "</h2>");


        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

    }

}
