
package com.example.dal.Controllador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dal.R;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4100;

    ImageView img;
    View primero, segundo, tercero, cuarto, quinto, sexto;
    TextView slogan;
    Animation topAnimation, bottomAnimation, middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);

        img = (ImageView) findViewById(R.id.img);
        slogan = (TextView) findViewById(R.id.slogan);

        primero = (View) findViewById(R.id.first_line);
        segundo = (View) findViewById(R.id.second_line);
        tercero = (View) findViewById(R.id.third_line);
        cuarto = (View) findViewById(R.id.fourth_line);
        quinto = (View) findViewById(R.id.fifth_line);
        sexto = (View) findViewById(R.id.sixth_line);

        primero.setAnimation(topAnimation);
        segundo.setAnimation(topAnimation);
        tercero.setAnimation(topAnimation);
        cuarto.setAnimation(topAnimation);
        quinto.setAnimation(topAnimation);
        sexto.setAnimation(topAnimation);

        img.setAnimation(middleAnimation);
        slogan.setAnimation(bottomAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, InicioSesion.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}