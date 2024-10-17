package com.example.calculadora;

public class Calculadora {
    private Double number1;
    private Double number2;
    private Double Result;

    public Calculadora(Double number1, Double number2, String op){
    this.number1 = number1;
    this.number2 = number2;
    this.Result = CalcularResult(op);
    }

    public Double getResult() {
        return Result;
    }

    public Double CalcularResult(String op) {

        if (op.equals("+")){
          return getNumber1() + getNumber2();
        } else if (op.equals("-")) {
           return getNumber1() - getNumber2();
        } else if (op.equals("*")) {
           return getNumber1() * getNumber2();
        } else if (op.equals("/")) {
            return getNumber1() / getNumber2();
        }
        return 0.0;
    }

    public Double getNumber1() {
        return number1;
    };

    public void setNumber1(Double number1) {
        this.number1 = number1;
    };

    public Double getNumber2() {
        return number2;
    };

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }
}
