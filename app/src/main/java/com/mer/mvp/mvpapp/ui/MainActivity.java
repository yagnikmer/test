package com.mer.mvp.mvpapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mer.mvp.mvpapp.R;
import com.mer.mvp.mvpapp.presenter.IMathPresenter;
import com.mer.mvp.mvpapp.presenter.MathPresenter;
import com.mer.mvp.mvpapp.view.MathView;

public class MainActivity extends Activity
        implements View.OnClickListener, MathView {

    EditText edttext1, edttext2;
    TextView tvtext;
    Button btn1, btn2, btn3, btn4;
    IMathPresenter mathPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindview();
        init();
        listener();
    }

    private void init() {
        mathPresenter = new MathPresenter(this);
    }

    private void bindview() {
        edttext1 = findViewById(R.id.edttext1);
        edttext2 = findViewById(R.id.edttext2);
        tvtext = findViewById(R.id.tvtext);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
    }

    private void listener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            int num1 = Integer.parseInt(edttext1.getText().toString());
            int num2 = Integer.parseInt(edttext2.getText().toString());
            switch (v.getId()) {
                case R.id.btn1:
                    mathPresenter.onCalculate(num1, num2, 1);
                    break;
                case R.id.btn2:
                    mathPresenter.onCalculate(num1, num2, 2);
                    break;
                case R.id.btn3:
                    mathPresenter.onCalculate(num1, num2, 3);
                    break;
                case R.id.btn4:
                    mathPresenter.onCalculate(num1, num2, 4);
                    break;
            }
        } catch (Exception e) {
            tvtext.setText("0.0");
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMathCalculate(int val) {
        tvtext.setText(String.valueOf(val));
    }
}