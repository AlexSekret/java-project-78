package hexlet.code.schemas;

import hexlet.code.rules.ContainsRule;
import hexlet.code.rules.MinLengthRule;
import hexlet.code.rules.NonEmptyStringRule;
import hexlet.code.rules.RequiredRule;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
//        rules.add(new RequiredRule());
//        rules.add(new NonEmptyStringRule());
        mapRules.put("RequiredRule", new RequiredRule());
        mapRules.put("NonEmptyStringRule", new NonEmptyStringRule());
        return this;
    }

    //With a Big O  I have a Big T(roubles) :(((
    public StringSchema minLength(int min) {
//        rules.removeIf(v -> v.getClass().equals(MinLengthRule.class));
//        rules.add(new MinLengthRule(min));
        mapRules.put("MinLengthRule", new MinLengthRule(min));
        return this;
    }

    public StringSchema contains(String subString) {
//        rules.removeIf(v -> v.getClass().equals(ContainsRule.class));
//        rules.add(new ContainsRule(subString));
        mapRules.put("ContainsRule", new ContainsRule(subString));
        return this;
    }
}
