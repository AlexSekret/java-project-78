package hexlet.code.schemas;

import lombok.ToString;

import java.util.ArrayList;

@ToString
public class StringSchema {
    private boolean required = false;
    private Integer minLength = null;
    private String contains = null;

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

    //с этой херней надо что-то делать. Этот метод должен быть в классе-родителе
    public boolean isValid(String text) {
        var validState = new ArrayList<>();
        if (!this.required && ((text == null) || text.isEmpty())) {
            validState.add(true);
        }
        if (this.required && ((text != null) && !text.isEmpty())) {
            validState.add(true);
        }
        if (this.required && ((text == null) || text.isEmpty())) {
            validState.add(false);
        }
        if (this.contains != null && text != null) {
            validState.add(text.contains(this.contains));
        }
        if (this.minLength != null && text != null) {
            validState.add(text.length() >= minLength);
        }
        return validState.stream()
                .allMatch(v -> v.equals(true));
    }
}
