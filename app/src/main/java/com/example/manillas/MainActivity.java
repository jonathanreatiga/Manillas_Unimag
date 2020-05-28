package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner cmb_MATERIALES;
    private String[] MATERIALES;
    private ArrayAdapter<String> ADAPTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MATERIALES
        cmb_MATERIALES = findViewById(R.id.cmbMaterial);
        MATERIALES = getResources().getStringArray(R.array.Materiales);
        ADAPTER = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MATERIALES);
        cmb_MATERIALES.setAdapter(ADAPTER);
    }
}
