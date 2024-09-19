package hexlet.code.rules;

import java.util.Map;

public class MapSizeRule implements Rule<Object> {
    private final int min;

    public MapSizeRule(int min) {
        this.min = min;
    }

    @Override
    public boolean isSatisfied(Object data) {
        return ((Map<?, ?>) data).size() == min;
    }
}
