package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        if (!super.isRequired) {
            super.isRequired = true;
        }
        Predicate<String> empty = value -> !value.isEmpty();
        setRules("IsEmpty", empty);
        return this;
    }

    public StringSchema minLength(int min) {
        Predicate<String> minLength = value -> value.length() > min;
        setRules("MinLength", minLength);
        return this;
    }

    public StringSchema contains(String subString) {
        Predicate<String> contains = value -> value.contains(subString);
        setRules("Contains", contains);
        return this;
    }
}
