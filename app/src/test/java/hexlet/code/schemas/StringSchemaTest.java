package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    private static StringSchema schema;
    private static Validator validator;

    @BeforeEach
    public void setUpEach() {
        validator = new Validator();
        schema = validator.string();
    }

    @Test
    public void isValidNullAndEmptyStringNoRequiredTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void isValidNullAndEmptyStringRequiredTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    public void isValidStringRequiredTest() {
        schema.required();
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    public void isValidAfterContainsTest() {
        schema.required();
        schema.contains("wh");
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("what"));
    }

    @Test
    public void isValidAfterMultipleContainsTest() {
        schema.required();
        schema.contains("wh");
        assertTrue(schema.isValid("what does the fox say"));
        schema.contains("what");
        assertTrue(schema.isValid("what does the fox say"));
        schema.contains("whatthe");
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void isValidAfterMultipleValidatorsTest() {
        schema.required();
        schema.contains("wh").contains("what").contains("whatthe");
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void isValidAfterMultipleValidatorsTest2() {
        schema.required();
        schema.minLength(2).minLength(250).minLength(1).contains("ww").contains("fox");
        assertTrue(schema.isValid("what does the fox say"));
    }

    @Test
    public void isValidComplexExampleTest() {
        schema.required().minLength(2).minLength(5).contains("Alex");
        assertTrue(schema.isValid("Alex is stupid"));
        assertFalse(schema.isValid("no")); //символично получается))) Спорю сам с собой в тестах.
    }
}
