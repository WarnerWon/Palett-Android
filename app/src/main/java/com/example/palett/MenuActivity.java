package com.example.palett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {


    private Button ordenesBtn = null, productosBtn = null, materialesBtn = null;
    private String url = null;
    private int i;
    private RequestQueue queue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.OrdenesViewBtn:
                Volley(i);
                i = 0;
                break;
            case R.id.ProductosViewBtn:
                Volley(i);
                i = 1;
                break;
            case R.id.MaterialesViewBtn:
                Volley(i);
                i = 2;
                break;
            default:
                break;
        }
    }

    protected void Volley(int route){
        queue = Volley.newRequestQueue(this);

        if (i == 0){
            url = "http://palett.uttics.com/api/ordenesIndex";
            JsonObjectRequest connection = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray aux = response.getJSONArray("data");
                        ArrayList<OrdenData> OrdenList = new ArrayList<>();
                        for (int i = 0; i < aux.length(); i++){
                            JSONObject jsonObject = aux.getJSONObject(i);
                            OrdenData ordenData = new OrdenData(
                                    jsonObject.getInt("id"),
                                    jsonObject.getString("FechaEnvio"),
                                    jsonObject.getString("FechaOrden")
                            );
                            ArrayList<ProductoData> ListaP = new ArrayList<>();
                            JSONArray list = jsonObject.getJSONArray("Productos");
                            for (int x=0; x < list.length(); i++){
                                ProductoData aux3 = new ProductoData();
                                aux3.setNombre(list.getJSONObject(x).getString("Nombre"));
                                aux3.setCantidad(list.getJSONObject(x).getInt("Cantidad"));
                                ListaP.add(aux3);
                            }
                            ordenData.setListaP(ListaP);
                            OrdenList.add(ordenData);
                        }
                        Intent intent = new Intent(MenuActivity.this,OrdenesActivity.class);
                        intent.putExtra("Lista", OrdenList);
                        startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(connection);
        }
        else if (i == 1){
            url = "http://palett.uttics.com/api/productosIndex";
            JsonObjectRequest connection = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray aux = response.getJSONArray("data");
                        ArrayList<OrdenData> ProductList = new ArrayList<>();
                        for (int i = 0; i < aux.length(); i++){
                            JSONObject jsonObject = aux.getJSONObject(i);
                            OrdenData ordenData = new OrdenData(
                                    jsonObject.getInt("id"),
                                    jsonObject.getString("FechaEnvio"),
                                    jsonObject.getString("FechaOrden")
                            );
                            ProductList.add(ordenData);
                        }
                        Intent intent = new Intent(MenuActivity.this,OrdenesActivity.class);
                        intent.putExtra("Lista", ProductList);
                        startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(connection);
        }
        else {
            url = "http://palett.uttics.com/api/materialesIndex";

        }


    }

    protected void init(){
        ordenesBtn      = findViewById(R.id.OrdenesViewBtn);
        productosBtn    = findViewById(R.id.ProductosViewBtn);
        materialesBtn   = findViewById(R.id.MaterialesViewBtn);
        ordenesBtn.setOnClickListener(this);
        productosBtn.setOnClickListener(this);
        materialesBtn.setOnClickListener(this);
    }
}
