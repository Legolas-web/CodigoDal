package com.example.dal.Controllador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.Modelo.JsonPlaceHolderApi;
import com.example.dal.Modelo.clUsuario;
import com.example.dal.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.layout.simple_list_item_1;

public class AdminTurusElimina extends AppCompatActivity {

    private ListView listViewuser;
    private ArrayList<String> listaInformacion;
    private ArrayList<clUsuario> listaUsuario;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private TextView lblres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_turus_elimina);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        listViewuser = (ListView) findViewById(R.id.lvListaUser2);
        lblres = (TextView)findViewById(R.id.lblValor2);

        listaInformacion = new ArrayList<String>();
        listaUsuario = new ArrayList<clUsuario>();

        Call<List<clUsuario>> call = jsonPlaceHolderApi.getUsuario();

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
                    listaInformacion.add("-  " + listaUsuario.get(i).getNombreCompleto() + ",  " + listaUsuario.get(i).getEstado());
                }

                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), simple_list_item_1, listaInformacion);
                listViewuser.setAdapter(adapter);

                listViewuser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String idUser = ""+ listaUsuario.get(position).getIdUsuario();
                        int id1 = listaUsuario.get(position).getIdUsuario();


                        lblres.setText(idUser);

                        AlertDialog.Builder builder= new AlertDialog.Builder(AdminTurusElimina.this);
                        LayoutInflater inflater = getLayoutInflater();
                        final View view1 = inflater.inflate(R.layout.emergente_admin_elimina, null);

                        builder.setView(view1);

                        AlertDialog dialog = builder.create();
                        dialog.show();

                        TextView actualizaa = (TextView) view1.findViewById(R.id.lblActualizaUser);
                        TextView eliminaa = (TextView) view1.findViewById(R.id.lblEliminaUser);
                        TextView registro = (TextView) view1.findViewById(R.id.lblPrimerTaller);

                        clUsuario us = new clUsuario();

                        actualizaa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                us.mtdPutEstadoActiva(id1);
                                Toast.makeText(getApplicationContext(), "Usuario Activado", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(AdminTurusElimina.this, AdminTurusElimina.class);
                                startActivity(intent);
                                finish();

                            }
                        });

                        eliminaa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                us.mtdElimina(id1);
                                Toast.makeText(getApplicationContext(), "Usuario Eliminado", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(AdminTurusElimina.this, AdminTurusElimina.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        registro.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AdminTurusElimina.this, RespuestasNuevo.class);
                                intent.putExtra("idUser", idUser);
                                startActivity(intent);
                                finish();
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