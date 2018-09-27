package com.example.ripo.futurecalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText etFname,etSleepTime,etWorkTime ,etWasteTime,etFoodBreak;
    private Button btnCalculate;
    int tvResult = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFname = findViewById(R.id.editTextName);
        etSleepTime = findViewById(R.id.editTextSleptime);
        etWorkTime = findViewById(R.id.editTextWorkTime);
        etWasteTime = findViewById(R.id.editTextWasteTime);
        etFoodBreak = findViewById(R.id.editTextFoodBreck);
        btnCalculate = findViewById(R.id.buttonSubmit);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                if (!etFname.getText().toString().equals("")
                        &&!etSleepTime.getText().toString().equals("")
                        &&!etWorkTime.getText().toString().equals("")
                        &&!etWasteTime.getText().toString().equals("")
                        &&!etFoodBreak.getText().toString().equals("")){


                    String fname = etFname.getText().toString();
                    int  sleep = Integer.parseInt(etSleepTime.getText().toString());
                    int  work = Integer.parseInt(etWorkTime.getText().toString());
                    int  waste = Integer.parseInt(etWasteTime.getText().toString());
                    int  food = Integer.parseInt(etFoodBreak.getText().toString());

                    Calendar c = Calendar.getInstance();
                    String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    String month = String.valueOf(c.get(Calendar.MONTH));
                    String year = String.valueOf(c.get(Calendar.YEAR));

                    String result = fname+ sleep + work+waste+food+ day + month + year;
                    result = result.toLowerCase();
                    result = result.trim();

                    int seed = result.hashCode();
                    Random r = new Random(seed);

                 AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setCancelable(false);
                    dialog.setTitle(fname+" "+"Your Future Are");
                    dialog.setMessage((r.nextInt(100) + 1) +"% Bright" );
                    dialog.setIcon(R.drawable.smiling);
                    dialog.setPositiveButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            //Action for "Delete".
                        }
                    });
                    final AlertDialog alert = dialog.create();
                    alert.show();
                }

            }
        });
    }


}

