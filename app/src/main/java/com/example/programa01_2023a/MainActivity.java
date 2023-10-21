package com.example.programa01_2023a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etValor1, etValor2;
   private ImageButton ibSuma, ibResta, ibMultiplica, ibDivide, ibExponente, ibBorrar, ibCerrar;
    public String Operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etValor1=(EditText) findViewById(R.id.etValor1);
        etValor2=(EditText) findViewById(R.id.etValor2);
        ibSuma=(ImageButton) findViewById(R.id.ibSuma);
        ibResta=(ImageButton) findViewById(R.id.ibResta);
        ibMultiplica=(ImageButton) findViewById(R.id.ibMultiplica);
        ibDivide=(ImageButton) findViewById(R.id.ibDivide);
        ibExponente=(ImageButton) findViewById(R.id.ibExponente);
        ibBorrar=(ImageButton) findViewById(R.id.ibBorrar);
        ibCerrar=(ImageButton) findViewById(R.id.ibCerrar);
    }

    public void sumar(View view){
        String valor1=etValor1.getText().toString();
        String valor2=etValor2.getText().toString();

        if(TextUtils.isEmpty(valor1) || TextUtils.isEmpty(valor2)){
            Toast.makeText(this, "Has dejado campos vacios", Toast.LENGTH_LONG).show();
        }
        else{
            double n1=Double.parseDouble(valor1);
            double n2=Double.parseDouble(valor2);
            double suma = n1 + n2;
            ibSuma.setEnabled(false);
            ibResta.setEnabled(false);
            ibMultiplica.setEnabled(false);
            ibDivide.setEnabled(false);
            etValor1.setEnabled(false);
            etValor2.setEnabled(false);
            enviarResultado(view, suma);
        }
    }

    public void resta(View view){
        String valor1=etValor1.getText().toString();
        String valor2=etValor2.getText().toString();

        if(TextUtils.isEmpty(valor1) || TextUtils.isEmpty(valor2)){
            Toast.makeText(this, "Has dejado campos vacios", Toast.LENGTH_LONG).show();
        }
        else{
            double n1=Double.parseDouble(valor1);
            double n2=Double.parseDouble(valor2);
            double resta = n1 - n2;
            ibResta.setEnabled(false);
            ibSuma.setEnabled(false);
            ibMultiplica.setEnabled(false);
            ibDivide.setEnabled(false);
            etValor1.setEnabled(false);
            etValor2.setEnabled(false);
            enviarResultado(view, resta);
        }
    }

    public void multiplicacion(View view){
        String valor1=etValor1.getText().toString();
        String valor2=etValor2.getText().toString();

        if(TextUtils.isEmpty(valor1) || TextUtils.isEmpty(valor2)){
            Toast.makeText(this, "Has dejado campos vacios", Toast.LENGTH_LONG).show();
        }
        else{
            double n1=Double.parseDouble(valor1);
            double n2=Double.parseDouble(valor2);
            double multiplicacion = n1 * n2;
            ibMultiplica.setEnabled(false);
            ibSuma.setEnabled(false);
            ibResta.setEnabled(false);
            ibDivide.setEnabled(false);
            etValor1.setEnabled(false);
            etValor2.setEnabled(false);
            enviarResultado(view, multiplicacion);
        }
    }

    public void division(View view){
        String valor1=etValor1.getText().toString();
        String valor2=etValor2.getText().toString();
        if(TextUtils.isEmpty(valor1) || TextUtils.isEmpty(valor2)){
            Toast.makeText(this, "Has dejado campos vacios", Toast.LENGTH_LONG).show();
        }
        else{
            double n1=Double.parseDouble(valor1);
            double n2=Double.parseDouble(valor2);
            if(n2 == 0){
                Toast.makeText(this, "No se puede realizar una division entre cero", Toast.LENGTH_LONG).show();
            }
            else {
                double division = n1 / n2;
                ibDivide.setEnabled(false);
                ibSuma.setEnabled(false);
                ibResta.setEnabled(false);
                ibMultiplica.setEnabled(false);
                etValor1.setEnabled(false);
                etValor2.setEnabled(false);
                enviarResultado(view, division);
            }
        }
    }

    public void exponente(View view){
        String valor1=etValor1.getText().toString();
        String valor2=etValor2.getText().toString();

        if(TextUtils.isEmpty(valor1) || TextUtils.isEmpty(valor2)){
            Toast.makeText(this, "Has dejado campos vacios", Toast.LENGTH_LONG).show();
        }
        else{
            double n1=Double.parseDouble(valor1);
            double n2=Double.parseDouble(valor2);
            double potencia = Math.pow(n1,n2);
            ibExponente.setEnabled(false);
            ibSuma.setEnabled(false);
            ibResta.setEnabled(false);
            ibMultiplica.setEnabled(false);
            ibDivide.setEnabled(false);
            etValor1.setEnabled(false);
            etValor2.setEnabled(false);
            enviarResultado(view, potencia);
        }
    }

    public void cerrar(View view){
//        System.exit(0);
        finish();
    }

    public void enviarResultado(View view, Double res){
        Intent enviarRes = new Intent(this, MainActivity2.class);
        enviarRes.putExtra("resultado", res);
        startActivity(enviarRes);
    }

    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }

    public void borrar(View view){
        etValor1.setText("");
        etValor2.setText("");
        etValor1.setEnabled(true);
        etValor2.setEnabled(true);
        ibSuma.setEnabled(true);
        ibResta.setEnabled(true);
        ibMultiplica.setEnabled(true);
        ibDivide.setEnabled(true);
        ibExponente.setEnabled(true);
    }
}