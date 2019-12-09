package com.example.palett;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class OrdenesActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;
    private AdaptadorOrdenes adaptador = null;
    private ArrayList<OrdenData> Lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);
        init();
    }

    protected void init(){
        recyclerView    = findViewById(R.id.OrdenViewRecycler);
        layoutManager   = new LinearLayoutManager(this);
        Lista           = (ArrayList<OrdenData>) getIntent().getSerializableExtra("Lista");
        adaptador       = new AdaptadorOrdenes(Lista);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptador);
    }
}
