package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.string();
        schema.required().minLength(10).contains("abc");
        System.out.println(schema);
        var schema2 = v.string();
        System.out.println(schema2);
    }
}
