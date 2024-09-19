package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    private static Validator validator;
    private static NumberSchema schema;

    @BeforeEach
    public void setUpEach() {
        validator = new Validator();
        schema = validator.number();
    }

    @Test
    public void isValidWithNoRules() {
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void isValidPositiveWithNoRules() {
        schema.positive();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void isValidWithRequired() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }

    @Test
    public void isValidWithRequiredPositive() {
        schema.required().positive();
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
    }

    @Test
    public void isValidWithRequiredPositiveRange() {
        schema.required().positive().range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}
