package com.example.niyatishah.calci;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, dot;
    Button sign, equal, add, mul, div, sub, ce, c, back;


    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.one);
        b2 = (Button) findViewById(R.id.two);
        b3 = (Button) findViewById(R.id.three);
        b4 = (Button) findViewById(R.id.four);
        b5 = (Button) findViewById(R.id.five);
        b6 = (Button) findViewById(R.id.six);
        b7 = (Button) findViewById(R.id.seven);
        b8 = (Button) findViewById(R.id.eight);
        b9 = (Button) findViewById(R.id.nine);
        b0 = (Button) findViewById(R.id.zero);
        dot = (Button) findViewById(R.id.dot);
        sign = (Button) findViewById(R.id.sign);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        equal = (Button) findViewById(R.id.equal);
        ce = (Button) findViewById(R.id.ce);
        back = (Button) findViewById(R.id.back);
        tv = (TextView) findViewById(R.id.screen);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        dot.setOnClickListener(this);
        sign.setOnClickListener(this);
        add.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        sub.setOnClickListener(this);
        equal.setOnClickListener(this);
        ce.setOnClickListener(this);
        back.setOnClickListener(this);


    }

    public void onClick(View v) {
        String s;
        try {

            s = tv.getText().toString();
            switch (v.getId()) {
                case R.id.one:

                    tv.setText(s + "1");
                    break;
                case R.id.two:

                    tv.setText(s + "2");
                    break;
                case R.id.three:
                    tv.append("3");
                    break;
                case R.id.four:
                    tv.append("4");
                    break;
                case R.id.five:
                    tv.append("5");
                    break;
                case R.id.six:
                    tv.append("6");
                    break;
                case R.id.seven:
                    tv.append("7");
                    break;
                case R.id.eight:
                    tv.append("8");
                    break;
                case R.id.nine:
                    tv.append("9");
                    break;
                case R.id.zero:
                    tv.append("0");
                    break;
                case R.id.add:
                    tv.append("+");
                    break;
                case R.id.sub:
                    tv.append("-");
                    break;
                case R.id.mul:
                    tv.append("*");
                    break;
                case R.id.div:
                    tv.append("/");
                    break;
                case R.id.ce:
                    tv.setText("");
                    break;
                case R.id.back:
                    tv.setText(s.substring(0, s.length() - 1));
                    break;
                case R.id.dot:
                    tv.append(".");
                case R.id.equal:
                    evaluate(tv.getText().toString());
                    break;
                case R.id.sign:
                    tv.setText("-"+s);
            }
        } catch (Exception ep) {
            ep.getStackTrace();
        }


    }

    void evaluate(String str) {
        int i = 0, j = 0;
        int least = 0,count=0;
        char ch[] = new char[10];
        String st[] = new String[10];
        float a, b, res;
        while (count < str.length()) {
            char c = str.charAt(count);
            if (c == '+' || c == '-' || c == '/' || c == '*') {
                st[i] = str.substring(least, str.indexOf(c));
                ch[i] = c;
                j++;
                least = least + st[i].length()+1;
            }
            count++;
        }
        String k = str.substring(least);
        for (int r = j-1; r >= 0; r--) {
            a = Float.parseFloat(st[r]);
            b = Float.parseFloat(k);
            if (ch[r] == '+') {
                float d = a + b;
                k = k.valueOf(d);
            }
            if (ch[r] == '-') {
                float d = a - b;
                k = k.valueOf(d);
            }
            if (ch[r] == '*') {
                float d = a * b;
                k = k.valueOf(d);
            }
            if (ch[r] == '/') {
                float d = a / b;
                k = k.valueOf(d);
            }
        }
        tv.setText(k);
    }
}




