package dam.practica6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Santiago Avilez Jiménez on junio,2020
 */
class AdapterRecycler  extends RecyclerView.Adapter<AdapterRecycler.ViewHolder>{
    private ArrayList<Item> itemsList;
    private Context context;
    public AdapterRecycler(ArrayList<Item> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,
                        false);
        Log.d("creacion de view", "" );
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = itemsList.get(position).getTitulo();
        String urlImagen = itemsList.get(position).getImagen();
        holder.titulo.setText(name);
//imagenGlide = (ImageView) v.findViewById(R.id.imageView);
        Glide.with(this.context)
                .load(urlImagen)
                .override(1200, 800)
                .fitCenter()
                .into(holder.imagen);
        Log.d("titulo", "" +name );
    }
    @Override
    public int getItemCount() {
        return itemsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView descripcion;
        private ImageView imagen;
        public ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.textView);
            imagen = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

