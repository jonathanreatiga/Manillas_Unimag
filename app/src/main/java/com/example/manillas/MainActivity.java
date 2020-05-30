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

    private int FILAS = 20, COLUMNAS = 2;
    private String ARRAY_PRECIOS[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CANTIDAD = findViewById(R.id.lblCantidad);
        RESULTADO = findViewById(R.id.lblResultado);
        VALOR = findViewById(R.id.txtRValorUnidad);

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

        ARRAY_PRECIOS = new String[FILAS][COLUMNAS];

        // ORO
        ARRAY_PRECIOS[0][0] = "0;0;0";
        ARRAY_PRECIOS[0][1] = "100";
        ARRAY_PRECIOS[1][0] = "0;1;0";
        ARRAY_PRECIOS[1][1] = "120";
        ARRAY_PRECIOS[2][0] = "1;0;0";
        ARRAY_PRECIOS[2][1] = "90";
        ARRAY_PRECIOS[3][0] = "1;1;0";
        ARRAY_PRECIOS[3][1] = "110";

        // BAÑO ORO
        ARRAY_PRECIOS[4][0] = "0;0;1";
        ARRAY_PRECIOS[4][1] = "100";
        ARRAY_PRECIOS[5][0] = "0;1;1";
        ARRAY_PRECIOS[5][1] = "120";
        ARRAY_PRECIOS[6][0] = "1;0;1";
        ARRAY_PRECIOS[6][1] = "90";
        ARRAY_PRECIOS[7][0] = "1;1;1";
        ARRAY_PRECIOS[7][1] = "110";

        // ORO ROSADO
        ARRAY_PRECIOS[8][0] = "0;0;2";
        ARRAY_PRECIOS[8][1] = "100";
        ARRAY_PRECIOS[9][0] = "0;1;2";
        ARRAY_PRECIOS[9][1] = "120";
        ARRAY_PRECIOS[10][0] = "1;0;2";
        ARRAY_PRECIOS[10][1] = "90";
        ARRAY_PRECIOS[11][0] = "1;1;2";
        ARRAY_PRECIOS[11][1] = "110";

        // PLATA
        ARRAY_PRECIOS[12][0] = "0;0;3";
        ARRAY_PRECIOS[12][1] = "80";
        ARRAY_PRECIOS[13][0] = "0;1;3";
        ARRAY_PRECIOS[13][1] = "100";
        ARRAY_PRECIOS[14][0] = "1;0;3";
        ARRAY_PRECIOS[14][1] = "70";
        ARRAY_PRECIOS[15][0] = "1;1;3";
        ARRAY_PRECIOS[15][1] = "90";

        // NIQUEL
        ARRAY_PRECIOS[16][0] = "0;0;4";
        ARRAY_PRECIOS[16][1] = "70";
        ARRAY_PRECIOS[17][0] = "0;1;4";
        ARRAY_PRECIOS[17][1] = "90";
        ARRAY_PRECIOS[18][0] = "1;0;4";
        ARRAY_PRECIOS[18][1] = "50";
        ARRAY_PRECIOS[19][0] = "1;1;4";
        ARRAY_PRECIOS[19][1] = "80";
    }

    public void btnLimpiarCampos(View view) {
        CANTIDAD.setText("");
        RESULTADO.setText("");
        CANTIDAD.requestFocus();
    }

    public void btnCalcular(View view) {
        if (validarCampoNumero()){
            calcularLeseccionados();
        }
    }

    public void calcularLeseccionados(){
        String campo;
        int calculoPeso=0;
        int cantidad = Integer.parseInt(CANTIDAD.getText().toString());

       int material = cmb_MATERIALES.getSelectedItemPosition();
       int dije = cmb_DIJE.getSelectedItemPosition();
       int tipo = cmb_TIPO.getSelectedItemPosition();
       int peso = cmb_MONEDA.getSelectedItemPosition();

       campo = Integer.toString(material)+";"+Integer.toString(dije)+";"+Integer.toString(tipo);

        campo = buscarPrecios(campo);
        if (campo != null){
            switch (peso){
                case 0:
                    calculoPeso = Integer.parseInt(campo);
                    VALOR.setText(Integer.toString(calculoPeso));
                    calculoPeso = calculoPeso * cantidad;
                    RESULTADO.setText("");
                    RESULTADO.setText(Integer.toString(calculoPeso));
                    break;
                case  1:
                    calculoPeso = Integer.parseInt(campo);
                    calculoPeso = calculoPeso * 3200;
                    VALOR.setText(Integer.toString(calculoPeso));
                    calculoPeso = calculoPeso * cantidad;
                    RESULTADO.setText("");
                    RESULTADO.setText(Integer.toString(calculoPeso));
                    break;
            }
        }
    }

    public String buscarPrecios(String campo){
        int f, c;
        for (f = 0; f < ARRAY_PRECIOS.length; f++) {
            for (c = 0; c < ARRAY_PRECIOS[f].length; c++) {

                if (ARRAY_PRECIOS[f][c] != null){
                    if (ARRAY_PRECIOS[f][c].equals(campo)){
                        return ARRAY_PRECIOS[f][c+1];
                    }
                }
            }
        }
        return null;
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
