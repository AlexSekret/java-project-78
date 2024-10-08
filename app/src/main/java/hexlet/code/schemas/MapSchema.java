package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map> {

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        super.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int min) {
        setRules("IsSized", value -> value.size() == min);
        return this;
    }

    public <R> MapSchema shape(Map<String, BaseSchema<R>> schemas) {
        Predicate<Map> validate = value -> schemas.keySet().stream()
                .allMatch(key -> {
                    BaseSchema<R> baseSchema = schemas.get(key);
                    Object data = value.get(key);
                    return baseSchema.isValid((R) data);
                });
        setRules("Validate", validate);
        return this;
    }
}
