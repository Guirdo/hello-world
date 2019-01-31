package com.seblab.saludadios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private RadioButton rbSaludo,rbDespedida;
    private SeekBar skEdad;
    private TextView tvEdad;
    private Button btnSiguiente;
    private int edad;
    private String nombre;

    public static final int GREETING_CODE = 0;
    public static final int FAREWELL_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rbSaludo = (RadioButton) findViewById(R.id.rbSaludo);
        rbDespedida = (RadioButton) findViewById(R.id.rbDespedida);
        skEdad = (SeekBar) findViewById(R.id.skEdad);
        tvEdad = (TextView)findViewById(R.id.tvEdad);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        rbSaludo.setSelected(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            nombre = bundle.getString("nombre");
            Toast.makeText(this,"Hola "+nombre,Toast.LENGTH_LONG).show();
        }

        skEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvEdad.setText(seekBar.getProgress()+"");

                if(seekBar.getProgress() < 16 || seekBar.getProgress() > 60){
                    Toast.makeText(SecondActivity.this,"Rango de edad permitido 16 a 60 años",Toast.LENGTH_LONG).show();
                    btnSiguiente.setVisibility(View.INVISIBLE);
                }else{
                    btnSiguiente.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //No se necesita
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                edad = seekBar.getProgress();
                //tvEdad.setText(seekBar.getProgress()+"");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edad = skEdad.getProgress();
                int opcion = (rbSaludo.isChecked()) ? GREETING_CODE : FAREWELL_CODE;
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("opcion",opcion);
                intent.putExtra("edad",edad);
                startActivity(intent);
            }
        });

    }
}
