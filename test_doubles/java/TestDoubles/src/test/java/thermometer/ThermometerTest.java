package thermometer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ThermometerTest {

    @Mock
    Sensor sensorStub;

    @Mock
    Display displayMock;

    @InjectMocks
    Thermometer fahrenheitThermometer = new Thermometer(DisplayMode.FAHRENHEIT);

    @InjectMocks
    Thermometer celsiusThermometer = new Thermometer(DisplayMode.CELSIUS);


    @Test
    public void update_fahrenheitConversionAndDisplayFormatting() {
        when(sensorStub.getTemperature()).thenReturn(1.13);
        fahrenheitThermometer.update();
        verify(displayMock).output("34.0 °F");
    }

    @Test
    public void update_noConversionNoDisplayFormatting() {
        when(sensorStub.getTemperature()).thenReturn(36.6);
        celsiusThermometer.update();
        verify(displayMock).output("36.6 °C");
    }


}
