package schwimmer.openweathermap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;

/**
 * Create OpenWeatherMapService classes using Retrofit.
 */
public class OpenWeatherMapServiceFactory {

    @Inject
    public OpenWeatherMapServiceFactory() {

    }

    public OpenWeatherMapService newInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        return service;
    }

}
