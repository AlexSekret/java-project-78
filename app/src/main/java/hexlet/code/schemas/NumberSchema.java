package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        if (!super.isRequired) {
            super.isRequired = true;
        }
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> isPositive = (value -> {
            if (value == null) {
                return true;
            }
            return value > 0;
        });
        setRules("IsPositive", isPositive);
        return this;
    }

    public NumberSchema range(Integer start, Integer end) {
        Predicate<Integer> inRange = value -> value >= start && value <= end;
        setRules("InRange", inRange);
        return this;
    }
}
