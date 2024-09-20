package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

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
        Predicate<Object> isSized = value -> ((Map) value).size() == min;
        setRules("IsSized", isSized);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> validate = ((value) -> {
            var schemaKeys = schemas.keySet();
            for (var key : schemaKeys) {
                var baseSchema = schemas.get(key);
                var data = ((Map<?, ?>) value).get(key);
                if (!baseSchema.isValid(data)) {
                    return false;
                }
            }
            return true;
        });
        setRules("Validate", validate);
        return this;
    }
}
