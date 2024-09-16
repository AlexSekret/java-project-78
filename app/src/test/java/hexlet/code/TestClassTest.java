package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClassTest {

    @Test
    void return42Test() {
        var expected = "42";
        assertEquals(expected,TestClass.return42());
    }
}