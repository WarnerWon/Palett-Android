package com.example.palett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
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

    private Button ordenBtn = null, productoBtn = null, materialBtn = null;
    private ArrayList<OrdenData> Lista1 = null;
    private ArrayList<ProductoData> Lista2 = null;
    private ImageButton notificationBtn = null;
    private RequestQueue queue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    protected void init(){
        ordenBtn = findViewById(R.id.menuOrden);
        productoBtn = findViewById(R.id.menuProducto);
        materialBtn = findViewById(R.id.menuMaterial);
        queue = Volley.newRequestQueue(MenuActivity.this);
        ordenBtn.setOnClickListener(this);
        productoBtn.setOnClickListener(this);
        materialBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i;
        switch (v.getId()){
            case R.id.menuOrden:
                i = 0;
                Volley(i);
                break;
            case R.id.menuProducto:
                i = 1;
                Volley(i);
                break;
            case R.id.menuMaterial:
                i = 2;
                Volley(i);
                break;
        }

    }
    protected void Volley(int route){
        String Url;
        JsonObjectRequest connection;
        switch (route){
            case 0:
                Toast.makeText(MenuActivity.this, "Cargando", Toast.LENGTH_SHORT).show();
                Url = "http://palett.uttics.com/api/ordenesIndex";
                connection = new JsonObjectRequest(Request.Method.GET, Url,null, new Response.Listener<JSONObject>() {
                    JSONArray Orders = null;
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Orders = response.getJSONArray("data");
                            Lista1 = new ArrayList<>();
                            for (int i = 0; i < Orders.length(); i++){
                                JSONObject jsonObject = Orders.getJSONObject(i);
                                OrdenData aux = new OrdenData();
                                aux.setId(jsonObject.getInt("id"));
                                aux.setFechaEnvio(jsonObject.getString("FechaEnvio"));
                                aux.setFechaOrden(jsonObject.getString("FechaOrden"));
                                JSONArray productos = jsonObject.getJSONArray("Productos");
                                ArrayList<ProductoData> ProdList = new ArrayList<>();
                                for (int x = 0; x < productos.length(); x++){
                                    JSONObject producto = productos.getJSONObject(x);
                                    ProductoData aux2 = new ProductoData();
                                    aux2.setNombre(producto.getString("Nombre"));
                                    aux2.setCantidad(producto.getInt("Cantidad"));
                                    ProdList.add(aux2);
                                }
                                aux.setListaProducto(ProdList);
                                Lista1.add(aux);
                            }
                            Intent intent = new Intent(MenuActivity.this, OrdenesActivity.class);
                            intent.putExtra("Lista", Lista1);
                            startActivity(intent);
                            Toast.makeText(MenuActivity.this, "Ordenes descargadas exitosamente", Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MenuActivity.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MenuActivity.this, "Error al comunicarse al servidor", Toast.LENGTH_SHORT).show();
                    }
                });
                connection.setRetryPolicy(new DefaultRetryPolicy(
                        5500,
                        0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queue.add(connection);
                break;
            case 1:
                Toast.makeText(MenuActivity.this, "Cargando", Toast.LENGTH_SHORT).show();
                Url = "http://palett.uttics.com/api/productosIndex";
                connection = new JsonObjectRequest(Request.Method.GET, Url,null, new Response.Listener<JSONObject>() {
                    JSONArray Productos = null;
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Productos = response.getJSONArray("data");
                            Lista2 = new ArrayList<>();
                            for (int i = 0; i < Productos.length(); i++){
                                ProductoData aux = new ProductoData();
                                JSONObject Producto = Productos.getJSONObject(i);
                                aux.setId(Producto.getInt("id"));
                                aux.setNombre(Producto.getString("Nombre"));
                                aux.setCantidad(Producto.getInt("Cantidad"));
                                aux.setPrecio_produccion(Producto.getInt("Precio_produccion"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MenuActivity.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MenuActivity.this, "Error al comunicarse al servidor", Toast.LENGTH_SHORT).show();
                    }
                });
                connection.setRetryPolicy(new DefaultRetryPolicy(
                        5500,
                        0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queue.add(connection);
                break;
            case 2:
                break;
            default:
                break;
        }
    }
}
