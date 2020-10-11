package com.catata.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMostrar = (TextView)findViewById(R.id.tvMostrar);


    }

    public void mostrarDialogo(View view) {

        MiDalogo md = new MiDalogo(this, new MiDalogo.RespuestaDialogo() {
            @Override
            public void OnAccept(String cadena) { //Método onAccept del CallBack
                //En este caso solo mostramos un Toast con la cadena que llega
                // y cambiamos el contenido de un TextView.
                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_SHORT).show();
                tvMostrar.setText("Aceptado");

            }

            @Override
            public void OnCancel(String cadena) { //Método onCancel del CallBack
                //En este caso solo mostramos un Toast con la cadena que llega
                // y cambiamos el contenido de un TextView.
                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_SHORT).show();
                tvMostrar.setText("Cancelado");

            }
        });

        //AQUI ESTAMOS LLAMANDO CADA VEZ A UNO DE LOS MÉTODOS IMPLEMENTADOS PARA PROBARLOS.

        //md.MostroarDialogBotones().show();
        //md.DialogoOpcionUnica().show();
        md.customDialog().show();
    }
}