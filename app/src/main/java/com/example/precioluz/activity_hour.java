package com.example.precioluz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class activity_hour extends AppCompatActivity {

    private String[] hours = {"00-01", "01-02", "02-03", "03-04", "04-05", "05-06", "06-07",
        "07-08", "08-09", "09-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16",
        "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"
    };

    private TextView result;
    private Spinner hourSpinner;
    private TextView txtresult;
    private CardView card_backgroud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour);

        result = findViewById(R.id.result);
        hourSpinner = findViewById(R.id.hourSpinner);
        Button btn_calcular = findViewById(R.id.btn_calcular);
        txtresult = findViewById(R.id.txtresult);
        card_backgroud = findViewById(R.id.car_backgroud);

        ArrayAdapter<String>adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,hours);
        hourSpinner.setAdapter(adapter1);

        ImageButton imageButton = findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_hour.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast1 = Toast.makeText(getApplicationContext(), "Calculando...", Toast.LENGTH_SHORT);
                toast1.show();


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LeerPrecioAll0();
                    };
                }, 2000);
            }
        });

    }

    private void LeerPrecioAll0(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject(hourSpinner.getSelectedItem().toString());
                            result.setText(response.getString("price")+" "+response.getString("units"));

                            if (response.getBoolean("is-cheap") == true){
                                txtresult.setText("ES UN BUEN PRECIO PARA CONSUMIR");
                                card_backgroud.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2e7d32")));

                            } else if (response.getBoolean("is-cheap") == false){
                                txtresult.setText("NO ES UN BUEN PRECIO PARA CONSUMIR");
                                card_backgroud.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#d32f2f")));
                            }


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

        Volley.newRequestQueue(this).add(jsonRequest);

    }
}