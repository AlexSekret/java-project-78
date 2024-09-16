package hexlet.code.schemas;

import lombok.ToString;

@ToString
public class StringSchema {
    private boolean required;
    private int minLength;
    private String contains;

    public StringSchema() {
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int min) {
        this.minLength = min;
        return this;
    }

    public StringSchema contains(String subString) {
        this.contains = subString;
        return this;
    }
}
