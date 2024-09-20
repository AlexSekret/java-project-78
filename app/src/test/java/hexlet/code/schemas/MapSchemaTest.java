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
        // shape позволяет описывать валидацию для значений каждого ключа объекта Map
        // Создаем набор схем для проверки каждого ключа проверяемого объекта
        // Для значения каждого ключа - своя схема
        Map<String, BaseSchema> schemas = new HashMap<>();

        // Определяем схемы валидации для значений свойств "firstName" и "lastName"
        // Имя должно быть строкой, обязательно для заполнения
        schemas.put("firstName", validator.string().required());
        // Фамилия обязательна для заполнения и должна содержать не менее 2 символов
        schemas.put("lastName", validator.string().required().minLength(2));

        // Настраиваем схему `MapSchema`
        // Передаем созданный набор схем в метод shape()
        schema.shape(schemas);

        // Проверяем объекты
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
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schemas.put("CardNumber", validator.string().required().minLength(19));
        schemas.put("Amount", validator.number().required().positive().range(1000, 5000));
        schema.shape(schemas);
        Map<String, Object> cardHolder = new HashMap<>();
        cardHolder.put("firstName", "John");
        cardHolder.put("lastName", "Smith");
        cardHolder.put("CardNumber", "12345678901234567890");
        cardHolder.put("Amount", 4500);
        assertTrue(schema.isValid(cardHolder));
    }
    @Test
    public void isValidMapVeryComplexTest4() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schemas.put("CardNumber", validator.string().required().minLength(19));
        schemas.put("Amount", validator.number().required().positive().range(1000, 5000));
        schema.shape(schemas);
        Map<String, Object> cardHolder = new HashMap<>();
        cardHolder.put("firstName", "John");
        cardHolder.put("lastName", "Smith");
        cardHolder.put("CardNumber", "12345678901234567890");
        cardHolder.put("Amount", 900);
        assertFalse(schema.isValid(cardHolder));
    }

}
