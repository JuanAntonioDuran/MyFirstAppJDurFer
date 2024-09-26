package com.example.myfirstappjdurfer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Declaracion de los objetos de la aplicacion
        EditText editTexto = findViewById(R.id.editTexto);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        EditText editTextDecimal = findViewById(R.id.editTextDecimal);
        Switch switch1 = findViewById(R.id.switch1);
        Button buttonOk = findViewById(R.id.buttonOK);
        Button buttonBack = findViewById(R.id.buttonBack);


        /*
        Declaramos la funcion del Boton Ok que mandara a a la siguiente Actividad solo si los tres espacios
        de texto puestos para rellenar tienen algun valor si no saltara un pop up que negara el avance
         */
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTexto.getText().toString().equals("")) {
                    Toast toastText = new Toast(SecondActivity.this);
                    toastText.setText("No puede estar vacio");
                    toastText.show();

                } else if (editTextNumber.getText().toString().equals("")) {
                    Toast toastNumber = new Toast(SecondActivity.this);
                    toastNumber.setText("No puede estar vacio");
                    toastNumber.show();

                } else if (editTextDecimal.getText().toString().equals("")) {
                    Toast toastDecimal = new Toast(SecondActivity.this);
                    toastDecimal.setText("No puede estar vacio");
                    toastDecimal.show();

                } else {



                    boolean marked = switch1.isChecked();

                    Intent IntentSecondActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                    //Este if dira si el valor del switch en la aplicacion es veradero o falso y lo mandara para mostrarse
                    //En la tercera aplicacion
                    if (marked) {
                        IntentSecondActivity.putExtra("Boolean", "true");

                    } else {
                        IntentSecondActivity.putExtra("Boolean", "false");
                    }

                    IntentSecondActivity.putExtra("Texto", editTexto.getText().toString());



                    IntentSecondActivity.putExtra("Number", editTextNumber.getText().toString());


                    IntentSecondActivity.putExtra("Decimal", editTextDecimal.getText().toString());

                    Log.i("Texto", editTexto.getText().toString());
                    Log.i("Number", editTextNumber.getText().toString());
                    Log.i("Decimal", editTextDecimal.getText().toString());
                    Log.i("Boolean", switch1.getText().toString());


                    startActivity(IntentSecondActivity);

                }


            }


        });

        //Boton para volver a la primera Actividad
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentSecondActivity2 = new Intent(SecondActivity.this, MainActivity.class);

                startActivity(IntentSecondActivity2);
            }
        });


    }
}