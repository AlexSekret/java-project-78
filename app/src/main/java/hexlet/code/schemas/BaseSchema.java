package hexlet.code.schemas;

import hexlet.code.rules.Rule;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseSchema<T> {
    //    protected List<Rule<Object>> rules;
    protected Map<String, Rule<Object>> mapRules;

    public Rule<Object> getRules(String key) {
        return mapRules.get(key);
    }

    public BaseSchema() {
//        this.rules = new ArrayList<>();
        this.mapRules = new LinkedHashMap<>();
    }

    //TODO: переосмыслить логику работы метода? Похоже нужно работать с мапами.
//    public boolean isValid(Object data) {
//        for (var rule : rules) {
//            if (!rule.isSatisfied(data)) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isValid(T data) {
        if (data != null && data instanceof Map<?, ?>) {
            for (var key : ((Map<?, ?>) data).keySet()) {
                var value = ((Map<?, ?>) data).get(key);
                if (!mapRules.get(key).isSatisfied(value)) {
                    return false;
                }
            }
        } else {
            for (var rule : mapRules.values()) {
                if (!rule.isSatisfied(data)) {
                    return false;
                }
            }
        }
        return true;
    }
}
