package com.mer.mvp.mvpapp.model;

public class Number implements INumber {

    int v1, v2, op;

    public Number(int v1, int v2, int op) {
        this.v1 = v1;
        this.v2 = v2;
        this.op = op;
    }

    @Override
    public int num1() {
        return v1;
    }

    @Override
    public int num2() {
        return v2;
    }

    @Override
    public int opration() {
        return op;
    }

    @Override
    public int calculate() {
        int calculate = 0;
        try {
            if (op == 1)
                calculate = v1 + v2;
            else if (op == 2)
                calculate = v1 - v2;
            else if (op == 3)
                calculate = v1 * v2;
            else if (op == 4)
                calculate = v1 / v2;
        } catch (Exception e) {
            calculate = -1;
        }
        return calculate;
    }
}
