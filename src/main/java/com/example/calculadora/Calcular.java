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
                if (number2 != 0) {
                calculo = number1 / number2;
                }else {
                    request.setAttribute("resultado", "Erro: Divisão por zero não é permitida.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                }
            };
            // Enviar o resultado para o cliente
           // response.setContentType("text/html");
           // response.getWriter().println("<h2>O resultado é: " + calculo + "</h2>");
            request.setAttribute("resultado", String.valueOf(calculo));

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        // Redireciona para a página JSP com o resultado
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
