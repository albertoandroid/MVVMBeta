package com.androiddesdecero.mvvmandroidbasico;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */
/*
ViewModel-> La clase viewmodel esta diseñada para almacenar y administrar datos relacionados
con la IU en una forma consciente del cicle de vida
La clase viewmodel permite que los datos sobrevian a los cambios de configuración, como son
las rotaciones de pantalla. El ViewModel no se destruye cuando hay un cambio de configuración,
la nueva instancia de el propietrio solo se reconectará al viewmodel existente.
El view model no debe obener referencia a la view es decir a la activity o fragment.


Como veremos más adelante además de proporcionar los datos al fragment o activity, tambien tendra
        la logica de negocio de nuestra aplicacióhn y el manjeo de datos para comunicarse con el modelo.
        Es decir que tambien será el encargado de comunicarse con el respositorio para obtener datos.
        O en nuestro caso con el UseCase para obtener la acción que queremos, en este caso calcular
        el cuadrado de un número.
        Importante: El viewModel no debe tener ninguna referencia a la View que pertenece.
        como vemos la clase view model es muy simple.
 */
public class AlCuadradoViewModel extends ViewModel {

    /*
    LiveData es un objeto observable y por lo tanto va a enviar a los observadores
    de manera reactiva los cabmiso y nos ahorra tocar la interfaz de usuario.
    Todo mucho más simple.
    Además otra de las grandes ventajas de LiveData es que es conciente del ciclo de vida
    lo que supone para los programadores que solo actulize a los observadores de componentes
    que se encuentren en estado de ciclo de vida activo. Es decir solo actualiza nuestra UI si
    se esta mostrando en pantalla.

     */

    private MutableLiveData<String> resultado;
    private AlCuadradoUseCase useCase;

    public AlCuadradoViewModel(){
        useCase = new AlCuadradoUseCase();
        resultado = new MutableLiveData<String>();
    }

    /*
    Necesitamos el metodo getResultado.
     */
    public LiveData<String> getResultado(){
        return resultado;
    }

    /*
    SetValue nos sirve para actualizar los datos del LiveData
     */
    public void alCuadrado(String data){
        resultado.setValue(useCase.alCuadrado(data));
    }
}
