package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    @Test
    public void isValidNullAndEmptyStringNoRequiredTest() {
        var v = new Validator();
        var schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void isValidNullAndEmptyStringRequiredTest() {
        var v = new Validator();
        var schema = v.string().required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    public void isValidStringRequiredTest() {
        var v = new Validator();
        var schema = v.string().required();
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    public void isValidAfterContainsTest() {
        var v = new Validator();
        var schema = v.string().required();
        schema.contains("wh");
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("what"));
    }

    @Test
    public void isValidAfterMultipleContainsTest() {
        var v = new Validator();
        var schema = v.string().required();
        schema.contains("wh");
        assertTrue(schema.isValid("what does the fox say"));
        schema.contains("what");
        assertTrue(schema.isValid("what does the fox say"));
        schema.contains("whatthe");
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void isValidAfterMultipleValidatorsTest() {
        var v = new Validator();
        var schema = v.string().required();
        schema.contains("wh").contains("what").contains("whatthe");
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void isValidAfterMultipleValidatorsTest2() {
        var v = new Validator();
        var schema = v.string().required();
        schema.minLength(2).minLength(250);
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void isValidComplexExampleTest() {
        var v = new Validator();
        var schema = v.string();
        schema.required().minLength(2).minLength(5).contains("Alex");
        assertTrue(schema.isValid("Alex is stupid"));
    }
}
