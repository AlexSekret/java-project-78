package hexlet.code.schemas;

import hexlet.code.rules.ContainsRule;
import hexlet.code.rules.MinLengthRule;
import hexlet.code.rules.NonEmptyStringRule;
import hexlet.code.rules.RequiredRule;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        rules.add(new RequiredRule());
        rules.add(new NonEmptyStringRule());
        return this;
    }

    //I have a Big troubles with a Big O  :(((
    public StringSchema minLength(int min) {
        rules.removeIf(v -> v.getClass().equals(MinLengthRule.class));
        rules.add(new MinLengthRule(min));
        return this;
    }

    public StringSchema contains(String subString) {
        rules.removeIf(v -> v.getClass().equals(ContainsRule.class));
        rules.add(new ContainsRule(subString));
        return this;
    }
}
