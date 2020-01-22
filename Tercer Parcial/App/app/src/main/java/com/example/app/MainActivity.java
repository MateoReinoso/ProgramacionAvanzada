package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.app.Interface.Zona;
import com.example.app.Model.GetZona;

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
        getZona();
    }

    private void getZona(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tercerfinal.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Zona jsonClient = retrofit.create(Zona.class);

        Call<List<GetZona>> call = jsonClient.getZona();

        call.enqueue(new Callback<List<GetZona>>() {
            @Override
            public void onResponse(Call<List<GetZona>> call, Response<List<GetZona>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo"+response.code());
                    return;
                }

                List<GetZona> getZonaList = response.body();
                for(GetZona get: getZonaList){
                    String content ="";
                    content += "codigozona:" +get.getCodigozona()+"\n";
                    content += "nombrezona:" +get.getNombrezona()+"\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<GetZona>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
