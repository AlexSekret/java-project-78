package hexlet.code.schemas;

import hexlet.code.rules.MapSizeRule;
import hexlet.code.rules.RequiredRule;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        rules.add(new RequiredRule());
        return this;
    }

    public MapSchema sizeof(int min) {
        rules.add(new MapSizeRule(min));
        return this;
    }
}
