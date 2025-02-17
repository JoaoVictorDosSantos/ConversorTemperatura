package br.edu.ifsp.arq.dmos5_2020s1.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonParaCelsius;
    private Button buttonParaFahrenheit;
    private EditText editTextTemperatura;
    private TextView textViewSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperatura = findViewById(R.id.editText_temperatura);
        buttonParaCelsius = findViewById(R.id.button_paraCelsius);
        buttonParaFahrenheit = findViewById(R.id.button_paraFahrenheit);
        textViewSaida = findViewById(R.id.textview_saida);

        buttonParaCelsius.setOnClickListener(this);
        buttonParaFahrenheit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == buttonParaCelsius){
            converterCelsius();
        }

        if(v == buttonParaFahrenheit){
            converterFahrenheit();
        }
    }

    private void converterCelsius() throws NumberFormatException{
        double valor;
        try{
            valor = getTemperatura();
        }catch (NumberFormatException e){
            valor = 0;
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }

        textViewSaida.setText(String.format("%.2f ºC ", ((valor - 32)/1.8)));
    }

    private void converterFahrenheit() throws NumberFormatException{
        double valor;
        try{
            valor = getTemperatura();
        }catch (NumberFormatException e){
            valor = 0;
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }

        textViewSaida.setText(String.format("%.2f ºF ", ((valor * 1.8) + 32)));
    }

    private double getTemperatura(){
        double temp;
        try{
            temp = Double.valueOf(editTextTemperatura.getText().toString());
        }catch (NumberFormatException e){
            temp = 0;
            throw e;
        }

        return temp;
    }
}
