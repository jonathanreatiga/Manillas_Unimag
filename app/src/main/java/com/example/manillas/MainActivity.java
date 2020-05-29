package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner cmb_MATERIALES;
    private Spinner cmb_DIJE;
    private Spinner cmb_TIPO;
    private Spinner cmb_MONEDA;
    private String[] MATERIALES;
    private String[] DIJES;
    private String[] TIPOS;
    private String[] MONEDAS;
    private ArrayAdapter<String> ADAPTER;

    private EditText CANTIDAD;
    private TextView RESULTADO, VALOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CANTIDAD = findViewById(R.id.lblCantidad);
        RESULTADO = findViewById(R.id.lblResultado);

        // MATERIALES
        cmb_MATERIALES = findViewById(R.id.cmbMaterial);
        MATERIALES = getResources().getStringArray(R.array.Materiales);
        ADAPTER = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MATERIALES);
        cmb_MATERIALES.setAdapter(ADAPTER);

        // DIJES
        cmb_DIJE = findViewById(R.id.cmbDije);
        DIJES = getResources().getStringArray(R.array.Dijes);
        ADAPTER = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DIJES);
        cmb_DIJE.setAdapter(ADAPTER);

        // TIPOS
        cmb_TIPO = findViewById(R.id.cmbTipo);
        TIPOS = getResources().getStringArray(R.array.Tipos);
        ADAPTER = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TIPOS);
        cmb_TIPO.setAdapter(ADAPTER);

        // MONEDAS
        cmb_MONEDA = findViewById(R.id.cmbTipoMoneda);
        MONEDAS = getResources().getStringArray(R.array.Monedas);
        ADAPTER = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MONEDAS);
        cmb_MONEDA.setAdapter(ADAPTER);
    }

    public void btnLimpiarCampos(View view) {
        CANTIDAD.setText("");
        RESULTADO.setText("");
        CANTIDAD.requestFocus();
    }

    public void btnCalcular(View view) {
        if (validarCampoNumero()){
            validarMaterialesYDije();


        }
    }

    public void validarMaterialesYDije(){
        switch (cmb_MATERIALES.getSelectedItemPosition()){
            case 0:
                // CUERO
                switch (cmb_DIJE.getSelectedItemPosition()){
                case 0:
                    // MARTILLO
                    validarTipoYValor(0, 0);
                    switch (cmb_TIPO.getSelectedItemPosition()){
                        case 0:
                            // OR
                            break;
                        case 1:
                            // Baño de Oro
                            break;
                        case 2:
                            // Oro Rosado
                            break;
                        case 3:
                            // Plata
                            break;
                        case 4:
                            // Níquel
                            break;
                    }
                    break;
                case 1:
                    // ANCLA
                    validarTipoYValor(0, 1);
                    switch (cmb_TIPO.getSelectedItemPosition()){
                        case 0:
                            // OR
                            break;
                        case 1:
                            // Baño de Oro
                            break;
                        case 2:
                            // Oro Rosado
                            break;
                        case 3:
                            // Plata
                            break;
                        case 4:
                            // Níquel
                            break;
                    }
                    break;
                }
                break;
            case 1:
                // CUERDA
                switch (cmb_DIJE.getSelectedItemPosition()){
                    case 0:
                        // MARTILLO
                        validarTipoYValor(1, 0);
                        switch (cmb_TIPO.getSelectedItemPosition()){
                            case 0:
                                // OR
                                break;
                            case 1:
                                // Baño de Oro
                                break;
                            case 2:
                                // Oro Rosado
                                break;
                            case 3:
                                // Plata
                                break;
                            case 4:
                                // Níquel
                                break;
                        }
                        break;
                    case 1:
                        // ANCLA
                        validarTipoYValor(1, 1);
                        switch (cmb_TIPO.getSelectedItemPosition()){
                            case 0:
                                // OR
                                break;
                            case 1:
                                // Baño de Oro
                                break;
                            case 2:
                                // Oro Rosado
                                break;
                            case 3:
                                // Plata
                                break;
                            case 4:
                                // Níquel
                                break;
                        }
                        break;
                }
                break;
        }
    }


    public void validarTipoYValor(int material, int dije){

    }


    public boolean validarCampoNumero(){
        String errorIgualACero, errorVacio;
        int cantidad;
        errorIgualACero = getResources().getString(R.string.error_Cantidad);
        errorVacio = getResources().getString(R.string.error_Vacio);

        if (CANTIDAD.getText().toString().isEmpty()){
            CANTIDAD.setError(errorVacio);
            CANTIDAD.requestFocus();
            return false;
        }else {
            cantidad = Integer.parseInt(CANTIDAD.getText().toString());
            if (cantidad == 0 || cantidad < 0){
                RESULTADO.setText("");
                CANTIDAD.setError(errorIgualACero);
                CANTIDAD.requestFocus();
                return false;
            }
        }
        return true;
    }

}
