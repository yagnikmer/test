package com.mer.mvp.mvpapp.presenter;

import com.mer.mvp.mvpapp.model.Number;
import com.mer.mvp.mvpapp.view.MathView;

public class MathPresenter implements IMathPresenter {
    MathView mathView;

    public MathPresenter(MathView mathView) {
        this.mathView = mathView;
    }

    @Override
    public void onCalculate(int v1, int v2, int op) {
        Number number = new Number(v1, v2, op);
        int value = number.calculate();
        mathView.onMathCalculate(value);
    }
}
