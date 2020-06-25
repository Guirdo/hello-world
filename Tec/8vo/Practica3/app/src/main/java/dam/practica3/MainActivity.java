package dam.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nombre;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button boton = (Button) findViewById(R.id.boton);

        progressBar.setMax(50);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);

        new async(this).execute();
    }

    private class async extends AsyncTask<String, Integer, String> {

        Context context;

        public async(Context context) {
            super();
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
        }

        protected String doInBackground(String... urls) {

            for (int i = 0; i < 50; i++) {
                //Simulamos cierto retraso
                try {
                    Thread.sleep(200);
                    publishProgress(i);
                } catch (InterruptedException e) {
                }
            }
            return "";
        }

        protected void onProgressUpdate(Integer... progress) {
            progressBar.setProgress(progress[0]);
        }

        protected void onPostExecute(String result) {
            Bundle bundle = new Bundle();
            bundle.putString("nombre", nombre.getText().toString());
            Intent i = new Intent(context,Actividad2.class);
            i.putExtras(bundle);
            startActivityForResult(i, 1);
        }
    }
}
