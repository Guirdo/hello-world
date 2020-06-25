package dam.practica7;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Santiago Avilez Jiménez on junio,2020
 */
public class adapterSpinner extends BaseAdapter {

    private Context context;
    private ImageView imagenGlide;
    private ArrayList<Item> items;
    public adapterSpinner(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return this.items.size();
    }
    @Override
    public Object getItem(int i) {
        return this.items.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
//Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item, null);
// Valor actual según la posición
        String currentName = items.get(i).titulo;
        String rutaimg = items.get(i).imagen;
// Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(currentName);
        imagenGlide = (ImageView) v.findViewById(R.id.imageView);
        Glide.with(this.context) .load(rutaimg)
                .override(100, 100) .fitCenter() .into(imagenGlide);
//Devolvemos la vista inflada
        Log.d("titulo", "" +currentName );
        return v;
    }

}
