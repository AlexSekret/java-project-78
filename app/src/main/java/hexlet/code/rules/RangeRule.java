package hexlet.code.rules;

public class RangeRule implements Rule<Object> {
    private final Integer start;
    private final Integer end;

    public RangeRule(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isSatisfied(Object data) {
        return ((Integer) data) >= start && ((Integer) data) <= end;
    }
}
