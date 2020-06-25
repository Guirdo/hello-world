package com.example.ejemplocalculadora2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtDisplay;
    Button btn;
    ArrayList<Button> listaBotones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaBotones = new ArrayList<>();
        txtDisplay = (TextView) findViewById(R.id.txtDisplay);

        btn = (Button) findViewById(R.id.btn0);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn3);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn4);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn5);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn6);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn7);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn8);
        btn.setOnClickListener(this);
        listaBotones.add(btn);

        btn = (Button) findViewById(R.id.btn9);
        btn.setOnClickListener(this);
        listaBotones.add(btn);
    }

    @Override
    public void onClick(View v) {
        int i=0;

        for (i=0;i<listaBotones.size();i++)
            if(listaBotones.get(i).getId()==v.getId())
                break;

        txtDisplay.setText(String.valueOf(i)+txtDisplay.getText());
    }
}
