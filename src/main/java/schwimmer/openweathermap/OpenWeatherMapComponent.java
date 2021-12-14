package schwimmer.openweathermap;

import dagger.Component;

@Component(modules = OpenWeatherMapModule.class)
public interface OpenWeatherMapComponent {

    OpenWeatherMapController controller();

}
