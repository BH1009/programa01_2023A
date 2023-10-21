package com.example.programa01_2023a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button btnRegresar;

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnRegresar=(Button) findViewById(R.id.btnRegresar);
        tvResultado=(TextView) findViewById(R.id.tvResultado);


        Double res = getIntent().getDoubleExtra("resultado", 0.0);
        tvResultado.setText("El resultado es " + res );

    }

    public void Regresar(View view){
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }

    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }
}