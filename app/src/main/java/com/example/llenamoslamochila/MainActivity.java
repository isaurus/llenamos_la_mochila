package com.example.llenamoslamochila;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // Declaración de una List<> para almacenar los CheckBox seleccionados
    List<String> listaContenido = new ArrayList<>();

    // Declaración de TextView para mostrar el peso
    TextView txtPeso;

    // Declaración de los objetos CheckBox
    CheckBox chkGorras, chkBanyadores, chkCamisetas, chkZapatos, chkPantalones, chkLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de los objetos CheckBox con los objetos XML
        chkGorras = findViewById(R.id.chkGorras);
        chkBanyadores = findViewById(R.id.chkBanyadores);
        chkCamisetas = findViewById(R.id.chkCamisetas);
        chkZapatos = findViewById(R.id.chkZapatos);
        chkPantalones = findViewById(R.id.chkPantalones);
        chkLibros = findViewById(R.id.chkLibros);


        chkGorras.setOnCheckedChangeListener(v -> seleccion(v));
        chkBanyadores.setOnCheckedChangeListener(v -> seleccion(v));
        chkCamisetas.setOnCheckedChangeListener(v -> seleccion(v));
        chkZapatos.setOnCheckedChangeListener(v -> seleccion(v));
        chkPantalones.setOnCheckedChangeListener(v -> seleccion(v));
        chkLibros.setOnCheckedChangeListener(v -> seleccion(v));
    }

    // Método para añadir a la List<> el texto de los CheckBox
    private void seleccion(View v){
        CheckBox chk = (CheckBox) v;
        String textoChkSeleccionado = chk.getText().toString();
        if(chk.isChecked()){
            listaContenido.add(textoChkSeleccionado);
        }else{
            listaContenido.remove(textoChkSeleccionado);
        }
    }
}