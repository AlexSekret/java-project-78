package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {
    private static Validator validator;
    private static MapSchema schema;

    @BeforeEach
    public void setUpEach() {
        validator = new Validator();
        schema = validator.map();
    }

    @Test
    public void isValidMapVeryComplexTest() {
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void isValidMapVeryComplexChainingTest() {
        schema.required().sizeof(2);
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void isValidMapVeryComplexTest2() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }

    @Test
    public void isValidMapVeryComplexTest3() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schemas.put("CardNumber", validator.string().required().minLength(19));
        schema.shape(schemas);
        Map<String, Object> cardHolder = new HashMap<>();
        cardHolder.put("firstName", "John");
        cardHolder.put("lastName", "Smith");
        cardHolder.put("CardNumber", "12345678901234567890");
        assertTrue(schema.isValid(cardHolder));
    }

    @Test
    public void isValidMapVeryComplexTest4() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schemas.put("CardNumber", validator.string().required().minLength(19));
        schema.shape(schemas);
        Map<String, Object> cardHolder = new HashMap<>();
        cardHolder.put("firstName", "John");
        cardHolder.put("lastName", "Smith");
        cardHolder.put("CardNumber", "1234567890123456789");
        assertFalse(schema.isValid(cardHolder));
    }

    @Test
    public void isValidNumbersMapTest() {
        Map<String, BaseSchema<Integer>> schemas = new HashMap<>();
        schemas.put("1", validator.number().required());
        schemas.put("2", validator.number().required().range(2, 4));
        schemas.put("+3", validator.number().required().positive());
        schema.shape(schemas);
        Map<String, Object> validationMap = new HashMap<>();
        validationMap.put("1", 1);
        validationMap.put("2", 3);
        validationMap.put("+3", 4);
        assertTrue(schema.isValid(validationMap));

        validationMap.put("+3", -4);
        assertFalse(schema.isValid(validationMap));
    }

}
