package by.bsuir.hohin.checker;

import by.bsuir.hohin.entity.Bus;

import java.util.List;

public abstract class CheckersChain<T> implements Checker<T> {

    private Checker<T> next;

    public Checker<T> linkWith(Checker<T> next) {
        this.next = next;
        return next;
    }

    protected boolean checkNext(List<T> entitiesList, T entity) {
        if (next == null) {
            return true;
        }
        return next.canProvide(entitiesList, entity);
    }
}

