package com.example.hp;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
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
import java.util.Random;

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
        n.add("ADDITION");
        n.add("SUBTRACTION");
        n.add("DIVISION");
        n.add("MULTIPLICATION");
        spinner =(Spinner) findViewById(R.id.spinner);
        calc = (Button) findViewById(R.id.Calculate);
        n1 =(EditText)findViewById(R.id.editText3);
        n2 = (EditText) findViewById(R.id.editText4);
        answ = (TextView) findViewById(R.id.textView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, n);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);
       calc.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
           @SuppressLint("SetTextI18n")
           @Override
           public void onClick(View view) {
                                     String var1 = n1.getText().toString();
                    String var2=n2.getText().toString();
                    int num2=Integer.parseInt(var1);
                    int num1=Integer.parseInt(var2);
                    String sp = spinner.getSelectedItem().toString();
                    //NOTIFICATIONBUILDER

               if(sp.equals("ADDITION")) {
                            sum = num1 + num2;
                            String k=String.valueOf(sum);
                            answ.setText(k);
                            notification("sum is  "+sum);

                        }
                        else if(sp.equals("SUBTRACTION")) {
                   sum = num1 - num2;
                   String l = String.valueOf(sum);
                   answ.setText(l);
                   notification("difference is   " + sum);
               }


                        else if(sp.equals("MULTIPLICATION")){
                            sum=num1*num2;
                            String m=String.valueOf(sum);
                        answ.setText(m);
                       notification("multiplication is   "+sum);

                   }

                        else if(sp.equals("DIVISION  ")){
                            sum=num1/num2;
                            String n=String.valueOf(sum);
                        answ.setText(n);
                       notification("quotient is  "+sum);

                   }

                        else {
                            answ.setText("Please select an operation");
                        }
                        }

       });

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void notification(String n) {
        Random r = new Random();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel("001", "Operations", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Gives notification");
            NotificationManager notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            Notification.Builder calc = new Notification.Builder(BasicCalculator.this,"001").setSmallIcon(drawable.ic_launcher_background).setContentTitle("Calculator").setContentText(n);
            notif.notify(r.nextInt(), calc.build());
        } else {

            NotificationManager notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            Notification calc = new Notification.Builder(BasicCalculator.this).setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("Calculator").setContentText(n).build();
            notif.notify(r.nextInt(), calc);
        }

    }

}







