package com.example.dal.Controllador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.dal.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    String usuario, avatar, idUserr;

    public SliderAdapter(Context context, String usu, String avat, String idUser){

        this.context = context;
        usuario = usu;
        avatar = avat;
        idUserr = idUser;
    }

    public int[] slide_images = {

            R.drawable.practica,
            R.drawable.libro,
            R.drawable.libroopen


    };

    public String[] slide_headings = {

            "¿ESTAS LISTO?",
            "¡PREPARATE!",
            "¡PONTE A PRUEBA!"


    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);

        slideImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evento(position);
            }
        });

        container.addView(view);

        return view;
    }

    public void evento( int pos){
        if (pos == 0){

            Intent myIntent=new Intent(context, ModuloTeorico.class);
            myIntent.putExtra("idUser", idUserr);
            myIntent.putExtra("datoNombre", usuario);
            myIntent.putExtra("datoAvatar", avatar);
            context.startActivity(myIntent);

        }
        if (pos == 1){

            Intent myIntent=new Intent(context, ModuloTaller.class);
            myIntent.putExtra("idUser", idUserr);
            myIntent.putExtra("datoNombre", usuario);
            myIntent.putExtra("datoAvatar", avatar);
            context.startActivity(myIntent);



        }
        if (pos == 2){

            Intent myIntent=new Intent(context, ModuloPractico.class);
            myIntent.putExtra("idUser", idUserr);
            myIntent.putExtra("datoNombre", usuario);
            myIntent.putExtra("datoAvatar", avatar);
            context.startActivity(myIntent);

        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);

    }
}
