package com.primehana.jacky.liqord;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuantityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int quantity = intent.getIntExtra("quantity", 0);
        String name = intent.getStringExtra("name");

        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(textView1.getText() + name);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5fc050")));
        bar.setLogo(R.drawable.actionbar);
        bar.setDisplayShowTitleEnabled(false);

        // Update the EditText so it won't popup Android's own keyboard, since I have my own.
        final EditText editText = (EditText)findViewById(R.id.editText1);
        editText.setCursorVisible(false);
        editText.setText(Integer.toString(quantity));

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                Button button = (Button)v;
                editText.setText(editText.getText().toString() + button.getText().toString());
            }
        };

        Button button0 = (Button)findViewById(R.id.btn0);
        button0.setOnClickListener(listener);
        Button button1 = (Button)findViewById(R.id.btn1);
        button1.setOnClickListener(listener);
        Button button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(listener);
        Button button3 = (Button)findViewById(R.id.btn3);
        button3.setOnClickListener(listener);
        Button button4 = (Button)findViewById(R.id.btn4);
        button4.setOnClickListener(listener);
        Button button5 = (Button)findViewById(R.id.btn5);
        button5.setOnClickListener(listener);
        Button button6 = (Button)findViewById(R.id.btn6);
        button6.setOnClickListener(listener);
        Button button7 = (Button)findViewById(R.id.btn7);
        button7.setOnClickListener(listener);
        Button button8 = (Button)findViewById(R.id.btn8);
        button8.setOnClickListener(listener);
        Button button9 = (Button)findViewById(R.id.btn9);
        button9.setOnClickListener(listener);

        Button button_delete = (Button)findViewById(R.id.btn_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            String str = editText.getText().toString();
            if (!str.isEmpty()) {
                editText.setText(str.substring(0, str.length() - 1));
            }
            }
        });

        Button button_enter = (Button)findViewById(R.id.btn_enter);
        button_enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = editText.getText().toString();
                if (!str.isEmpty()) {
                    int quantity = Integer.parseInt(str);
                    Intent intent = new Intent(QuantityActivity.this, ReviewActivity.class);
                    intent.putExtra("quantity", quantity);
                    setResult(RESULT_OK, intent);
                    QuantityActivity.this.finish();
                }
            }
        });
    }
}
