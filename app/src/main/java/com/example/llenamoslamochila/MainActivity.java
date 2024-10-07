package com.example.llenamoslamochila;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // Declaración de TextView para mostrar el peso
    TextView txtPeso;

    // Declaración e inicialización de constantes para representar el peso de los objetos
    private final int pesoGorra = 1;
    private final int pesoBanyador = 2;
    private final int pesoCamiseta = 4;
    private final int pesoZapato = 5;
    private final int pesoPantalon = 5;
    private final int pesoLibro = 10;

    // Declaración de variable para actualizar el peso total de la mochila
    private int pesoTotal;

    // Declaración de los objetos CheckBox
    CheckBox chkGorras, chkBanyadores, chkCamisetas, chkZapatos, chkPantalones, chkLibros;

    // Declaración del Button "VACIAR MOCHILA"
    Button btnVaciarMochila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Inicialización de TextView con el objeto XML
        txtPeso = findViewById(R.id.txtPeso);

        // Inicialización del Button "VACIAR MOCHILA"
        btnVaciarMochila = findViewById(R.id.btnVaciarMochila);

        // Inicialización de los objetos CheckBox con los objetos XML
        chkGorras = findViewById(R.id.chkGorras);
        chkBanyadores = findViewById(R.id.chkBanyadores);
        chkCamisetas = findViewById(R.id.chkCamisetas);
        chkZapatos = findViewById(R.id.chkZapatos);
        chkPantalones = findViewById(R.id.chkPantalones);
        chkLibros = findViewById(R.id.chkLibros);

        // Listener para los CheckButton
        chkGorras.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso(isChecked, pesoGorra));
        chkBanyadores.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso(isChecked, pesoBanyador));
        chkCamisetas.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso(isChecked, pesoCamiseta));
        chkZapatos.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso(isChecked, pesoZapato));
        chkPantalones.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso(isChecked, pesoPantalon));
        chkLibros.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso(isChecked, pesoLibro));

        // Listener para el Button "VACIAR MOCHILA"
        btnVaciarMochila.setOnClickListener(v -> vaciarMochila());
    }

    // Método para calcular y representar el peso del contenido de la mochila
    public void actualizarPeso(boolean isChecked, int peso){
        if (isChecked){
            pesoTotal += peso;
            txtPeso.setText("Peso " + pesoTotal + " Kg");
        }else{
            pesoTotal -= peso;
            txtPeso.setText("Peso " + pesoTotal + " Kg");
        }
    }

    public void vaciarMochila(){
        chkGorras.setChecked(false);
        chkBanyadores.setChecked(false);
        chkCamisetas.setChecked(false);
        chkZapatos.setChecked(false);
        chkPantalones.setChecked(false);
        chkLibros.setChecked(false);

        pesoTotal = 0;
        txtPeso.setText("Peso " + pesoTotal + " Kg");
    }
}