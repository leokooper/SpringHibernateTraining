package ru.leonchenko.spring.chopchopsushi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
