package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        if (!super.isRequired) {
            super.isRequired = true;
        }
        Predicate<Object> empty = value -> !((String) value).isEmpty();
        setRules("IsEmpty", empty);
        return this;
    }

    public StringSchema minLength(int min) {
        Predicate<Object> minLength = value -> ((String) value).length() > min;
        setRules("MinLength", minLength);
        return this;
    }

    public StringSchema contains(String subString) {
        Predicate<Object> contains = value -> ((String) value).contains(subString);
        setRules("Contains", contains);
        return this;
    }
}
