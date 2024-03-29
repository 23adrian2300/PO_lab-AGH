package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static agh.ics.oop.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    void parseTest(MoveDirection[] expected, String[] input) {
        List<MoveDirection> output = new OptionsParser().parse(input);
        assertEquals(expected.length, output.size());
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], output.get(i));
    }
    @Test
    void parseTest() {
        parseTest(new MoveDirection[]{FORWARD}, new String[]{"f"});
        parseTest(new MoveDirection[]{BACKWARD}, new String[]{"b"});
        parseTest(new MoveDirection[]{LEFT}, new String[]{"l"});
        parseTest(new MoveDirection[]{RIGHT}, new String[]{"r"});
        assertThrows(IllegalArgumentException.class, () -> parseTest(new MoveDirection[]{}, new String[]{"nonsense"}));
        assertThrows(IllegalArgumentException.class, () -> parseTest(new MoveDirection[]{FORWARD, BACKWARD}, new String[]{"f", "nonsense", "b"}));
        parseTest(new MoveDirection[]{FORWARD, BACKWARD, LEFT, RIGHT}, new String[]{"f", "b", "l", "r"});
    }
}