import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {


    @org.junit.jupiter.api.Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();
        IntStream.range(0, 30).forEach(i -> horses.add(new Horse("II",1,2)));
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses,hippodrome.getHorses());
    }

    @org.junit.jupiter.api.Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        IntStream.range(0, 50).forEach(i -> horses.add(mock(Horse.class)));
        new Hippodrome(horses).move();
        for (Horse horse: horses) {
            verify(horse).move();
        }



    }

    @org.junit.jupiter.api.Test
    void getWinner() {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("123",2.4,1.5));
        horses.add(new Horse("qwer",2.1,2));
        horses.add(new Horse("asd",2.7,4));
        horses.add(new Horse("zxc",2.2,1));
        Hippodrome hippodrome = new Hippodrome(horses);
        assertSame(horses.get(2),hippodrome.getWinner());

    }

    @org.junit.jupiter.api.Test
    void whenHippodromeClassNotNull(){
        assertThrows(IllegalArgumentException.class,()-> new Hippodrome(null));
    }
    @org.junit.jupiter.api.Test
    void whenHippodromeClassNotEmpty(){
        assertThrows(IllegalArgumentException.class,()-> new Hippodrome(new ArrayList<>()));
    }
    @org.junit.jupiter.api.Test
    void whenHippodromeThrowExceptionNull(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }
    @org.junit.jupiter.api.Test
    void whenHippodromeThrowExceptionEmpty(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }


}