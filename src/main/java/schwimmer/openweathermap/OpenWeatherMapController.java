package schwimmer.openweathermap;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;

public class OpenWeatherMapController {

    private final OpenWeatherMapService service;

    public OpenWeatherMapController(OpenWeatherMapService service) {
        this.service = service;
    }

    public void initialize() {
        Disposable disposable = service.getCurrentWeather("New York", "imperial")
                // request the data in the background
                .subscribeOn(Schedulers.io())
                // work with the data in the foreground
                .observeOn(Schedulers.trampoline())
                .subscribe(this::onCurrentWeather, this::onError);
    }

    private void onCurrentWeather(OpenWeatherMapFeed openWeatherMapFeed) {
        Platform.runLater(() -> onCurrentWeatherRunLater(openWeatherMapFeed));
    }

    private void onCurrentWeatherRunLater(OpenWeatherMapFeed openWeatherMapFeed) {
        // Update your TextFields
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
    }


}
