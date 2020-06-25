package dam.practica5;

import android.content.Context;
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
public class myAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<String> names;
    private ArrayList<String> img;
    private ImageView imagenGlide;
    private ArrayList<Item> items;
    public myAdapter(Context context, int layout, ArrayList<String>
            names,ArrayList<String> img, ArrayList<Item> items ) {
        this.context = context;
        this.layout = layout;
        this.names = names;
        this.img = img;
        this.items = items;
    }
    @Override
    public int getCount() {
        return this.names.size();
    }
    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
// Copiamos la vista
        View v = convertView;
//Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item, null);
// Valor actual según la posición
        String currentName = items.get(position).titulo;
        String rutaimg = items.get(position).imagen;
// Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(currentName);
        imagenGlide = (ImageView) v.findViewById(R.id.imageView);
        Glide.with(this.context)
                .load(rutaimg)
                .override(1200, 800)
                .fitCenter()
                .into(imagenGlide);
//Devolvemos la vista inflada
        return v;
    }
}
