package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @param <T> Тип, которым типизируется класс наследник
 */
public class BaseSchema<T> {

    protected Map<String, Predicate<T>> rules;
    protected boolean isRequired;

    public BaseSchema() {
        this.isRequired = false;
        this.rules = new LinkedHashMap<>();
        Predicate<T> nonNull = value -> !(value == null);
        this.rules.put("NonNull", nonNull);
    }

    /**
     * @param name Ключ - название правила валидации
     * @param rule Правило валидации
     */
    public void setRules(String name, Predicate<T> rule) {
        this.rules.put(name, rule);
    }

    public final boolean isValid(T data) {
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
