package ru.leonchenko.spring.chopchopsushi.data;

import org.springframework.data.repository.CrudRepository;
import ru.leonchenko.spring.chopchopsushi.Ingredient;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

//  Iterable<Ingredient> findAll();
//
//  Ingredient findById(String id);
//
//  Ingredient save(Ingredient ingredient);
  
}
