package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.app.Interface.Cliente;
import com.example.app.Model.GetS;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJsonTxtView = findViewById(R.id.jsonText);
        getClient();
    }

    private void getClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3001/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Cliente jsonClient = retrofit.create(Cliente.class);

        Call<List<GetS>> call = jsonClient.getClient();

        call.enqueue(new Callback<List<GetS>>() {
            @Override
            public void onResponse(Call<List<GetS>> call, Response<List<GetS>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo"+response.code());
                    return;
                }

                List<GetS> getSList = response.body();
                for(GetS get: getSList){
                    String content ="";
                    content += "ci:" +get.getCi() +"\n";
                    content += "ruc:" +get.getRuc() +"\n";
                    content += "nombre:" +get.getNombre() +"\n";
                    content += "direccion:" +get.getDireccion() +"\n";
                    content += "telfconvencional:" +get.getTelfconvencional() +"\n";
                    content += "telfcelular:" +get.getTelfcelular() +"\n";
                    content += "correo:" +get.getCorreo() +"\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<GetS>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
