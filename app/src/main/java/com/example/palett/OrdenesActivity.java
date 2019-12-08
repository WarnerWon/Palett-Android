package com.example.palett;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class OrdenesActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);
        init();
    }

    protected void init(){

    }
}
