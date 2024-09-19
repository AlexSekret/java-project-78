package hexlet.code.schemas;

import hexlet.code.rules.MapSizeRule;
import hexlet.code.rules.RequiredRule;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema() {
        super();
    }

    public MapSchema required() {
//        rules.add(new RequiredRule());
        mapRules.put("RequiredRule", new RequiredRule());
        return this;
    }

    public MapSchema sizeof(int min) {
//        rules.add(new MapSizeRule(min));
        mapRules.put("MapSizeRule", new MapSizeRule(min));
        return this;
    }

    //is it need to implement deep copy?
    //TODO: переосмыслить логику работы метода? Похоже нужно работать с мапами.
    //Базовый класс должен хранить проверки в другой структуре данных? Отличной от ArrayList?
    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        var keys = schemas.keySet();
        for (var key : keys) {
            mapRules.put(key, schemas.get(key).getRules(key));
        }
        return this;
    }
}
