package com.example.precioluz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    //Declaramos todas la variables
    private TextView resultPrecioActual;
    private TextView resultHourMin, resultPriceMin;
    private TextView resultPriceMed;
    private TextView resultHourMax, resultPriceMax;
    private TextView resultAll0, resultAll1, resultAll2, resultAll3, resultAll4, resultAll5, resultAll6, resultAll7, resultAll8, resultAll9, resultAll10, resultAll11, resultAll12, resultAll13, resultAll14, resultAll15, resultAll16, resultAll17, resultAll18, resultAll19, resultAll20, resultAll21, resultAll22, resultAll23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Asignamos las variables con su correspondiente componente de la interfaz
        resultPrecioActual = findViewById(R.id.resultPrecioActual);

        resultHourMin = findViewById(R.id.resultHourMin);
        resultPriceMin = findViewById(R.id.resultPriceMin);

        resultPriceMed = findViewById(R.id.resultPriceMed);

        resultHourMax = findViewById(R.id.resultHourMax);
        resultPriceMax = findViewById(R.id.resultPriceMax);

        ImageButton imageButton2 = findViewById(R.id.imageButton2);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_hour.class);
                startActivity(intent);
                finish();
            }
        });





        //Llamamos a todos los metodos
        LeerPrecioActual();
        LeerPrecioMin();
       LeerPrecioMed();
        LeerPrecioMax();


    }

    private void LeerPrecioMax () {

        String url = "https://api.preciodelaluz.org/v1/prices/max?zone=PCB";

        StringRequest precioMaxRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultHourMax.setText(jsonObject.getString("hour"));
                    resultPriceMax.setText(jsonObject.getString("price")+" "+jsonObject.getString("units"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Vuelve a aintentarlo mas tarde...", Toast.LENGTH_SHORT);
                toast1.show();

            }
        });

        Volley.newRequestQueue(this).add(precioMaxRequest);

    }

    private void LeerPrecioMed () {

        String url = "https://api.preciodelaluz.org/v1/prices/avg?zone=PCB";

        StringRequest precioMedRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultPriceMed.setText(jsonObject.getString("price")+" "+jsonObject.getString("units"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Vuelve a aintentarlo mas tarde...", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        Volley.newRequestQueue(this).add(precioMedRequest);

    }

    private void LeerPrecioMin() {

        String url = "https://api.preciodelaluz.org/v1/prices/min?zone=PCB";

        StringRequest precioMinRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultHourMin.setText(jsonObject.getString("hour"));
                    resultPriceMin.setText(jsonObject.getString("price")+" "+jsonObject.getString("units"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Vuelve a aintentarlo mas tarde...", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        Volley.newRequestQueue(this).add(precioMinRequest);
    }

    private void LeerPrecioActual() {
        String url = "https://api.preciodelaluz.org/v1/prices/now?zone=PCB";

        StringRequest precioactualRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultPrecioActual.setText(jsonObject.getString("price")+" "+jsonObject.getString("units"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Vuelve a aintentarlo mas tarde...", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        Volley.newRequestQueue(this).add(precioactualRequest);
    }
}