package com.catata.alertdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class MiDalogo {
    Context c;
    RespuestaDialogo rd;

    //Constructor que pasamos el Callback y el contexto ya que los necesitaremos después
    public MiDalogo(Context c, RespuestaDialogo rd){
        this.c = c;
        this.rd = rd;
    }


    /*DIALOGO CON BOTONES ACEPTAR  Y CANCELAR*/
    public Dialog MostroarDialogBotones(){

        //Creamos el constructor de dialogos
        AlertDialog.Builder builder = new AlertDialog.Builder(c);

        //Añadimos parámetros
        builder.setTitle("Dialogo Nuevo") //titulo del dialogo
                .setMessage("Pulsa aceptar si quieres") //Cuerpo del dialogo
               .setPositiveButton("Acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { //Botón aceptar junto con manejador
                        //Lo que hace al darle aceptar
                        //Toast.makeText(c, "Has aceptado", Toast.LENGTH_SHORT).show();
                        rd.OnAccept("Has aceptado");
                    }
                })
               .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { //Botón cancelar junto con manejador
                        //Lo que hace al darle aceptar
                        //Toast.makeText(c, "Has cancelado", Toast.LENGTH_SHORT).show();
                        rd.OnCancel("Has cancelado");
                    }
                });


        return builder.create();

    }

    //Función que muestra un dialogo en forma de lista con múltiples opciones, solo puede coger una
    public Dialog DialogoOpcionUnica(){
        AlertDialog.Builder builder = new AlertDialog.Builder(c);

        builder.setTitle("Elige un color")
                //Este string array está en values, pero podría ser una arrayList en memoria
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] s= c.getResources().getStringArray(R.array.colors_array);

                        Toast.makeText(c,"Has elegido " + s[i],Toast.LENGTH_SHORT).show();
                    }
                });

        return builder.create();

    }

    //Creamos un dialogo personalizado a partir de una vista creada en la carpeta LayOut.
    public Dialog customDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        builder.setView(inflater.inflate(R.layout.signin_dialog, null));
        return builder.create();



    }


    public interface RespuestaDialogo{
        void OnAccept(String cadena);
        void OnCancel(String cadena);
    }
}
