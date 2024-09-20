package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {

    protected Map<String, Predicate<Object>> rules;
    protected boolean isRequired;

    public BaseSchema() {
        this.isRequired = false;
        this.rules = new LinkedHashMap<>();
        Predicate<Object> nonNull = value -> !(value == null);
        this.rules.put("NonNull", nonNull);
    }

    public void setRules(String name, Predicate<Object> rule) {
        this.rules.put(name, rule);
    }

    public boolean isValid(Object data) {
        var isNull = !rules.get("NonNull").test(data);
        if (!isRequired && isNull) {
            return true;
        }
        for (var rule : rules.values()) {
            if (!rule.test(data)) {
                return false;
            }
        }
        return true;
    }
}
