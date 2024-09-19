package hexlet.code.rules;

public class RequiredRule implements Rule<Object> {
    @Override
    public boolean isSatisfied(Object data) {
        return  data != null;
    }
}
