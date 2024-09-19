package hexlet.code.rules;

public class NonEmptyStringRule implements Rule<Object> {
    @Override
    public boolean isSatisfied(Object data) {
        return !String.valueOf(data).isEmpty();
    }
}
