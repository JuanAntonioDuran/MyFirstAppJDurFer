package com.example.myfirstappjdurfer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Declaracion de Variables

        TextView VistaNombre = findViewById(R.id.VistaNombre);
        TextView VistaNumero = findViewById(R.id.VistaNumero);
        TextView VistaDecimal = findViewById(R.id.VistaDecimal);
        TextView VistaBoolean = findViewById(R.id.VistaBoolean);
        Button buttonInicio = findViewById(R.id.buttonInicio);

        //Boton para volver a la primera actividad
        buttonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(ThirdActivity.this , MainActivity.class);
                startActivity(intentBack);

            }
        });

        //Recogida de los valores de la SecondActivity para ser mostradas en esta actividad

        Intent IntentThirdActivity = getIntent();
        String Texto = IntentThirdActivity.getStringExtra("Texto");
        String Numero = IntentThirdActivity.getStringExtra("Number");
        String Decimal = IntentThirdActivity.getStringExtra("Decimal");
        String Boolean = IntentThirdActivity.getStringExtra("Boolean");

        //Colocamos el texto recojido en las vistas de esta actividad
        VistaNombre.setText(Texto);
        VistaNumero.setText(Numero);
        VistaDecimal.setText(Decimal);
        VistaBoolean.setText(Boolean);


    }
}