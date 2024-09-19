package hexlet.code.rules;

public interface Rule<T> {
    boolean isSatisfied(T data);
}
