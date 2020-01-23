package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app.R;

public class MENU extends AppCompatActivity {

    Button btnZona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnZona = (Button) findViewById(R.id.btnzona);

        btnZona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MENU.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
