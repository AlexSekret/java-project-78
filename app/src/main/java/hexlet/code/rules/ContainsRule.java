package hexlet.code.rules;

public class ContainsRule implements Rule<Object> {
    private final String substring;


    @Override
    public boolean isSatisfied(Object data) {
        return String.valueOf(data).contains(substring);
    }

    public ContainsRule(String text) {
        this.substring = text;
    }
}
