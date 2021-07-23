package com.example.dal.Controllador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.R;

public class ModuloTaller extends AppCompatActivity {

    private AnimationDrawable animationDrawable;
    private ScrollView scrollView;
    private ImageView img1, img2, img3;
    private TextView click1, click2, click3;

    public String nombreHomeUser, numeroAvatarUser, idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_taller);

        scrollView = findViewById(R.id.layoutScrollViewTaller);
        img1 = findViewById(R.id.imgBaja1);
        img2 = findViewById(R.id.imgBaja2);
        img3 = findViewById(R.id.imgBaja3);
        click1 = findViewById(R.id.radioClickUno);
        click2 = findViewById(R.id.radioClickDos);
        click3 = findViewById(R.id.radioClickTres);


        animationDrawable = (AnimationDrawable) scrollView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //-------------------------------------------------------------------------------

        nombreHomeUser = getIntent().getStringExtra("datoNombre");
        numeroAvatarUser = getIntent().getStringExtra("datoAvatar");
        idUser = getIntent().getStringExtra("idUser");

        mtdHandler1();

        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Entro Uno", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ModuloTaller.this, TallerUno.class);
                intent.putExtra("idUser", idUser);
                intent.putExtra("datoNombre", nombreHomeUser);
                intent.putExtra("datoAvatar", numeroAvatarUser);
                startActivity(intent);
            }
        });

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Entro Dos", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ModuloTaller.this, TallerDos.class);
                intent.putExtra("idUser", idUser);
                intent.putExtra("datoNombre", nombreHomeUser);
                intent.putExtra("datoAvatar", numeroAvatarUser);
                startActivity(intent);
            }
        });

        click3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Entro Tres", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ModuloTaller.this, TallerTres.class);
                intent.putExtra("idUser", idUser);
                intent.putExtra("datoNombre", nombreHomeUser);
                intent.putExtra("datoAvatar", numeroAvatarUser);
                startActivity(intent);
            }
        });

    }

    private void mtdHandler1(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setVisibility(View.VISIBLE);
                mtdHandler2();
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
            }
        }, 1000);
    }

    private void mtdHandler2(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.INVISIBLE);
                mtdHandler3();
            }
        }, 1100);
    }

    private void mtdHandler3(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.VISIBLE);;
                mtdHandler1();
            }
        }, 1200);
    }


    @Override
    public void onBackPressed() {
        //ventanaModalSalir();
        super.onBackPressed();
        finish();
    }

}