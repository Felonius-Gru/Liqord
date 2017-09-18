package com.primehana.jacky.liqord;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class VendorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5fc050")));
        bar.setLogo(R.drawable.actionbar);
        bar.setDisplayShowTitleEnabled(false);

        // Update the EditText so it won't popup Android's own keyboard, since I have my own.
        final EditText editText = (EditText)findViewById(R.id.editText);
        editText.setCursorVisible(false);

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

        Button button0 = (Button)findViewById(R.id.button0);
        button0.setOnClickListener(listener);
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(listener);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(listener);
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(listener);
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(listener);
        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(listener);
        Button button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(listener);
        Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(listener);
        Button button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(listener);
        Button button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(listener);

        Button button_delete = (Button)findViewById(R.id.button_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = editText.getText().toString();
                if (!str.isEmpty()) {
                    editText.setText(str.substring(0, str.length() - 1));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vendor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
