package com.example.calculadora;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "Calcular", value = "/Calcular")
public class Calcular extends HelloServlet{
    private Calculadora calculo;

}
