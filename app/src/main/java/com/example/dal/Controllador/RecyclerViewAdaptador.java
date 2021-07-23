package com.example.dal.Controllador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dal.Modelo.clLectura;
import com.example.dal.R;

import java.util.List;

//definimos el adaptador del RecyclerView y le implementamos el evento OnClick para que escuche desde el ModuloTeorico
public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> implements View.OnClickListener {

    //OnClick
    private View.OnClickListener listener;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }
    //</OnClick>

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView cantante, nacionalidad;
        ImageView fotoCantante;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cantante=(TextView)itemView.findViewById(R.id.tvCantante);
            nacionalidad=(TextView)itemView.findViewById(R.id.tvNacionalidad);
            fotoCantante=(ImageView) itemView.findViewById(R.id.imgCantante);

        }
    }

    public List<clLectura> cantanteLista;

    public RecyclerViewAdaptador(List<clLectura> cantanteLista) {
        this.cantanteLista = cantanteLista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lectura_teorico, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        //OnClick
        view.setOnClickListener(this);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cantante.setText(cantanteLista.get(position).getTitulo());
        holder.nacionalidad.setText(cantanteLista.get(position).getTexto());
        holder.fotoCantante.setImageResource(cantanteLista.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return cantanteLista.size();
    }

}
