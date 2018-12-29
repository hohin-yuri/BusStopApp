package by.bsuir.hohin.parser;

import java.text.ParseException;

public interface StringParser<T> {
    public T parse(final String info) throws ParseException;
}
