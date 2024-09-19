package hexlet.code.schemas;

import hexlet.code.rules.PositiveNumberRule;
import hexlet.code.rules.RangeRule;
import hexlet.code.rules.RequiredRule;

public class NumberSchema extends BaseSchema<Number> {
    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
//        rules.add(new RequiredRule());
        mapRules.put("RequiredRule", new RequiredRule());
        return this;
    }

    public NumberSchema positive() {
//        rules.add(new PositiveNumberRule());
        mapRules.put("PositiveNumberRule", new PositiveNumberRule());
        return this;
    }

    public NumberSchema range(Integer start, Integer end) {
//        rules.removeIf(v -> v.getClass().equals(RangeRule.class));
//        rules.add(new RangeRule(start, end));
        mapRules.put("RangeRule", new RangeRule(start, end));
        return this;
    }
}
