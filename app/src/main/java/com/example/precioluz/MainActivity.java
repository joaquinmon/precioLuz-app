package com.example.precioluz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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

        resultAll0 = findViewById(R.id.resultAll0);
        resultAll1 = findViewById(R.id.resultAll1);
        resultAll2 = findViewById(R.id.resultAll2);
        resultAll3 = findViewById(R.id.resultAll3);
        resultAll4 = findViewById(R.id.resultAll4);
        resultAll5 = findViewById(R.id.resultAll5);
        resultAll6 = findViewById(R.id.resultAll6);
        resultAll7 = findViewById(R.id.resultAll7);
        resultAll8 = findViewById(R.id.resultAll8);
        resultAll9 = findViewById(R.id.resultAll9);
        resultAll10 = findViewById(R.id.resultAll10);
        resultAll11 = findViewById(R.id.resultAll11);
        resultAll12 = findViewById(R.id.resultAll12);
        resultAll13 = findViewById(R.id.resultAll13);
        resultAll14 = findViewById(R.id.resultAll14);
        resultAll15 = findViewById(R.id.resultAll15);
        resultAll16 = findViewById(R.id.resultAll16);
        resultAll17 = findViewById(R.id.resultAll17);
        resultAll18 = findViewById(R.id.resultAll18);
        resultAll19 = findViewById(R.id.resultAll19);
        resultAll20 = findViewById(R.id.resultAll20);
        resultAll21 = findViewById(R.id.resultAll21);
        resultAll22 = findViewById(R.id.resultAll22);
        resultAll23 = findViewById(R.id.resultAll23);



        //Llamamos a todos los metodos
        LeerPrecioActual();
        LeerPrecioMin();
        LeerPrecioMed();
        LeerPrecioMax();
        LeerPrecioAll0();
        LeerPrecioAll1();
        LeerPrecioAll2();
        LeerPrecioAll3();
        LeerPrecioAll4();
        LeerPrecioAll5();
        LeerPrecioAll6();
        LeerPrecioAll7();
        LeerPrecioAll8();
        LeerPrecioAll9();
        LeerPrecioAll10();
        LeerPrecioAll11();
        LeerPrecioAll12();
        LeerPrecioAll13();
        LeerPrecioAll14();
        LeerPrecioAll15();
        LeerPrecioAll16();
        LeerPrecioAll17();
        LeerPrecioAll18();
        LeerPrecioAll19();
        LeerPrecioAll20();
        LeerPrecioAll21();
        LeerPrecioAll22();
        LeerPrecioAll23();

    }

    //Metodo que permite consultar el precio actual
    private void LeerPrecioActual(){

        String url = "https://api.preciodelaluz.org/v1/prices/now?zone=PCB";

        StringRequest precioactualRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultPrecioActual.setText(jsonObject.getString("price"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(precioactualRequest);

    }

    //Metodo que permite consultar el precio minimo del dia
    private void LeerPrecioMin(){

        String url = "https://api.preciodelaluz.org/v1/prices/min?zone=PCB";

        StringRequest precioMinRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultHourMin.setText(jsonObject.getString("hour"));
                    resultPriceMin.setText(jsonObject.getString("price"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(precioMinRequest);

    }

    private void LeerPrecioMed(){

        String url = "https://api.preciodelaluz.org/v1/prices/avg?zone=PCB";

        StringRequest precioMedRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultPriceMed.setText(jsonObject.getString("price"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(precioMedRequest);

    }

    private void LeerPrecioMax(){

        String url = "https://api.preciodelaluz.org/v1/prices/max?zone=PCB";

        StringRequest precioMaxRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    resultHourMax.setText(jsonObject.getString("hour"));
                    resultPriceMax.setText(jsonObject.getString("price"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(precioMaxRequest);

    }

    private void LeerPrecioAll0(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("00-01");
                            resultAll0.append("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll1(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("01-02");
                            resultAll1.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll2(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("02-03");
                            resultAll2.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll3(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("03-04");
                            resultAll3.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll4(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("04-05");
                            resultAll4.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll5(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("05-06");
                            resultAll5.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll6(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("06-07");
                            resultAll6.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll7(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("07-08");
                            resultAll7.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll8(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("08-09");
                            resultAll8.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll9(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("09-10");
                            resultAll9.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll10(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("10-11");
                            resultAll10.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll11(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("11-12");
                            resultAll11.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll12(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("12-13");
                            resultAll12.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll13(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("13-14");
                            resultAll13.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll14(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("14-15");
                            resultAll14.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll15(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("15-16");
                            resultAll15.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll16(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("16-17");
                            resultAll16.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll17(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("17-18");
                            resultAll17.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll18(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("18-19");
                            resultAll18.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll19(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("19-20");
                            resultAll19.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll20(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("20-21");
                            resultAll20.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll21(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("21-22");
                            resultAll21.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll22(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("22-23");
                            resultAll22.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

    private void LeerPrecioAll23(){

        String url = "https://api.preciodelaluz.org/v1/prices/all?zone=PCB";

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            response = response.getJSONObject("23-24");
                            resultAll23.setText("Hora: "+response.getString("hour")+"    "+"Precio: "+response.getString("price")+" "+response.getString("units"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);

    }

}