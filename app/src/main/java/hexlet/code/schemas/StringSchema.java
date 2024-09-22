package hexlet.code.schemas;


public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        super.isRequired = true;
        setRules("IsEmpty", value -> !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int min) {
        setRules("MinLength", value -> value.length() > min);
        return this;
    }

    public StringSchema contains(String subString) {
        setRules("Contains", value -> value.contains(subString));
        return this;
    }
}
