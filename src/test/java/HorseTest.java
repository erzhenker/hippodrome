import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;

class HorseTest {


    @Test
    void getName() {
        Horse horse = new Horse("Иа",2.0);
        assertEquals( "Иа",horse.getName());
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("Иа",2.0);
        assertEquals( 2.0,horse.getSpeed());
    }

    @Test
    void getDistance() {
        Horse horse1 = new Horse("Иа",1.0, 0.2);
        assertEquals(0.2, horse1.getDistance());
        Horse horse2 = new Horse("Ослик Иа", 1.0);
        assertEquals(0,horse2.getDistance());
    }

    @Test
    void moveWithRandom() {
        try (MockedStatic<Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            new Horse("Иа", 1.1, 1.2).move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    void whenHorseConstructorExceptionName() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1.1, 1.1));
    }

    @Test
    void whenHorseConstructorThrowExceptionNameAssertEquals() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 1.1, 1.1));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "\t\t","\n", "    " })
    void whenHorseConstructorNameWrongName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1.1, 1.1));
    }
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "\t\t","\n", "    " })
    void whenHorseConstructorThrowExceptionBlankName(String name) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, 1.1, 1.1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }
    @Test
    void whenHorseConstructorExceptionSpeed() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Иа", -1.1, 1.1));
    }

    @Test
    void whenHorseConstructorThrowExceptionSpeed() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Иа", -1.1, 1.1));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }
    @Test
    void whenHorseConstructorExceptionDistance() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Иа", 1.1, -1.1));
    }
    @Test
    void whenHorseConstructorThrowExceptionDistance() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("Иа", 1.1, -1.1));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

}