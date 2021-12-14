package schwimmer.openweathermap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpenWeatherMapApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        OpenWeatherMapComponent component = DaggerOpenWeatherMapComponent.builder()
                .openWeatherMapModule(new OpenWeatherMapModule())
                .build();

        OpenWeatherMapController controller = component.controller();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/weather_application.fxml"));
        loader.setController(controller);

        Parent parent = loader.load();
        Scene scene = new Scene(parent, 600, 800);

        stage.setTitle("Weather Forecast");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

