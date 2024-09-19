package hexlet.code.rules;

public class MinLengthRule implements Rule<Object> {
    private final Integer min;

    @Override
    public boolean isSatisfied(Object data) {
        return String.valueOf(data).length() > min;
    }

    public MinLengthRule(Integer min) {
        this.min = min;
    }
}
