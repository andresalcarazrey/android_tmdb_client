package com.politecnicomalaga.tmdbclient.data;

import java.io.IOException;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Clase DataMovieAccess
 *
 * Es utilizado por el controlador. El controlador le proporciona
 * los datos necesarios
 *
 * Se apoyará en OkHttp (librería cliente http/http2)
 * Solicita una lista JSON de películas
 */


public class DataMovieAccess {

    //ESTADO
    //Clase utilidad que no necesita nada más que poner a funcionar la peticion HTTPs
    // y una referencia al solicitante de información
    private static final String API_BEARER_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NTEwOTJjNDU1NDE4NzA1Y2E0ZjcyNzk0ZjczZDcyOCIsInN1YiI6IjY2MmNmOGVlNWI5NTA4MDEyMjU1NWFhZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5F5DQF3g7uAfqBcfjNdqMu1nV1UCzyjPY9l8uYSDRT0";

    //Referencia al cliente que necesita la información, como es asíncrono, lo necesitamos
    //para "informarle" cuando los datos están disponibles
    private RequestClient client;

    //COMPORTAMIENTO
    public DataMovieAccess(RequestClient client) {
        this.client = client;
    }

    public void requestData(String URL) {

        //Cliente HTTP
        OkHttpClient clientHTTP = new OkHttpClient();

        //Petición a realizar al cliente HTTP
        Request request = new Request.Builder()
                .url(URL)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + API_BEARER_KEY)
                .build();

        //realizamos la llamada al server, pero en otro thread (con enqueue)
        Call llamada = clientHTTP.newCall(request);
        llamada.enqueue(new Callback() {
            public void onResponse(Call call, Response respuestaServer)
                    throws IOException {
                //Got answer!!!!!
                String respuesta = respuestaServer.body().string();

                // Create a handler that associated with Looper of the main thread
                Handler manejador = new Handler(Looper.getMainLooper());
                // Send a task to the MessageQueue of the main thread
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        // Code will be executed on the main thread
                        client.setDataFromRESTAPI(respuesta);
                    }
                });
            }

            public void onFailure(Call call, IOException e) {
                String respuesta = e.getMessage();
                Handler manejador = new Handler(Looper.getMainLooper());

                // Send a task to the MessageQueue of the main thread
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        // Code will be executed on the main thread
                        client.setDataFromRESTAPI(respuesta);
                        client.activateError();
                    }
                });
            }
        });
    }



}
