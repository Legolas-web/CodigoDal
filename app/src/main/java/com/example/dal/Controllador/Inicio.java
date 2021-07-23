package com.example.dal.Controllador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.dal.Modelo.JsonPlaceHolderApi;
import com.example.dal.Modelo.clNotaTaller;
import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Inicio extends AppCompatActivity  {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private int conteo = 1;
    private RelativeLayout layout;
    FloatingActionButton btnFlotante, btnFlotante2, btnFlotante3;
    private AnimationDrawable animationDrawable;
    private LinearLayout mDotLayout;
    private ViewPager mSlideViewPager;
    private Toolbar tbar;

    ImageView imgHomeUser;
    TextView txtNombreUserHome;

    private TextView[] mDots;
    private SliderAdapter sliderAdapter;

    private String nombreHomeUser, numeroAvatarUser, idUser, nombreFullUser;

    Animation open, close, fromBottom, toBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //RECIBE DATOS DE INICIOSESION----------------------------------------------------------------------------------

        nombreHomeUser = getIntent().getStringExtra("datoNombre");
        numeroAvatarUser = getIntent().getStringExtra("datoAvatar");
        idUser = getIntent().getStringExtra("idUser");
        nombreFullUser = getIntent().getStringExtra("nameFull");

        mtdPrimerRegistro();

        layout = (RelativeLayout) findViewById(R.id.layoutInicio);
        btnFlotante = findViewById(R.id.floatingActionButton);
        btnFlotante2 = findViewById(R.id.floatingActionButton2);
        btnFlotante3 = findViewById(R.id.floatingActionButton3);
        mDotLayout = (LinearLayout) findViewById(R.id.dostLayout);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        tbar = (Toolbar) findViewById(R.id.toolBarUser);


        //CONTROLES DE LAYOUT "TOOL_BAR_USER"
        imgHomeUser = (ImageView) findViewById(R.id.imgUsuario);
        txtNombreUserHome = (TextView) findViewById(R.id.txtToolNombreUsuario);



        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        open = AnimationUtils.loadAnimation(this, R.anim.rotate_open_animation);
        close = AnimationUtils.loadAnimation(this, R.anim.rotate_close_animation);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_animation);
        toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_animation);


        tbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, AdminUsuario.class);
                intent.putExtra("id", idUser);
                intent.putExtra("nombre", nombreHomeUser);
                intent.putExtra("avatar", numeroAvatarUser);
                startActivity(intent);
            }
        });

        btnFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (conteo == 1){
                    btnFlotante.setAnimation(open);
                    conteo++;
                }else{
                    btnFlotante.setAnimation(close);
                    conteo = 1;
                }

                if (btnFlotante.getAnimation()==open){
                    btnFlotante2.setVisibility(View.VISIBLE);
                    btnFlotante3.setVisibility(View.VISIBLE);
                }else if (btnFlotante.getAnimation()==close){
                    btnFlotante2.setVisibility(View.INVISIBLE);
                    btnFlotante3.setVisibility(View.INVISIBLE);
                }


            }
        });

        btnFlotante2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ventanaModal(nombreHomeUser, numeroAvatarUser);
            }
        });
        btnFlotante3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ventanaModalNotas();


            }
        });



        int ava = Integer.parseInt(numeroAvatarUser);

        imgHomeUser.setImageResource(ava);
        txtNombreUserHome.setText("Bienvenido "+ nombreHomeUser);


        //SLIDER ADAPTER----------------------------------------------------------------------------------------------------
        sliderAdapter = new SliderAdapter(this, nombreHomeUser, numeroAvatarUser, idUser);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator();
        cambiarColor(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void mtdPrimerRegistro(){


        int id = Integer.parseInt(idUser);

        Call<List<clRespuesta>> call = jsonPlaceHolderApi.getUsuarioNuevo(id);

        call.enqueue(new Callback<List<clRespuesta>>() {
            @Override
            public void onResponse(Call<List<clRespuesta>> call, Response<List<clRespuesta>> response) {
                if (!response.isSuccessful()){
                    return;
                }

                List<clRespuesta> resp = response.body();

                if (resp.isEmpty() == true){
                    Intent intent1 = new Intent(Inicio.this, FormUsuarioNuevo.class);
                    intent1.putExtra("idUser", idUser);
                    intent1.putExtra("NombreUser", nombreFullUser);
                    intent1.putExtra("datoNombre", nombreHomeUser);
                    intent1.putExtra("datoAvatar", numeroAvatarUser);
                    startActivity(intent1);
                    finish();




                }
            }

            @Override
            public void onFailure(Call<List<clRespuesta>> call, Throwable t) {

            }
        });


    }

    public void ventanaModalNotas(){
        AlertDialog.Builder builder= new AlertDialog.Builder(Inicio.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_notas, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView lbl1 = (TextView)view1.findViewById(R.id.lblMisNotas1);
        TextView lbl2 = (TextView)view1.findViewById(R.id.lblMisNotas2);
        TextView lbl3 = (TextView)view1.findViewById(R.id.lblMisNotas3);
        TextView lbl4 = (TextView)view1.findViewById(R.id.lblMisNotas4);

        //aca

        int idEnvia = Integer.parseInt(idUser);


        Call<List<clNotaTaller>> call = jsonPlaceHolderApi.getNotaFinal(idEnvia);

        call.enqueue(new Callback<List<clNotaTaller>>() {
            @Override
            public void onResponse(Call<List<clNotaTaller>> call, Response<List<clNotaTaller>> response) {
                if (!response.isSuccessful()){

                    return;
                }

                List<clNotaTaller> notaTallers = response.body();

                if (notaTallers.isEmpty() == true){
                    Toast.makeText(getApplicationContext(), "Vacio", Toast.LENGTH_LONG).show();
                    return;
                }

                int taller = 0;
                float ValorFinal = 0;

                for (clNotaTaller notaTaller1 : notaTallers){

                    int id = notaTaller1.getIdUsuario();
                    taller = notaTaller1.getTaller();
                    ValorFinal = notaTaller1.getNotaFinal();

                    String val = String.valueOf(ValorFinal);

                    if (taller == 1){
                        lbl1.setText("Nota Taller 1 --> "+ val);
                    }
                    if (taller == 2){
                        lbl2.setText("Nota Taller 2 --> "+ val);
                    }
                    if (taller == 3){
                        lbl3.setText("Nota Taller 3 --> "+ val);
                    }
                    if (taller == 4){
                        lbl4.setText("Nota Taller 4 --> "+ val);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<clNotaTaller>> call, Throwable t) {

            }
        });



    }

    public void ventanaModal(String use, String avat){
        AlertDialog.Builder builder= new AlertDialog.Builder(Inicio.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_salir_inicio, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnConfirmaCerrar = (Button) view1.findViewById(R.id.btnConfirmarCerrarSesion);
        Button btnCancelarCerra = (Button) view1.findViewById(R.id.btnCancelarSalirCerrarSesion);

        btnConfirmaCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        btnCancelarCerra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, Inicio.class);
                intent.putExtra("datoNombre", use);
                intent.putExtra("datoAvatar", avat);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        ventanaModal(nombreHomeUser, numeroAvatarUser);
        //super.onBackPressed();

    }

    //Añadimos los tres punticos que indican la navegacion el en menu pricipal
    public void addDotsIndicator(){

        mDots = new TextView[3];

        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(20);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);

        }

    }

    //Validaciones para que el color de el indicador cambie segun su posicionamiento
    public void cambiarColor(int position){

        mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));

        if (position == 0){

            mDots[1].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDots[2].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

        }
        if (position == 1){

            mDots[0].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDots[2].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

        }
        if (position == 2){

            mDots[0].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDots[1].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

        }
    }

    //Evento sobrescrito que capta el cambio de pantalla
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            cambiarColor(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
