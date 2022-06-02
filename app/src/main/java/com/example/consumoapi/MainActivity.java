package com.example.consumoapi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.consumoapi.io.MyApiAdapter;
import com.example.consumoapi.model.Firmas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    private TextView textView,fechaI,linkF,correoU;
    Button consultarDatos;
    private TextView jsonText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        fechaI = findViewById(R.id.fechaI);
        linkF = findViewById(R.id.linkF);
        correoU = findViewById(R.id.correoU);
        consultarDatos = findViewById(R.id.consultarDatos);
        jsonText = findViewById(R.id.jsonText);
        String correo = "jorge@ejemplo.com";

        consultarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFirmasUsuario(correo);
            }
        });

    }
    private void getFirmasUsuario(String correo){
        Call<ArrayList<Firmas>> call = MyApiAdapter.getApiService().getFirmas(correo);//el objeto call hace la petición
        call.enqueue(new Callback<ArrayList<Firmas>>() {
            @Override
            public void onResponse(Call<ArrayList<Firmas>> call, Response<ArrayList<Firmas>> response) {
                if (!response.isSuccessful()) {//para evitar que si ocurre un parseo inadecuado, la respuesta sea inadecuada
                    jsonText.setText("Código: " + response.code());
                    return;//vuelva a hacer la petición
                }
                ArrayList<Firmas> firmas = response.body();
                textView.setText((CharSequence) firmas.get(Integer.parseInt("id")));
                System.out.println("Valores:" + firmas);
                Log.d("On response firmas: ", "tamaño de firmas" + firmas.size());
            }
            @Override
            public void onFailure(Call<ArrayList<Firmas>> call, Throwable t) {
                jsonText.setText(t.getMessage());
            }
        });
    }

}