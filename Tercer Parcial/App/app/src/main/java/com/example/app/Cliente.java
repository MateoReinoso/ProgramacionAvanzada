package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.Model.GetCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cliente extends AppCompatActivity {

    Button btnMenu;
    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        btnMenu = (Button) findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cliente.this, MENU.class);
                startActivity(intent);
            }
        });

        mJsonTxtView = findViewById(R.id.jsonText);
        getCliente();

    }

    public void getCliente(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tercerfinal.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        com.example.app.Interface.Cliente jsonClient = retrofit.create(com.example.app.Interface.Cliente.class);

        Call<List<GetCliente>> call = jsonClient.getCliente();

        call.enqueue(new Callback<List<GetCliente>>() {
            @Override
            public void onResponse(Call<List<GetCliente>> call, Response<List<GetCliente>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo"+response.code());
                    return;
                }

                List<GetCliente> getClienteList = response.body();
                for (GetCliente get: getClienteList){
                    String content ="";

                    content += "Cedula: \n" +get.getCi()+"\n";
                    content += "Ruc: \n" +get.getRuc()+"\n";
                    content += "Nombre: \n" +get.getNombre()+"\n";
                    content += "Direccion: \n" +get.getDireccion()+"\n";
                    content += "Telfconvencional: \n" +get.getTelfconvencional()+"\n";
                    content += "Telfcelular: \n" +get.getTelfcelular()+"\n";
                    content += "Correo: \n" +get.getCorreo()+"\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<GetCliente>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
