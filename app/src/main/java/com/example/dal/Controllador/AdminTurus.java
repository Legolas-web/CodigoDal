package com.example.dal.Controllador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dal.R;
import com.example.dal.Modelo.JsonPlaceHolderApi;
import com.example.dal.Modelo.clUsuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.layout.simple_list_item_1;

public class AdminTurus extends AppCompatActivity {

    private ListView listViewuser;
    private ArrayList<String> listaInformacion;
    private ArrayList<clUsuario> listaUsuario;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private TextView lblres;
    private Button btnTurus2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_turus);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        listViewuser = (ListView) findViewById(R.id.lvListaUser);
        lblres = (TextView)findViewById(R.id.lblValor);
        btnTurus2 = (Button)findViewById(R.id.btnAdminTurus2);

        btnTurus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTurus.this, AdminTurusElimina.class);
                startActivity(intent);
            }
        });

        listaInformacion = new ArrayList<String>();
        listaUsuario = new ArrayList<clUsuario>();

        Call<List<clUsuario>> call = jsonPlaceHolderApi.getUsuarioCalificar();

        call.enqueue(new Callback<List<clUsuario>>() {
            @Override
            public void onResponse(Call<List<clUsuario>> call, Response<List<clUsuario>> response) {
                if (!response.isSuccessful()){
                    return;
                }

                List<clUsuario> user = response.body();

                for (clUsuario usuario : user){

                    int id = 0;
                    String name = "";
                    String nameFull = "";
                    String pass = "";
                    String esta = "";
                    int ava = 0;

                    id += usuario.getIdUsuario();
                    name += usuario.getNombre();
                    nameFull += usuario.getNombreCompleto();
                    pass += usuario.getContrasena();
                    esta += usuario.getEstado();
                    ava +=  usuario.getAvatar() ;

                    clUsuario use = new clUsuario();

                    use.setIdUsuario(id);
                    use.setNombre(name);
                    use.setNombreCompleto(nameFull);
                    use.setContrasena(pass);
                    use.setEstado(esta);
                    use.setAvatar(ava);

                    listaUsuario.add(use);

                }

                for (int i = 0; i < listaUsuario.size(); i ++){
                    listaInformacion.add("-  " + listaUsuario.get(i).getNombreCompleto());
                }

                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), simple_list_item_1, listaInformacion);
                listViewuser.setAdapter(adapter);

                listViewuser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String idUser = ""+ listaUsuario.get(position).getIdUsuario();

                        lblres.setText(idUser);

                        AlertDialog.Builder builder= new AlertDialog.Builder(AdminTurus.this);
                        LayoutInflater inflater = getLayoutInflater();
                        final View view1 = inflater.inflate(R.layout.emergente_admin, null);

                        builder.setView(view1);

                        AlertDialog dialog = builder.create();
                        dialog.show();

                        TextView lblT1 = (TextView) view1.findViewById(R.id.lblTaller1);
                        TextView lblT2 = (TextView) view1.findViewById(R.id.lblTaller2);
                        TextView lblT3 = (TextView) view1.findViewById(R.id.lblTaller3);
                        TextView lblT4 = (TextView) view1.findViewById(R.id.lblTaller4);

                        lblT1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AdminTurus.this, Califica.class);
                                intent.putExtra("idUser", idUser);
                                intent.putExtra("taller", "1");
                                startActivity(intent);
                            }
                        });

                        lblT2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AdminTurus.this, CalificaDos.class);
                                intent.putExtra("idUser", idUser);
                                intent.putExtra("taller", "2");
                                startActivity(intent);
                            }
                        });

                        lblT3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AdminTurus.this, CalificaTres.class);
                                intent.putExtra("idUser", idUser);
                                intent.putExtra("taller", "3");
                                startActivity(intent);
                            }
                        });

                        lblT4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AdminTurus.this, CalificaCuatro.class);
                                intent.putExtra("idUser", idUser);
                                intent.putExtra("taller", "4");
                                startActivity(intent);
                            }
                        });
                    }
                });

            }

            @Override
            public void onFailure(Call<List<clUsuario>> call, Throwable t) {

            }
        });


    }

}