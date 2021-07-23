package com.example.dal.Controllador;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.R;
import com.example.dal.Modelo.clLectura;

import java.util.ArrayList;
import java.util.List;

public class ModuloTeorico extends AppCompatActivity {

    private RecyclerView recyclerViewCantante;
    private RecyclerViewAdaptador adaptadorLectura;

    private RelativeLayout layout;

    private AnimationDrawable animationDrawable;
    public String nombreHomeUser, numeroAvatarUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_teorico);

        recyclerViewCantante = (RecyclerView)findViewById(R.id.recyclerCantante);
        recyclerViewCantante.setLayoutManager(new LinearLayoutManager(this));
        adaptadorLectura = new RecyclerViewAdaptador(obtenerCantantes());
        recyclerViewCantante.setAdapter(adaptadorLectura);

        adaptadorLectura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //pos indica el item seleccionado del RecyclerBView
                int pos = recyclerViewCantante.getChildAdapterPosition(view);
                ventanaModal(pos);
                //Toast.makeText(getApplicationContext(), "¡ENTRO!"+ pos, Toast.LENGTH_SHORT).show();
            }
        });

        layout = (RelativeLayout) findViewById(R.id.layout2);


        //fondo animación
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //----------------------------------------------------------------------------------------------------------

        nombreHomeUser = getIntent().getStringExtra("datoNombre");
        numeroAvatarUser = getIntent().getStringExtra("datoAvatar");

    }

    //lista del objeto clLectura
    public List<clLectura> obtenerCantantes(){
        List<clLectura> cantante = new ArrayList<>();
        cantante.add(new clLectura(1, "MI RELIGIÓN", "Miguel de Unamuno.", "Ensayo", R.drawable.pensadoo));
        cantante.add(new clLectura(2, "LOS OBREROS DE LEBRIJA", "José Martínez Ruíz (Azorín).", "Ensayo", R.drawable.unoautor));
        cantante.add(new clLectura(3, "LOS SOSTENES DE LA PATRIA", "José Martínez Ruíz (Azorín).", "Ensayo", R.drawable.dosautor));
        return cantante;
    }


    @Override
    public void onBackPressed() {
        //ventanaModalSalir();
        super.onBackPressed();
        finish();
    }

    private void ventanaModal(int practica){
        AlertDialog.Builder builder= new AlertDialog.Builder(ModuloTeorico.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_ruleta, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView txtTitulo = (TextView)view1.findViewById(R.id.txtTituloPractica);
        TextView txtTexto = (TextView)view1.findViewById(R.id.txtTextoPractico);
        TextView txtTituloIntro = (TextView)view1.findViewById(R.id.txtTextoTitulo);
        TextView txtpiedePagina = (TextView)view1.findViewById(R.id.txtTextoPie);

        if (practica == 0){
            txtTitulo.setText("MI RELIGIÓN");
            txtTexto.setText(R.string.EnsayoUno);
            txtTituloIntro.setText("Miguel de Unamuno (1864 – 1936)");
            txtpiedePagina.setText("Este texto digital es de dominio público en España por haberse cumplido más de setenta años desde la muerte de su autor (RDL 1/1996 - Ley de Propiedad Intelectual). Sin embargo, no todas las leyes de" +
                    "Propiedad Intelectual son iguales en los diferentes países del mundo. Por favor, infórmese de la situación" +
                    "de su país antes de descargar, leer o compartir este fichero.");
        }
        if (practica == 1){
            txtTitulo.setText("LOS OBREROS DE LEBRIJA");
            txtTexto.setText(R.string.EnsayoDos);
            txtTituloIntro.setText("José Martínez Ruiz, (Madrid, 1905)");
            txtpiedePagina.setText("Texto extraído de “Los pueblos (Ensayos sobre la vida provinciana)”, de Azorín (José Martínez Ruiz), Madrid, 1905.");
        }
        if (practica == 2){
            txtTitulo.setText("LOS SOSTENES DE LA PATRIA");
            txtTexto.setText(R.string.EnsayoTres);
            txtTituloIntro.setText("José Martínez Ruiz, (Madrid, 1905)");
            txtpiedePagina.setText("Texto extraído de “Los pueblos (Ensayos sobre la vida provinciana)”, de Azorín (José Martínez Ruiz), Madrid, 1905.");
        }
    }

}
