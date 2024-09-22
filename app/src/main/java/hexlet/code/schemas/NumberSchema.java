package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        super.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        setRules("IsPositive", value -> value == null || value > 0);
        return this;
    }

    public NumberSchema range(Integer start, Integer end) {
        setRules("InRange", value -> value >= start && value <= end);
        return this;
    }
}
