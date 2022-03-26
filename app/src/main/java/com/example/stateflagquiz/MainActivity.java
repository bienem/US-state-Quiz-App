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

    //Button b1,b2,b3,b4;
    ImageView flag;
    TextView resp;
    EditText reply;
    Button submit,next;


    List<StateItem> list;

    Random r;
    int i = 0;

    int attempt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        b1 = (Button) findViewById(R.id.b1);
//        b2 = (Button) findViewById(R.id.b2);
//        b3 = (Button) findViewById(R.id.b3);
//        b4 = (Button) findViewById(R.id.b4);

        resp = (TextView) findViewById(R.id.capital);
        reply = (EditText) findViewById(R.id.reply);
        submit = (Button) findViewById(R.id.submit);
        next = (Button) findViewById(R.id.next);



        list = new ArrayList<>();

        r = new Random();



        //newQ(attempt);


        for (int i = 0; i < new Database().answers.length; i++){
            list.add(new StateItem(new Database().answers[i], new Database().flags[i], new Database().capitals[i]));
        }

        Collections.shuffle(list); // to make our app random

        flag = (ImageView) findViewById(R.id.flag);

        flag.setImageResource(list.get(i).getImage());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(reply.getText().toString().equalsIgnoreCase(list.get(i).getName())){
                    Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
                    resp.setText(list.get(i).getCapitals());



                }
                else{
                    Toast.makeText(MainActivity.this, "wrong!!\nTry again", Toast.LENGTH_SHORT).show();

                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                reply.getText().clear();
                resp.setText("the capital is ...");
                flag.setImageResource(list.get(i).getImage());

            }
        });







//        do {
//
//
//
//
//
//        }while(i != new Database().answers.length);
////
//        for (int i = 0; i < new Database().answers.length; i++){
//
//        }

//        b1.setOnClickListener(view -> {
//            if(b1.getText().toString().equalsIgnoreCase(list.get(attempt - 1).getName())){
//                Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
//                rep.setText(list.get(attempt - 1).getCapitals());
//
//                if (attempt < list.size()){
//                    attempt++;
//                    newQ(attempt);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "game finished!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//            else {
//                Toast.makeText(MainActivity.this, "wrong!!", Toast.LENGTH_SHORT).show();
//            }
//
//        });
//
//        b2.setOnClickListener(view -> {
//            if(b2.getText().toString().equalsIgnoreCase(list.get(attempt - 1).getName())){
//                Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
//                rep.setText(list.get(attempt - 1).getCapitals());
//
//                if (attempt < list.size()){
//                    attempt++;
//                    newQ(attempt);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "game finished!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//            else {
//                Toast.makeText(MainActivity.this, "wrong!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        b3.setOnClickListener(view -> {
//            if(b3.getText().toString().equalsIgnoreCase(list.get(attempt - 1).getName())){
//                Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
//                rep.setText(list.get(attempt - 1).getCapitals());
//
//                if (attempt < list.size()){
//                    attempt++;
//                    newQ(attempt);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "game finished!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//            else {
//                Toast.makeText(MainActivity.this, "wrong!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        b4.setOnClickListener(view -> {
//            if(b4.getText().toString().equalsIgnoreCase(list.get(attempt - 1).getName())){
//                Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
//                rep.setText(list.get(attempt - 1).getCapitals());
//
//                if (attempt < list.size()){
//                    attempt++;
//                    newQ(attempt);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "game finished!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//            else {
//                Toast.makeText(MainActivity.this, "wrong!!", Toast.LENGTH_SHORT).show();
//            }
//
//        });

    }

//    public void newQ(int n){
//        flag.setImageResource(list.get(n - 1).getImage());
//        int correct = r.nextInt(4) + 1; //decider for the button with the right answer
//
//        int fb = n -1; //fb for firstButton
//        int sb; int tb; int frb;
//        switch (correct){
//            case 1:
//                b1.setText(list.get(fb).getName());
//                do {
//                    sb = r.nextInt(list.size());
//                }while (sb == fb);
//                do {
//                    tb = r.nextInt(list.size());
//                }while (tb == fb || tb == sb);
//                do {
//                    frb = r.nextInt(list.size());
//                }while (frb == fb || frb == sb || frb == tb);
//
//                b2.setText(list.get(sb).getName());
//                b3.setText(list.get(tb).getName());
//                b4.setText(list.get(frb).getName());
//
//                break;
//            case 2:
//                b2.setText(list.get(fb).getName());
//                do {
//                    sb = r.nextInt(list.size());
//                }while (sb == fb);
//                do {
//                    tb = r.nextInt(list.size());
//                }while (tb == fb || tb == sb);
//                do {
//                    frb = r.nextInt(list.size());
//                }while (frb == fb || frb == sb || frb == tb);
//
//                b1.setText(list.get(sb).getName());
//                b3.setText(list.get(tb).getName());
//                b4.setText(list.get(frb).getName());
//                break;
//            case 3:
//                b3.setText(list.get(fb).getName());
//                do {
//                    sb = r.nextInt(list.size());
//                }while (sb == fb);
//                do {
//                    tb = r.nextInt(list.size());
//                }while (tb == fb || tb == sb);
//                do {
//                    frb = r.nextInt(list.size());
//                }while (frb == fb || frb == sb || frb == tb);
//
//                b2.setText(list.get(sb).getName());
//                b1.setText(list.get(tb).getName());
//                b4.setText(list.get(frb).getName());
//                break;
//            case 4:
//                b4.setText(list.get(fb).getName());
//                do {
//                    sb = r.nextInt(list.size());
//                }while (sb == fb);
//                do {
//                    tb = r.nextInt(list.size());
//                }while (tb == fb || tb == sb);
//                do {
//                    frb = r.nextInt(list.size());
//                }while (frb == fb || frb == sb || frb == tb);
//
//                b2.setText(list.get(sb).getName());
//                b3.setText(list.get(tb).getName());
//                b1.setText(list.get(frb).getName());
//                break;
//        }
//    }
}