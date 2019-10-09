package ru.leonchenko.spring.chopchopsushi.data;

import ru.leonchenko.spring.chopchopsushi.Ingredient;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
