package com.example.palett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Login_etxt_email = null, Login_etxt_pass = null;
    private Button Login_btn_enter = null;
    private RequestQueue queue = null;
    private JSONObject request = null;
    private String Url = "http://palett.uttics.com/api/login_mobile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    protected void init(){
        Login_etxt_email    = findViewById(R.id.correoinput);
        Login_etxt_pass     = findViewById(R.id.contraseñainput);
        Login_btn_enter     = findViewById(R.id.btnEntrar);
        Login_btn_enter.setOnClickListener(this);
    }

    protected void volley(){
        queue = Volley.newRequestQueue(this);
        request = new JSONObject();
        try {
            request.put("email", Login_etxt_email.getText());
            request.put("password", Login_etxt_pass.getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(LoginActivity.this, "Cargando", Toast.LENGTH_SHORT).show();
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, Url, request,
                new Response.Listener<JSONObject>() {
            JSONObject aux = null;
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getBoolean("success")){
                        aux = response.getJSONObject("data");
                        DataUser.getInstance().setId(String.valueOf(aux.getInt("id")));
                        DataUser.getInstance().setName(aux.getString("name"));
                        DataUser.getInstance().setEmail(aux.getString("email"));
                        Toast.makeText(LoginActivity.this, "Bienvenido " + DataUser.getInstance().getName(),
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Datos de inicio de sesion incorrectos",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Error al comunicarse al servidor",
                        Toast.LENGTH_SHORT).show();
            }
        });
        objectRequest.setRetryPolicy(new DefaultRetryPolicy(
                        7000,
                        0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(objectRequest);
    }

    @Override
    public void onClick(View v) {
        volley();
    }
}
