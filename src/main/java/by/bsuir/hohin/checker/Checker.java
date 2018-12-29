package by.bsuir.hohin.checker;

import java.util.List;

public interface Checker<T> {
    public Boolean canProvide(List<T> entitiesList, T entity);
}
