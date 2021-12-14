package schwimmer.openweathermap;

import dagger.Module;
import dagger.Provides;

@Module
public class OpenWeatherMapModule {

    @Provides
    public OpenWeatherMapService providesOpenWeatherMapService(
            OpenWeatherMapServiceFactory factory
    ) {
        return factory.newInstance();
    }

}
