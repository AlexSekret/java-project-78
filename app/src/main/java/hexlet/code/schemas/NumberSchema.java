package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
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
        Predicate<Object> isPositive = (value -> {
            if (value == null) {
                return true;
            }
            return (Integer) value > 0;
        });
        setRules("IsPositive", isPositive);
        return this;
    }

    public NumberSchema range(Integer start, Integer end) {
        Predicate<Object> inRange = value -> (Integer) value >= start && (Integer) value <= end;
        setRules("InRange", inRange);
        return this;
    }
}
