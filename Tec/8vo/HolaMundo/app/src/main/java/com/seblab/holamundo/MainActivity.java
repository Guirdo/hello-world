package com.seblab.holamundo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtHola = (TextView) findViewById(R.id.txtHola);

        txtHola.setText("Muy buenas a todas! Guapisimos! Aqui Vegeta 777");
    }
}
