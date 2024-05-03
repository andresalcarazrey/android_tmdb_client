package com.politecnicomalaga.tmdbclient.control;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.politecnicomalaga.tmdbclient.data.RequestClient;
import com.politecnicomalaga.tmdbclient.model.MovieSerieItem;

import java.util.List;

/*
* Una clase ViewModel se hace para mantener los datos a mostrar en una activity
* Usualmente, por ejemplo, listas para un RV
* Simplemente hace un extends de ViewModel
* Se suele poner un método getResults para el método de instanciación inicial de la fuente de datos.
* Otro método loadData (es el que se usa para pedir al vm que cargue datos, incluso getResults lo usa también
* Y por último un método setData que actualiza los datos que tenga el objeto RequestClient dentro del vm
* Realmente el setData es llamado desde el RequesClient para "avisar" al vm de que sus datos de internet "han
* llegado"
*
* Para dar "protección" a nuestros datos de modelo, se encapsula la lista de resultados en un objeto MutableLiveData (Android)
* Esto es una de las formas, de las más usadas. No hay que aprender nada más que:
* Hay que declarar "listaResultados" como se ve en el ejemplo
* Y después en el setData, llamar al método especial postValue
*
* El método loadData (yo lo he llamado así, se puede llamar como queráis, aquí no hay override) es el que
* se ayuda de un RequestClient para solicitar nueva info al Server de internet.
 */
public class MoviesViewModel extends ViewModel {

    //Siempre es habitual meter la listadeloquesea como MutableLiveData<List<ClaseItemLaQueSea>>
    private MutableLiveData<List<MovieSerieItem>> listaResultados;

    //Es necesario que el vm recuerde a quién le pide la info, pues cuando este Client esté listo nos
    //avisará con un "setData"
    private RequestClient myRequest;
    public LiveData<List<MovieSerieItem>> getResults() {
        if (listaResultados == null) {
            listaResultados = new MutableLiveData<List<MovieSerieItem>>();
            //Por defecto, mostramos las pelis
            loadData(RequestClient.TipoBusqueda.MOVIES);
        }
        return listaResultados;
    }

    public void loadData(RequestClient.TipoBusqueda tipo) {
        // Do an asynchronous operation to fetch data.
        myRequest = new RequestClient(this);
        myRequest.getDataFromRESTAPI(tipo, "");
        this.setData();
    }

    public void setData() {
        listaResultados.postValue(myRequest.getListData());
    }

}
