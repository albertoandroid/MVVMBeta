package com.androiddesdecero.mvvmandroidbasico;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

/*
En nuestro caso en vez del patrón repositorio lo vamos a dejar un un caso de uso.
 Es decir de esta manera.
Un caso de uso representa nuestras acciones de negocio. Es decir lo que
queremos que haga para ese caso de uso la aplicación. Lo ideal es tener un
caso de uso para cada acción de negocio de nuestra app.
El use case no tiene que tener ninguna referencia a quien lo activa ni como
esos datos serán mostrados. Es decir tiene que estar encapsulado. Nuestro caso
de uso será encargado de hacer el cuadro de un un número.
 */
public class AlCuadradoUseCase {

    private double resultado;
    public AlCuadradoUseCase(){

    }

    public String alCuadrado(String data){
        if(data.equals("")){
            return "Campo Vacio";
        }else{
            resultado = Double.valueOf(data)*Double.valueOf(data);
            return String.valueOf(resultado);
        }
    }
}
