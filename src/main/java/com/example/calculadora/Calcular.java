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
//        String number1str = request.getParameter("number1");
//        String number2str = request.getParameter("number2");
//        String op = request.getParameter("operation");
        String expression = request.getParameter("expression");

        try {
            //separar operadores e operandos
            String[] Tokens = expression.split("([+\\-*/])");
            List<Double> operandos = new ArrayList<>();
            List<Character> operadores = new ArrayList<>();

            //adicionando os operandos a lista
            for(String token : Tokens){
                operandos.add(Double.parseDouble(token));
            };

            //adicionando os operadores a lista
            for(char c : expression.toCharArray()){
                if(c == '+' || c == '-' || c == '*' || c == '/'){
                    operadores.add(c);
                };
            };

            //processar multiplicação e divisão primeiro
            for(int i = 0; i <operadores.size(); i++){
                char op = operadores.get(i);
                if(op == '*' || op == '/' ){
                    Double number1 = operandos.get(i);
                    Double number2 = operandos.get(i+1);
                    Double result = op == '*' ? number1 * number2 : number1 / number2;

                    operandos.set(i, result);
                    operandos.remove(i+1);
                    operadores.remove(i);
                    i--;
                };
            };

            //processar adição e subtração

            double ResultadoFinal = operandos.get(0);
            for(int i = 0 ; i < operandos.size(); i++){
                char operador = operadores.get(i);
                Double number2 = operandos.get(i+1);
                ResultadoFinal = operador == '+' ? ResultadoFinal + number2 : ResultadoFinal - number2;
            };

//            Double number1 = Double.parseDouble(number1str);
//            Double number2 = Double.parseDouble(number2str);
//            Double calculo = null;
//            if (op.equals("+")){
//               calculo = number1 + number2;
//            } else if (op.equals("-")) {
//                calculo = number1 - number2;
//            } else if (op.equals("*")) {
//                calculo = number1 * number2;;
//            } else if (op.equals("/")) {
//                if (number2 != 0) {
//                calculo = number1 / number2;
//                }else {
//                    request.setAttribute("resultado", "Erro: Divisão por zero não é permitida.");
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                    return;
//                }
//            };

            // Enviar o resultado para o cliente
           // response.setContentType("text/html");
           // response.getWriter().println("<h2>O resultado é: " + calculo + "</h2>");
            // request.setAttribute("resultado", String.valueOf(calculo));

            request.setAttribute("resultado", ResultadoFinal);

        } catch (NumberFormatException e) {
            request.setAttribute("resultado", "Erro: Formato de número inválido");
        } catch (Exception e) {
            request.setAttribute("resultado", "Erro: Expressão inválida");
        }
        // Redireciona para a página JSP com o resultado
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
