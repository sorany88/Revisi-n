package com.example.consumoapi.io;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiAdapter {
    private static MyApiService API_SERVICE;//API_SERVICE(intancia;objeto) que implementa la interface; permite usar métodos definidos en la interface MiApiService

    public static MyApiService getApiService() {

        // Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();//Ayuda fase de desarrollo para saber si la respuesta es satisfactoria(estado de la petición etc)
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);//para ver resultados por consola

        String baseUrl = "https://aqueous-earth-47838.herokuapp.com/api/v1/rest/";
        System. out. println("url API: "+ baseUrl);
        if (API_SERVICE == null) {//Patrón de diseño singleton; Para que solo se instancie una vez (en caso de ser null)
            Retrofit retrofit = new Retrofit.Builder() //Hace las peticiones
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()) //Convierte formato Json a objeto
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            API_SERVICE = retrofit.create(MyApiService.class);
        }

        return API_SERVICE;
    }
}
