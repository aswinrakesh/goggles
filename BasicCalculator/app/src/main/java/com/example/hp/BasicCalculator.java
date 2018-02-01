package com.example.hp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.hp.basiccalculator.R;

import java.util.ArrayList;

import static com.example.hp.basiccalculator.R.*;

public class BasicCalculator extends AppCompatActivity {

    private Button calc;
    private EditText n1;
    private EditText n2;
    private TextView answ;
    Spinner spinner;
    double sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> n = new ArrayList<>();
        n.add("+");
        n.add("-");
        n.add("/");
        n.add("*");
        spinner =(Spinner) findViewById(R.id.spinner);
        calc = (Button) findViewById(R.id.Calculate);
        n1 =(EditText)findViewById(R.id.editText3);
        n2 = (EditText) findViewById(R.id.editText4);
        answ = (TextView) findViewById(R.id.textView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, n);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);
       calc.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("SetTextI18n")
           @Override
           public void onClick(View view) {
                    String var1 = n1.getText().toString();
                    String var2=n2.getText().toString();
                    int num2=Integer.parseInt(var1);
                    int num1=Integer.parseInt(var2);
                    String sp = spinner.getSelectedItem().toString();
                        if(sp.equals("+")) {
                            sum = num1 + num2;
                            String k=String.valueOf(sum);
                            answ.setText(k);
                        }
                        else if(sp.equals("-")){
                            sum=num1-num2;
                            String l=String.valueOf(sum);
                        answ.setText(l);}

                        else if(sp.equals("*")){
                            sum=num1*num2;
                            String m=String.valueOf(sum);
                        answ.setText(m);}

                        else if(sp.equals("/")){
                            sum=num1/num2;
                            String n=String.valueOf(sum);
                        answ.setText(n);}

                        else {
                            answ.setText("Please select an operation");
                        }




                        }





           });
    }
}







