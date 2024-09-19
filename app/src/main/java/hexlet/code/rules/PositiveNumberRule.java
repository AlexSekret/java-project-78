package hexlet.code.rules;

public class PositiveNumberRule implements Rule<Object> {
    @Override
    public boolean isSatisfied(Object data) {
        if (data == null) {
            return true;
        }
        return (Integer) data > 0;
    }
}
