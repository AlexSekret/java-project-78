package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSchemaTest {
    private static String filledStringSchema;
    private static String emptyStringSchema;

    @BeforeAll
    public static void setUp() {
        filledStringSchema = "StringSchema(required=true, minLength=10, contains=abc)";
        emptyStringSchema = "StringSchema(required=false, minLength=0, contains=null)";
    }

    @Test
    public void test1() {

        var v = new Validator();
        var actual = v.string().required().minLength(10).contains("abc").toString();
        assertEquals(filledStringSchema, actual);
    }

    @Test
    public void test2() {
        var v = new Validator();
        var actual = v.string().toString();
        assertEquals(emptyStringSchema, actual);
    }
}
