package com.example.calculadora;

public class Calculadora {
    private Double number1;
    private Double number2;
    private Double Result;

    public Calculadora(){

    }

    public Double getResult() {
        return Result;
    }

    public void setResult(Double result, String op) {

        if (op.equals("+")){
          this.Result = getNumber1() + getNumber2();
        } else if (op.equals("-")) {
           this.Result = getNumber1() - getNumber2();
        } else if (op.equals("*")) {
            this.Result = getNumber1() * getNumber2();
        } else if (op.equals("/")) {
            this.Result = getNumber1() / getNumber2();
        }
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
