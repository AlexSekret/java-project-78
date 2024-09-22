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
        this.rules.put("NonNull", value -> value != null);
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
        return rules.values().stream()
                .allMatch(rule -> rule.test(data));
    }
}
