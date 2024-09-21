package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        if (!super.isRequired) {
            super.isRequired = true;
        }
        return this;
    }

    public MapSchema sizeof(int min) {
        Predicate<Map> isSized = value -> value.size() == min;
        setRules("IsSized", isSized);
        return this;
    }

    public <R> MapSchema shape(Map<String, BaseSchema<R>> schemas) {
        Predicate<Map> validate = ((value) -> {
            var schemaKeys = schemas.keySet();
            for (var key : schemaKeys) {
                var baseSchema = schemas.get(key);
                var data = value.get(key);
                if (!baseSchema.isValid((R) data)) {
                    return false;
                }
            }
            return true;
        });
        setRules("Validate", validate);
        return this;
    }
}
