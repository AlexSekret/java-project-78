package hexlet.code.schemas;

import hexlet.code.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class BaseSchema {
    protected List<Rule<Object>> rules;

    public BaseSchema() {
        this.rules = new ArrayList<>();
    }

    public boolean isValid(Object data) {
        for (var rule : rules) {
            if (!rule.isSatisfied(data)) {
                return false;
            }
        }
        return true;
    }
}
