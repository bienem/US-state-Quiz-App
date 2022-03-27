package com.example.stateflagquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView flag;
    TextView resp;
    EditText reply;
    Button submit,next;
    List<StateItem> list;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resp = (TextView) findViewById(R.id.capital);
        reply = (EditText) findViewById(R.id.reply);
        submit = (Button) findViewById(R.id.submit);
        next = (Button) findViewById(R.id.next);


        list = new ArrayList<>();


        for (int i = 0; i < new Database().answers.length; i++) {
            list.add(new StateItem(new Database().answers[i], new Database().flags[i], new Database().capitals[i]));
        }

        Collections.shuffle(list); // to make our app random

        flag = (ImageView) findViewById(R.id.flag);

        flag.setImageResource(list.get(i).getImage());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reply.getText().toString().equalsIgnoreCase(list.get(i).getName())) {
                    Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
                    resp.setText(list.get(i).getCapitals());


                } else {
                    Toast.makeText(MainActivity.this, "wrong!!\nTry again", Toast.LENGTH_SHORT).show();

                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i < new Database().capitals.length) {
                    i++;
                    reply.getText().clear();
                    resp.setText("the capital is ...");
                    flag.setImageResource(list.get(i).getImage());
                }
                else
                    Toast.makeText(MainActivity.this, "End of the quiz!!", Toast.LENGTH_SHORT).show();

            }
        });


    }}