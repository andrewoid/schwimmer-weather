package schwimmer.openweathermap;

import io.reactivex.rxjava3.core.Single;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OpenWeatherMapControllerTest {

    // Test to make sure that service.getCurrentWeather() is called
    // when initialize() is called.
    @Test
    public void initialize() {
        // given
        OpenWeatherMapService service = mock(OpenWeatherMapService.class);
        OpenWeatherMapController controller =
                new OpenWeatherMapController(service);
        doReturn(Single.never()).when(service).getCurrentWeather(
                "New York",
                "imperial");

        // when
        controller.initialize();

        // then
        verify(service).getCurrentWeather("New York", "imperial");
    }
}