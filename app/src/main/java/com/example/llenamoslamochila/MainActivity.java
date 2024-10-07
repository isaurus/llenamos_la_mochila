package com.example.llenamoslamochila;

import android.graphics.Color;
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

    // Declaración de los objetos CheckBox y sus pesos correspondientes
    private CheckBox[] checkBoxes;
    private final int[] pesos = {1, 2, 4, 5, 5, 10}; // Pesos de los ítems

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

        // Inicialización de los CheckBox con los objetos XML
        checkBoxes = new CheckBox[]{
                findViewById(R.id.chkGorras),
                findViewById(R.id.chkBanyadores),
                findViewById(R.id.chkCamisetas),
                findViewById(R.id.chkZapatos),
                findViewById(R.id.chkPantalones),
                findViewById(R.id.chkLibros)
        };

        // Asignar listener a cada CheckBox de forma dinámica
        for (int i = 0; i < checkBoxes.length; i++) {
            int peso = pesos[i];
            checkBoxes[i].setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso(isChecked, peso));
        }

        // Listener para el Button "VACIAR MOCHILA"
        btnVaciarMochila.setOnClickListener(v -> vaciarMochila());
    }

    // Método para calcular y representar el peso del contenido de la mochila
    public void actualizarPeso(boolean isChecked, int peso) {
        pesoTotal += isChecked ? peso : -peso;
        if (pesoTotal > 20){
            txtPeso.setTextColor(Color.RED);
        }else{
            txtPeso.setTextColor(Color.BLACK);
        }
        txtPeso.setText("Peso " + pesoTotal + " Kg");
    }

    // Método para vaciar la mochila (desmarcar todos los CheckBox y reiniciar el peso)
    public void vaciarMochila() {
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setChecked(false);
        }
        pesoTotal = 0;
        txtPeso.setText("Peso " + pesoTotal + " Kg");
    }
}