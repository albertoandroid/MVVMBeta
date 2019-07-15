package com.androiddesdecero.mvvmandroidbasico;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlCuadradoActivity extends AppCompatActivity {

    private EditText etAlCuadrado;
    private Button btAlCuadrado;
    private TextView tvAlCuadrado;

    private AlCuadradoViewModel alCuadradoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }

    private void configView(){
        /*
        Ejemplo con ViewModel, los datos persisten con los cambios de configuración
        Para instanciar nuestra clase viewmodel tienes que hacerlos a través del ViewModelProvider
        de donde, de la activity y por último la clase de que se trata.
        Esta línea de código nos asocia nuestra clase viewmodel con la ACtibvity y ya va a perdurar.
         */
        alCuadradoViewModel = ViewModelProviders.of(this).get(AlCuadradoViewModel.class);
        tvAlCuadrado = findViewById(R.id.tvAlCuadrado);
        etAlCuadrado = findViewById(R.id.edAlCuadrado);
        btAlCuadrado = findViewById(R.id.btCalcular);
        btAlCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alCuadradoViewModel.alCuadrado(etAlCuadrado.getText().toString());
            }
        });

        /*
        Tenemos que crear nuestro observer que observe nuestra clase Observable
        AlCuadradoViewModel.
         */
        final Observer<String> observer = new Observer<String>() {
            /*
            el método onChanged se ejecuta cada vez que el observable emite datos.
            Lo que quiere decir que hemos de actualizar.
             */
            @Override
            public void onChanged(@Nullable String resultado) {
                tvAlCuadrado.setText(resultado);
            }
        };

        /*
        Tenemos el Observer y el observable. Ahora toca subscribir el observer al observable
        y así pueda estar notificado de cada cambio.
        .observe(this, listObserver)-> le decimos al observable que observer se va a
        subcibir a el.
        El propietario del ciclo de vida de ese LiveData en este caso es this.
         */

        alCuadradoViewModel.getResultado().observe(this, observer);
    }
}
